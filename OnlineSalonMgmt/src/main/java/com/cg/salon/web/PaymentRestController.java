package com.cg.salon.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.salon.dto.PaymentDto;
import com.cg.salon.dto.PaymentSuccessMessage;

import com.cg.salon.entity.Payment;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.BankAccountNotFoundException;
import com.cg.salon.exceptions.PaymentNotFoundException;

import com.cg.salon.exceptions.ValidatePaymentException;

import com.cg.salon.service.IPaymentService;
import com.cg.util.SalonConstraints;

@RestController
public class PaymentRestController {

	@Autowired
	private IPaymentService service;

	@PostMapping("addpaymentservice")
	public PaymentSuccessMessage addPayment(@Valid @RequestBody PaymentDto paymentdto, BindingResult br)
			throws ValidatePaymentException, PaymentNotFoundException, AppointmentNotFoundException,
			BankAccountNotFoundException {

		if (br.hasErrors())
			throw new ValidatePaymentException(br.getFieldErrors());
		Long bid = service.addPayment(paymentdto);

		return new PaymentSuccessMessage(SalonConstraints.PAYMENT_ADDED);

	}

	@GetMapping("viewbypaymentid/{pid}")
	public Payment viewPaymentByPaymentId(@PathVariable("pid") Integer paymentId) throws PaymentNotFoundException {
		return service.viewPaymentByPaymentId(paymentId);
	}

	@GetMapping("viewallpayment")
	public List<Payment> viewAllPayment() throws PaymentNotFoundException, AppointmentNotFoundException {
		return service.viewAllPayment();
	}

}
