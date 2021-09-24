package com.letstravel.pagamento.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.letstravel.pagamento.api.CardDto;
import com.letstravel.pagamento.enums.TypeCard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Card {
	
	@Id
	private String idCard;
	private String name;
	private String number;
	private LocalDate dateExpiration;
	private TypeCard typeCard;
	
	public Card(CardDto c) {
		this.setIdCard(c.getIdCard());
		this.setName(c.getName());
		this.setNumber(c.getNumber());
		this.setDateExpiration(c.getDateExpiration());
		this.setTypeCard(c.getTypeCard());
	}

	@Override
	public String toString() {
		return "Cartao [name=" + name + ", numero=" + number + ", dataValidade=" + dateExpiration + "]";
	}
}