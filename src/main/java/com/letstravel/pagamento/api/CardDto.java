package com.letstravel.pagamento.api;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.letstravel.pagamento.entity.Card;
import com.letstravel.pagamento.enums.TypeCard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
	
	@Id
	private String idCard;
	private String name;
	private String number;
	private LocalDate dateExpiration;
	private TypeCard typeCard;
	
	public CardDto(Card c) {
		this.setIdCard(c.getIdCard());
		this.setName(c.getName());
		this.setNumber(c.getNumber());
		this.setDateExpiration(c.getDateExpiration());
		this.setTypeCard(c.getTypeCard());
	}
}
