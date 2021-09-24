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

import com.letstravel.pagamento.api.CardDto;
import com.letstravel.pagamento.entity.Card;
import com.letstravel.pagamento.service.CardService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CardController {
	private final CardService cardService;

	@GetMapping("/cards/{id}")
	public CardDto getById(@PathVariable String id) {
		var card = cardService.get(id);

		return new CardDto(card);
	}

	@GetMapping("/cards")
	public List<CardDto> getAll() {
		var cards = cardService.getAll();

		var cardDtos = new ArrayList<CardDto>();

		for (var card : cards) {
			cardDtos.add(new CardDto(card));
		}

		return cardDtos;
	}

	@PostMapping("/cards")
	public CardDto create(@RequestBody CardDto cardDto) {
		var card = new Card(cardDto);

		card = cardService.create(card);

		return new CardDto(card);
	}

	@PutMapping("/cards/{id}")
	public CardDto create(@PathVariable String id, @RequestBody CardDto cardDto) {
		var card = new Card(cardDto);

		card = cardService.update(id, card);
		return new CardDto(card);
	}

	@DeleteMapping("/cards/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		cardService.delete(id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
