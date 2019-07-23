package com.lti.paysmart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.paysmart.dto.ProductOrderRequestDTO;
import com.lti.paysmart.dto.ProductOrderResponseDTO;
import com.lti.paysmart.dto.ViewAllOrderResopnseDTO;
import com.lti.paysmart.interfaces.AdminService;
import com.lti.paysmart.interfaces.UserService;

@RestController
public class OrderController {
	
	@Autowired
	UserService userServ;

	@Autowired
	AdminService admServ;

	@RequestMapping(value = "/place.product.order", method = RequestMethod.POST)
	public ProductOrderResponseDTO placeOrder(@RequestBody ProductOrderRequestDTO productOrderRequestDTO) {
		return userServ.placeOrder(productOrderRequestDTO);
	}
	
	@RequestMapping(value = "/fetch.all.orders", method = RequestMethod.GET)
	public  List<ViewAllOrderResopnseDTO> fetchAllOrder(@RequestParam("user_name") String username) {
		return userServ.fetchAllOrders(username);
	}
	

}
