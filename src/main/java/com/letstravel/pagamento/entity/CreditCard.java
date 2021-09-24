package com.letstravel.pagamento.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreditCard extends Card {

	private String cvv;

	@Override
	public String toString() {
		return "CartaoCredito [CVV = " + cvv + "]";
	}
}
