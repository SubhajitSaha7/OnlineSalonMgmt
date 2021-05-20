package com.cg.salon.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.salon.dao.IPaymentDao;
import com.cg.salon.dto.PaymentDto;
import com.cg.salon.entity.BankAccount;
import com.cg.salon.entity.Customer;
import com.cg.salon.entity.Payment;
import com.cg.salon.entity.SalonServiceSchedule;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.CustomerNotFoundException;
import com.cg.salon.exceptions.PaymentNotFoundException;
import com.cg.salon.exceptions.SalonServiceScheduleNotFoundException;
import com.cg.util.SalonConstraints;

@Service("paymentservice")
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentDao paymentdao;

	@Override
	@Transactional
	public Long addPayment(PaymentDto dto) throws PaymentNotFoundException {

		Payment payment = new Payment();

		payment.setPaymentId(dto.getPaymentId());
		payment.setType(dto.getType());
		payment.setStatus(dto.getStatus());
		Payment savedpayment = paymentdao.save(payment);
		return savedpayment.getPaymentId();
	}

	@Override
	public Payment viewPaymentByPaymentId(long pid) throws PaymentNotFoundException {
		Optional<Payment> optservice = paymentdao.findById(pid);
		if (!optservice.isPresent())
			throw new PaymentNotFoundException(SalonConstraints.PAYMENT_NOT_EXIST + pid);
		return optservice.get();
	}

	@Override
	public List<Payment> viewAllPayment() throws PaymentNotFoundException {
		List<Payment> lst = paymentdao.findAll();
		if (lst.isEmpty())
			throw new PaymentNotFoundException(SalonConstraints.PAYMENT_NOT_FOUND);
		return lst;

	}

	@Override
	public Payment viewPaymentByAppointmentId(int aid) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
