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

import com.letstravel.pagamento.api.BilletDto;
import com.letstravel.pagamento.api.BuyerDto;
import com.letstravel.pagamento.entity.Billet;
import com.letstravel.pagamento.entity.Buyer;
import com.letstravel.pagamento.service.BilletService;
import com.letstravel.pagamento.service.BuyerService;


@RestController
public class BilletController {
	private BilletService billetService;
		
		public BilletController(BilletService billetService) {
			this.billetService = billetService;
		}
		
		@GetMapping("billets/{id}")
		public BilletDto getById(@PathVariable String id) {
			var billet = billetService.get(id);
			
			return new BilletDto(billet);
		}
		
		@GetMapping("/billets")
		public List<BilletDto> getAll(){
			var billets = billetService.getAll();
			
			var billetDtos = new ArrayList<BilletDto>();
			
			for (var billet : billets) {
				billetDtos.add(new BilletDto(billet));
			}
			
			return billetDtos;
		}
		
		@PutMapping("/billets/{id}")
		public BilletDto update(@PathVariable String id, @RequestBody BilletDto bi) {
			var billet = new Billet(bi);
			
			billet = billetService.update(id, billet);
			
			return new BilletDto(billet);
		}
		
		@DeleteMapping("billets/{id}")
		public ResponseEntity<Void> delete(@PathVariable String id) {
			billetService.delete(id);
			
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
}
