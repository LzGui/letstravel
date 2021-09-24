package com.letstravel.pagamento.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.letstravel.pagamento.api.PaymentDto;
import com.letstravel.pagamento.entity.Payment;
import com.letstravel.pagamento.enums.FormPayment;
import com.letstravel.pagamento.exception.CardInvalidException;

@Component
public class PaymentDtoToConversion implements Converter<PaymentDto, Payment>{
	@Autowired
	private CardDtoToConversion cardConvert;

	@Override
	public Payment convert(PaymentDto paymentDto) {
		Payment payment = new Payment();
		if (FormPayment.CARTAO_CREDITO.equals(paymentDto.getFormPayment())) {
			if (ObjectUtils.isEmpty(paymentDto.getCard())) {
				throw new CardInvalidException(null);
			}
			payment.setCartao(cardConvert.convert(paymentDto.getCard()));
		}

		payment.setFormPayment(paymentDto.getFormPayment());
		payment.setValuePayment(paymentDto.getValuePayment());
		return payment;
	}
}
