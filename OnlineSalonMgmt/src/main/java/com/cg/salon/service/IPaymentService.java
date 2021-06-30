package com.cg.salon.service;

import java.util.List;

import com.cg.salon.dto.PaymentDto;
import com.cg.salon.entity.Payment;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.BankAccountNotFoundException;
import com.cg.salon.exceptions.PaymentNotFoundException;

public interface IPaymentService {

	public Integer addPayment(PaymentDto dto)
			throws PaymentNotFoundException, AppointmentNotFoundException, BankAccountNotFoundException;

	public Payment getPaymentByPaymentId(Integer pid) throws PaymentNotFoundException;

	public List<Payment> getAllPayment() throws PaymentNotFoundException;

}
