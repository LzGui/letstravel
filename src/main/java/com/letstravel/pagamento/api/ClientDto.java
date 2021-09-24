package com.letstravel.pagamento.api;

import com.letstravel.pagamento.entity.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
	private String idClient;
	private String clientName;
	private String cnpj;
	
	public ClientDto(Client cl) {
		this.setIdClient(cl.getIdClient());
		this.setClientName(cl.getClientName());
		this.setCnpj(cl.getCnpj());	
	}

	@Override
	public String toString() {
		return "ClientDTO [idClient=" + idClient + "]";
	}
}
