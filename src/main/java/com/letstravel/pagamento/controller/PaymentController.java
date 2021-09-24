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

import com.letstravel.pagamento.api.PaymentDto;
import com.letstravel.pagamento.entity.Payment;
import com.letstravel.pagamento.service.PaymentService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
public class PaymentController {
	private final PaymentService paymentService;

	@GetMapping("/payments/{id}")
	public PaymentDto getById(@PathVariable String id) {
		var payment = paymentService.get(id);

		return new PaymentDto(payment);
	}

	@GetMapping("/payments")
	public List<PaymentDto> getAll() {
		var payments = paymentService.getAll();

		var paymentDtos = new ArrayList<PaymentDto>();

		for (var payment : payments) {
			paymentDtos.add(new PaymentDto(payment));
		}

		return paymentDtos;
	}

	@PostMapping("/payments")
	public PaymentDto create(@RequestBody PaymentDto paymentDto) {
		var payment = new Payment(paymentDto);

		payment = paymentService.create(payment);

		return new PaymentDto(payment);
	}

	@PutMapping("/payments/{id}")
	public PaymentDto create(@PathVariable String id, @RequestBody PaymentDto paymentDto) {
		var payment = new Payment(paymentDto);

		payment = paymentService.update(id, payment);
		return new PaymentDto(payment);
	}

	@DeleteMapping("/payments/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		paymentService.delete(id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
