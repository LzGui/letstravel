package com.letstravel.pagamento.service;

import org.springframework.stereotype.Service;

import com.letstravel.pagamento.api.ClientDto;
import com.letstravel.pagamento.entity.Client;
import com.letstravel.pagamento.repository.ClientRepository;

@Service
public class ClientService {
	private ClientRepository clientRepository;
	
	public Client searchClient(ClientDto clientDto) {
		return clientRepository.findById(clientDto.getIdClient()).orElse(null);
	}
}