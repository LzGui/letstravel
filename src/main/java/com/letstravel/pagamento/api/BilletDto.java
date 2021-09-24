package com.letstravel.pagamento.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.letstravel.pagamento.entity.Billet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BilletDto {
	private String idBillet;
	private Long numberBillet;
	private LocalDate dateExpiration;
	private LocalDateTime createdAt; 
	private LocalDateTime ModifiedAt;
	
	public BilletDto(Billet b) {
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
