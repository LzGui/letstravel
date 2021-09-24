package com.letstravel.pagamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.letstravel.pagamento.entity.CreditCard;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CardInvalidException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CreditCard creditCard;

	public CardInvalidException(CreditCard creditCard) {
		// TODO Auto-generated constructor stub
	}

	public void InvalidCardException(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
}
