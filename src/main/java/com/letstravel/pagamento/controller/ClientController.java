package com.letstravel.pagamento.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.letstravel.pagamento.api.ClientDto;
import com.letstravel.pagamento.entity.Client;
import com.letstravel.pagamento.service.ClientService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
public class ClientController {
	private final ClientService clientService;

	@GetMapping("/clients/{id}")
	public ClientDto getById(@PathVariable String id) {
		var client = clientService.get(id);

		return new ClientDto(client);
	}

	@GetMapping("/clients")
	public List<ClientDto> getAll() {
		var clients = clientService.getAll();

		var clientDtos = new ArrayList<ClientDto>();

		for (var client : clients) {
			clientDtos.add(new ClientDto(client));
		}

		return clientDtos;
	}

	@PostMapping("/clients")
	public ClientDto create(@RequestBody ClientDto clientDto) {
		var client = new Client(clientDto);

		client= clientService.create(client);

		return new ClientDto(client);
	}

	@PutMapping("/clients/{id}")
	public ClientDto create(@PathVariable String id, @RequestBody ClientDto clientDto) {
		var client = new Client(clientDto);

		client = clientService.update(id, client);
		return new ClientDto(client);
	}

	@DeleteMapping("/clients/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		clientService.delete(id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
