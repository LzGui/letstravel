package com.letstravel.pagamento.api;

import com.letstravel.pagamento.entity.Payment;
import com.letstravel.pagamento.enums.FormPayment;
import com.letstravel.pagamento.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReplyPaymentDto {
	private String idPayment;
	private double valuePayment;
	private FormPayment formPayment;
	private Status status;
	private Long numberBillet;
	
	public ReplyPaymentDto(Payment pay) {
		this.setIdPayment(pay.getIdPayment());
		this.setValuePayment(pay.getValuePayment());
		this.setFormPayment(pay.getFormPayment());
		this.setStatus(pay.getStatus());
		this.setNumberBillet(pay.getNumberBillet());
	}
}
