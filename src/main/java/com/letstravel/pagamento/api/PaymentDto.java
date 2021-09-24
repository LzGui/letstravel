package com.letstravel.pagamento.api;

import java.time.LocalDate;

import com.letstravel.pagamento.entity.Billet;
import com.letstravel.pagamento.entity.Buyer;
import com.letstravel.pagamento.entity.Card;
import com.letstravel.pagamento.entity.Client;
import com.letstravel.pagamento.entity.Payment;
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
public class PaymentDto {
	private String idPayment;
	private Double valuePayment;
	private LocalDate registrationDate;
	private FormPayment formPayment;
	private Card card;
	private Billet billet;
	private Client client;
	private Buyer buyer;
	private Status status;

	public PaymentDto(Payment pay) {
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
}
