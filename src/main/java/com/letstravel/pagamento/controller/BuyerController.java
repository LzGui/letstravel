package com.letstravel.pagamento.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.letstravel.pagamento.api.BuyerDto;
import com.letstravel.pagamento.entity.Buyer;
import com.letstravel.pagamento.service.BuyerService;

@RestController
public class BuyerController {
	private BuyerService buyerService;
	
	public BuyerController(BuyerService buyerService) {
		this.buyerService = buyerService;
	}
	
	@GetMapping
	public BuyerDto getById(@PathVariable String id) {
		var buyer = buyerService.get(id);
		
		return new BuyerDto(buyer);
	}
	
	@GetMapping("/buyers")
	public List<BuyerDto> getAll(){
		var buyers = buyerService.getAll();
		
		var buyerDtos = new ArrayList<BuyerDto>();
		
		for (var buyer : buyers) {
			buyerDtos.add(new BuyerDto(buyer));
		}
		
		return buyerDtos;
	}
	
	@PutMapping("/buyers/{id}")
	public BuyerDto update(@PathVariable String id, @RequestBody BuyerDto bu) {
		var buyer = new Buyer(bu);
		
		buyer = buyerService.update(id, buyer);
		
		return new BuyerDto(buyer);
	}
	
	@DeleteMapping("buyers/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		buyerService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
