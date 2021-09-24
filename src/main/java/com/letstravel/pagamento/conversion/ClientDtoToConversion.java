package com.letstravel.pagamento.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.letstravel.pagamento.api.ClientDto;
import com.letstravel.pagamento.entity.Client;
import com.letstravel.pagamento.exception.ClientNotFoundException;
import com.letstravel.pagamento.service.ClientService;

@Component
public class ClientDtoToConversion implements Converter<ClientDto, Client> {
	
	@Autowired
	private ClientService clientService;

	@Override
	public Client convert(ClientDto clientDto) {
		Client client = clientService.searchClient(clientDto);
		if (!ObjectUtils.isEmpty(client)) {
			return client;
		} else {
			throw new ClientNotFoundException(clientDto.getIdClient());
		}
	}
}
