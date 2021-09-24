package com.letstravel.pagamento.entity;

import java.time.LocalDate;

import com.letstravel.pagamento.api.PaymentDto;
import com.letstravel.pagamento.enums.FormPayment;
import com.letstravel.pagamento.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	private String idPayment;
	private Double valuePayment;
	private LocalDate registrationDate;
	private FormPayment formPayment;
	private Card card;
	private Billet billet;
	private Client client;
	private Buyer buyer;
	private Status status;
	private Long numberBillet;
	
	public Payment(PaymentDto pay) {
		this.setIdPayment(pay.getIdPayment());
		this.setValuePayment(pay.getValuePayment());
		this.setRegistrationDate(pay.getRegistrationDate());
		this.setFormPayment(pay.getFormPayment());
		this.setCard(pay.getCard());
		this.setBillet(pay.getBillet());
		this.setClient(pay.getClient());
		this.setBuyer(pay.getBuyer());
		this.setStatus(pay.getStatus());
	}

	@Override
	public String toString() {
		return "Pagamento [idPagamento=" + idPayment 
				+ ", valor=" + valuePayment 
				+ ", dataCadastro=" + registrationDate
				+ ", forma=" + formPayment 
				+ ", cartao=" + card 
				+ ", boleto=" + billet 
				+ ", cliente=" + client
				+ ", comprador=" + buyer 
				+ ", status=" + status + "]";
	}

}