package com.letstravel.pagamento.service;

import java.time.LocalDate;

import org.springframework.core.convert.ConversionService;
import org.springframework.util.ObjectUtils;

import com.letstravel.pagamento.api.ReplyPaymentDto;
import com.letstravel.pagamento.api.RequestPaymentDto;
import com.letstravel.pagamento.entity.Billet;
import com.letstravel.pagamento.entity.Buyer;
import com.letstravel.pagamento.entity.Client;
import com.letstravel.pagamento.entity.CreditCard;
import com.letstravel.pagamento.entity.Payment;
import com.letstravel.pagamento.enums.FormPayment;
import com.letstravel.pagamento.enums.Status;
import com.letstravel.pagamento.repository.PaymentRepository;

public class PaymentService {
	private PaymentRepository paymentRepository;

	private CardService cardService;

	private BuyerService buyerService;

	private BilletService billetService;

	private ConversionService conversionService;

	public ReplyPaymentDto makePayment(RequestPaymentDto requestPaymentDto) {

		Payment pay = conversionService.convert(requestPaymentDto.getPayment(), Payment.class);

		// Converte cliente e atribui no pagamento
		Client client = conversionService.convert(requestPaymentDto.getClient(), Client.class);
		pay.setClient(client);

		// Verifica se existe o comprador
		Buyer buyer = buyerService.get(requestPaymentDto.getBuyer().getCpf());
		if (!ObjectUtils.isEmpty(buyer)) {
			pay.setBuyer(buyer);
		} else {
			Buyer newBuyer = conversionService.convert(requestPaymentDto.getBuyer(), Buyer.class);
			pay.setBuyer(newBuyer);
		}

		// Verifica a forma de pagamento
		if (FormPayment.CARTAO_CREDITO.equals(pay.getFormPayment())) {
			CreditCard cc = (CreditCard) pay.getCard();
			cardService.validateCard(cc);
			cc.setTypeCard(cardService.identifyTypeCard(cc.getNumber()));
			pay.setCard(cardService.saveCard(cc));
			pay.setStatus(Status.ENVIADO);

		} else if (FormPayment.BOLETO.equals(pay.getFormPayment())) {
			Billet billet = billetService.generateBillet();
			pay.setBillet(billetService.saveBillet(billet));
			pay.setStatus(Status.PROCESSANDO);
		}
		pay.setRegistrationDate(LocalDate.now());

		Payment payment = paymentRepository.save(pay);

		ReplyPaymentDto replyPaymentDto = new ReplyPaymentDto();
		replyPaymentDto.setIdPayment(payment.getIdPayment());
		replyPaymentDto.setValuePayment(payment.getValuePayment());
		replyPaymentDto.setFormPayment(payment.getFormPayment());
		replyPaymentDto.setStatus(payment.getStatus());
		if (FormPayment.BOLETO.equals(payment.getFormPayment())) {
			replyPaymentDto.setNumberBillet(payment.getBillet().getNumberBillet());
		}
		return replyPaymentDto;
	}

	public Payment searchPayment(String idPayment) {
		Payment pay = paymentRepository.findById(idPayment).orElse(null);
		if (ObjectUtils.isEmpty(pay)) {
			return null;
		}
		String newCpf = this.hideCPF(pay.getBuyer().getCpf());
		pay.getBuyer().setCpf(newCpf);
		return pay;
	}

	public String hideCPF(String cpf) {
		if (ObjectUtils.isEmpty(cpf)) {
			return null;
		}
		String newCpf = "";
		for (int x = 0; x < cpf.length() - 2; x++) {
			newCpf += "*";
		}
		return newCpf + cpf.substring(cpf.length() - 2);
	}

	public boolean removePayment(String idPayment) {
		Payment pay = paymentRepository.findById(idPayment).orElse(null);
		if (ObjectUtils.isEmpty(pay)) {
			return false;
		}
		paymentRepository.delete(pay);
		return true;
	}
}
