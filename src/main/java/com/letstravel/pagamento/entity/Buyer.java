package com.letstravel.pagamento.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;

import com.letstravel.pagamento.api.BuyerDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Buyer {
	
	@Id
	private String idBuyer;
	@NotEmpty
	private String name;
	@Email
	private String email;
	@CPF
	private String cpf;
	private LocalDateTime createdAt; 
	private LocalDateTime ModifiedAt;
	
	public Buyer(BuyerDto b) {
		this.setIdBuyer(b.getIdBuyer());
		this.setName(b.getName());
		this.setEmail(b.getEmail());
		this.setCpf(b.getCpf());
		this.setCreatedAt(b.getCreatedAt());
		this.setModifiedAt(b.getModifiedAt());
	}

	@Override
	public String toString() {
		return "Comprador [idComprador=" + idBuyer + ", nome=" + name + ", email=" + email + ", CPF=" + cpf + "]";
	}
}