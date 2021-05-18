package com.cg.salon.service;

import com.cg.salon.dto.PaymentDto;
import com.cg.salon.entity.Payment;
import com.cg.salon.exceptions.PaymentNotFoundException;

public interface IPaymentService {

	
	public Long addPayment(PaymentDto dto) throws PaymentNotFoundException;

	public Payment save(Payment payment);

	public Payment viewPaymentByAppointmentId(int aid);
		
	
	

}
