package com.letstravel.pagamento.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letstravel.pagamento.entity.CreditCard;
import com.letstravel.pagamento.enums.TypeCard;
import com.letstravel.pagamento.exception.CardInvalidException;
import com.letstravel.pagamento.repository.CardRepository;

@Service
public class CardService {
	
	@Autowired
	private CardRepository cardRepository;

	public boolean validateCard(CreditCard creditCard) {
		if (!validateNumberCard(creditCard.getNumber())) {
			throw new CardInvalidException(creditCard);
		}

		if (!validateDateExpiration(creditCard.getDateExpiration())) {
			throw new CardInvalidException(creditCard);
		}

		if (!validateCvvCard(creditCard.getCvv())) {
			throw new CardInvalidException(creditCard);
		}

		return true;
	}

	public boolean validateNumberCard(String numCard) {
		Integer numString;
		int soma = 0;

		if (numCard.length() <= 15) {
			for (int i = 0; i < numCard.length(); i++) {
				numString = Integer.parseInt(numCard.substring(i, i + 1));

				if (i % 2 == 0) {
					soma += numString;
				} else {
					if ((numString * 2) > 9) {
						soma += ((numString * 2) - 9);
					} else {
						soma += (numString * 2);
					}
				}
			}
		}
		if (numCard.length() >= 16) {
			for (int i = 0; i < numCard.length(); i++) {
				numString = Integer.parseInt(numCard.substring(i, i + 1));

				if (i % 2 == 0) {
					if (numString * 2 > 9) {
						soma += (numString * 2 - 9);
					} else {
						soma += (numString * 2);
					}
				} else {
					soma += numString;
				}
			}
		}
		return soma % 10 == 0;
	}
	
	public boolean validateCvvCard(String cvv) {
		if (Objects.isNull(cvv)) {
			return false;
		}
		
		try {
			cvv = cvv.trim();
			if (Integer.parseInt(cvv) < 1 || cvv.length() != 3) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public boolean validateDateExpiration(LocalDate dateExpiration) {
		if (Objects.isNull(dateExpiration) || LocalDate.now().isAfter(dateExpiration)) {
			return false;
		}
		return true;
	}
	
	public TypeCard identifyTypeCard(String numCard) {
		List<String> listElo = Arrays.asList("636368", "438935", "504175", "451416", "509048", "509067", "509049",
				"509069", "509050", "509074", "509068", "509040", "509045", "509051", "509046", "509066", "509047",
				"509042", "509052", "509043", "509064", "509040", "36297", "5067", "4576", "4011");

		for (String num : listElo) {
			if (num.equals(numCard.substring(0, num.length()))) {
				return TypeCard.ELO;
			}
		}

		if ("34".equals(numCard.substring(0, 2)) || "37".equals(numCard.substring(0, 2))) {
			return TypeCard.AMERICAN_EXPRESS;
		}

		if ("38".equals(numCard.substring(0, 2)) || "60".equals(numCard.substring(0, 2))) {
			return TypeCard.HIPERCARD;
		}

		if ("4".equals(numCard.substring(0, 1))) {
			return TypeCard.VISA;
		}

		if ("5".equals(numCard.substring(0, 1))) {
			return TypeCard.MASTERCARD;
		}

		return TypeCard.UNKNOWN;
	}

	public CreditCard saveCard(CreditCard creditCard) {
		return cardRepository.save(creditCard);
	}
}
