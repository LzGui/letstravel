package com.letstravel.pagamento.service;

import com.letstravel.pagamento.entity.Billet;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.letstravel.pagamento.repository.BilletRepository;

@Service
public class BilletService {
	
	private BilletRepository billetRepository;
	
	public Billet saveBillet(Billet billet) {
		return billetRepository.save(billet);
	}
	
	public Billet generateBillet() {
		Billet billet = new Billet();
		Random generator = new Random();
		
		billet.setNumberBillet((long) (generator.nextInt(101) * 100));
		billet.setDateExpiration(LocalDate.now().plusDays(5));
		
		return billet;
	}
}