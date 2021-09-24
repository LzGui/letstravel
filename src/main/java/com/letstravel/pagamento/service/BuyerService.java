package com.letstravel.pagamento.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.letstravel.pagamento.entity.Buyer;
import com.letstravel.pagamento.exception.NotFoundException;
import com.letstravel.pagamento.repository.BuyerRepository;

@Service
public class BuyerService {
	private BuyerRepository buyerRepository;
	
	public Buyer create(Buyer b) {
		var now = LocalDateTime.now();
		
		b.setCreatedAt(now);
		b.setModifiedAt(now);
		
		buyerRepository.save(b);
		
		return b;

	}
	
	public Buyer update(String id, Buyer bu) {
		var existing = get(id);
		
		existing.setName(bu.getName());
		
		existing.setModifiedAt(LocalDateTime.now());
		
		buyerRepository.save(existing);
		
		return existing;
	}
	
	public Buyer get(String id) {
		var buyer = buyerRepository.findById(id);
		
		if (buyer.isEmpty()) {
			throw new NotFoundException("Buyer with ID " 
					+ id + " not found");
		}
		
		return buyer.get();
	}
	
	public List<Buyer> getAll(){
		return buyerRepository.findAll();
	}
	
	public void delete(String id) {
		get(id);
		
		buyerRepository.deleteById(id);
	}
}
