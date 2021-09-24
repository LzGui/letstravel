package com.letstravel.pagamento.entity;

import com.letstravel.pagamento.api.ClientDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
	private String idClient;
	private String clientName;
	private String cnpj;
	
	public Client(ClientDto cl) {
		this.setIdClient(cl.getIdClient());
		this.setClientName(cl.getClientName());
		this.setCnpj(cl.getCnpj());	
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idClient + ", razaoSocial=" + clientName + ", CNPJ=" + cnpj + "]";
	}

}