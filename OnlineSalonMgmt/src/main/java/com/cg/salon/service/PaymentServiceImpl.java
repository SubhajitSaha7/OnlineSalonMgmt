package com.cg.salon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.salon.dto.PaymentDto;
import com.cg.salon.entity.BankAccount;
import com.cg.salon.entity.Customer;
import com.cg.salon.entity.Payment;
import com.cg.salon.entity.SalonServiceSchedule;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.CustomerNotFoundException;
import com.cg.salon.exceptions.PaymentNotFoundException;
import com.cg.salon.exceptions.SalonServiceScheduleNotFoundException;

@Service("paymentservice")
public class PaymentServiceImpl implements IPaymentService{
	
	@Autowired
	private IPaymentService paymentdao;
	
	//byaid
	
	@Override
	public Long addPayment(PaymentDto dto) throws PaymentNotFoundException{
		
		Payment payment = new Payment();
		
		payment.setPaymentId(dto.getPaymentId());
		payment.setType(dto.getType());
		payment.setStatus(dto.getStatus());
		payment.setBankAccount(dto.getBankAccount());
		
		Payment savedpayment = paymentdao.save(payment);
		return savedpayment.getPaymentId();
		
		}
	
	
	public Payment viewPaymentById(int pid) throws PaymentNotFoundException {
		Optional<Payment> optservice = paymentdao.findById(pid);
		if (!optservice.isPresent())
			throw new PaymentNotFoundException("Payment does not exists for "+pid);
		return optservice.get();
	}
	
	public Payment viewPaymentByAppointmentId(int aid) throws AppointmentNotFoundException {
		
		Payment pid= paymentdao.viewPaymentByAppointmentId(aid);
		if (pid.isEmpty())
			throw new SalonServiceScheduleNotFoundException("No salon service found");
		return pid;
	}
	

	@Override
	public Payment save(Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
