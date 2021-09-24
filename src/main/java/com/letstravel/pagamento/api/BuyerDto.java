package com.letstravel.pagamento.api;

import java.time.LocalDateTime;

import com.letstravel.pagamento.entity.Buyer;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BuyerDto {
	private String idBuyer;
	@NotEmpty
	private String name;
	@Email
	private String email;
	@CPF
	private String cpf;
	private LocalDateTime createdAt; 
	private LocalDateTime ModifiedAt;
	
	public BuyerDto(Buyer b) {
		this.setIdBuyer(b.getIdBuyer());
		this.setName(b.getName());
		this.setEmail(b.getEmail());
		this.setCpf(b.getCpf());
		this.setCreatedAt(b.getCreatedAt());
		this.setModifiedAt(b.getModifiedAt());
	}
}
