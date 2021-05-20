package com.cg.salon.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.salon.dao.IAppointmentDao;
import com.cg.salon.dao.IBankAccountDao;
import com.cg.salon.dao.IPaymentDao;
import com.cg.salon.dto.PaymentDto;
import com.cg.salon.entity.Appointment;
import com.cg.salon.entity.BankAccount;
import com.cg.salon.entity.Customer;
import com.cg.salon.entity.Payment;
import com.cg.salon.entity.SalonService;
import com.cg.salon.entity.SalonServiceSchedule;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.BankAccountNotFoundException;
import com.cg.salon.exceptions.CustomerNotFoundException;
import com.cg.salon.exceptions.PaymentNotFoundException;
import com.cg.salon.exceptions.SalonServiceNotFoundException;
import com.cg.salon.exceptions.SalonServiceScheduleNotFoundException;
import com.cg.util.SalonConstraints;

@Service("paymentservice")
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentDao paymentdao;
	@Autowired
	private IAppointmentDao appdao;
	@Autowired
	private IBankAccountDao bankaccdao;

	@Override
	@Transactional

	public Long addPayment(PaymentDto dto)
			throws PaymentNotFoundException, AppointmentNotFoundException, BankAccountNotFoundException {

		Optional<Appointment> optsalon = appdao.findById(dto.getAppointmentId());
		if (!optsalon.isPresent())
			throw new AppointmentNotFoundException(SalonConstraints.APPOINTMENT_NOT_FOUND);

		Optional<BankAccount> optbank = bankaccdao.findById(dto.getCvvNo());
		if (!optbank.isPresent())
			throw new BankAccountNotFoundException(SalonConstraints.BANK_ACCOUNT_NOT_FOUND);

		Payment payment = new Payment();

		payment.setPaymentId(dto.getPaymentId());
		payment.setType(dto.getType());
		payment.setStatus(SalonConstraints.PAYMENT_ADDED);
		payment.setAppointment(optsalon.get());
		payment.setBankAccount(optbank.get());
		Payment savedpayment = paymentdao.save(payment);
		return savedpayment.getPaymentId();
	}

	@Override
	public Payment viewPaymentByPaymentId(Integer pid) throws PaymentNotFoundException {
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

}