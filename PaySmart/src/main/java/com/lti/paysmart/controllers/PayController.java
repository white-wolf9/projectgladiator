package com.lti.paysmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.paysmart.dto.InstallmentPaymentRequestDTO;
import com.lti.paysmart.interfaces.AdminService;
import com.lti.paysmart.interfaces.UserService;

@RestController
public class PayController {

	@Autowired
	UserService userServ;

	@Autowired
	AdminService admServ;
	
	@RequestMapping(value = "/pay.order.installment", method = RequestMethod.POST)
	public String payInstallment(@RequestBody InstallmentPaymentRequestDTO installmentPaymentRequestDTO) {
		return userServ.payInstallment(installmentPaymentRequestDTO);
	}
}
