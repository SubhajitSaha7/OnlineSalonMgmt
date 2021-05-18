package com.cg.salon.service;

import java.util.List;

import com.cg.salon.dto.PaymentDto;
import com.cg.salon.entity.Payment;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.PaymentNotFoundException;




public interface IPaymentService {

	
	public Long addPayment(PaymentDto dto) throws PaymentNotFoundException;

	public List<Payment> viewPaymentByAppointmentId(int aid) throws AppointmentNotFoundException,PaymentNotFoundException;
	
	public Payment viewPaymentByPaymentId(long pid) throws PaymentNotFoundException;
	
	public List<Payment> viewAllPayment() throws PaymentNotFoundException;
		

}
