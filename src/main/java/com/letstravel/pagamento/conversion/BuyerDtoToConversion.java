package com.letstravel.pagamento.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.letstravel.pagamento.api.BuyerDto;
import com.letstravel.pagamento.entity.Buyer;

@Component
public class BuyerDtoToConversion implements Converter<BuyerDto, Buyer> {
	
	@Override
	public Buyer convert(BuyerDto buyerDto) {
		Buyer buyer = new Buyer();
		buyer.setCpf(buyerDto.getCpf());
		buyer.setEmail(buyerDto.getEmail());
		buyer.setName(buyerDto.getName());

		return buyer;
	}
}
