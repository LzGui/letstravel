package com.letstravel.pagamento.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.letstravel.pagamento.api.BilletDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Billet {
	
	@Id
	private String idBillet;
	private Long numberBillet;
	private LocalDate dateExpiration;
	private LocalDateTime createdAt; 
	private LocalDateTime ModifiedAt;
	
	public Billet(BilletDto b) {
		this.setIdBillet(b.getIdBillet());
		this.setNumberBillet(b.getNumberBillet());
		this.setDateExpiration(b.getDateExpiration());
		this.setCreatedAt(b.getCreatedAt());
		this.setModifiedAt(b.getModifiedAt());
	}

	@Override
	public String toString() {
		return "Billet [id boleto = " + idBillet 
				+ ", numero boleto=" + numberBillet 
				+ ", data de vencimento=" + dateExpiration
				+ "]";
	}

}