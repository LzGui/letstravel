package com.letstravel.pagamento.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.letstravel.pagamento.api.CardDto;
import com.letstravel.pagamento.entity.CreditCard;

@Component
public class CardDtoToConversion implements Converter<CardDto, CreditCard>{
	@Override
	public CreditCard convert(CardDto cardDto) {
		CreditCard card = new CreditCard();
		card.setDateExpiration(cardDto.getDateExpiration());
		card.setName(cardDto.getName());
		card.setNumber(cardDto.getNumber());
		card.setCvv(card.getCvv());
		return card;
	}
}
