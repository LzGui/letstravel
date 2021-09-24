package com.letstravel.pagamento.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestPaymentDto {
	private PaymentDto payment;
	private ClientDto client;
	private BuyerDto buyer;
	
	public RequestPaymentDto(PaymentDto payment) {
		this.setPayment(getPayment());
		this.setClient(getClient());
		this.setBuyer(getBuyer());
	}
}
