package com.cg.salon.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.salon.dto.BankAccountDto;
import com.cg.salon.dto.BankAccountSuccessMessage;
import com.cg.salon.dto.PaymentDto;
import com.cg.salon.dto.PaymentSuccessMessage;
import com.cg.salon.entity.BankAccount;
import com.cg.salon.entity.Payment;
import com.cg.salon.exceptions.BankAccountNotFoundException;
import com.cg.salon.exceptions.PaymentNotFoundException;
import com.cg.salon.exceptions.ValidateBankAccountException;
import com.cg.salon.exceptions.ValidatePaymentException;
import com.cg.salon.service.IBankAccountService;
import com.cg.salon.service.IPaymentService;

@RestController
public class PaymentRestController {
	
	@Autowired
	private IPaymentService service;
	
	@PostMapping("addpaymentservice")
	public PaymentSuccessMessage addPayment(@Valid @RequestBody PaymentDto paymentdto, BindingResult br) throws ValidatePaymentException, PaymentNotFoundException
	{
	
		if (br.hasErrors())
			throw new ValidatePaymentException(br.getFieldErrors());
		Long bid= service.addPayment(paymentdto);
		
		return new PaymentSuccessMessage("Payment Successfully");
		
	}
	@GetMapping("viewbyPaymentid/{Paymentid}")
	public Payment viewPaymentByPaymentId(@PathVariable("pid") int PaymentId) throws PaymentNotFoundException
	{
		return service.viewPaymentByPaymentId(PaymentId);
	}

}
