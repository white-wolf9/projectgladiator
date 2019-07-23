package com.lti.paysmart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.paysmart.dto.AddProductDTO;
import com.lti.paysmart.dto.ViewProductDTO;
import com.lti.paysmart.dto.ViewProductDetailedDTO;
import com.lti.paysmart.interfaces.AdminService;
import com.lti.paysmart.interfaces.UserService;

@RestController
public class ProductController {
	
	@Autowired
	UserService userServ;

	@Autowired
	AdminService admServ;
	
	@RequestMapping(value = "/view.all.product.index", method = RequestMethod.POST)
	public List<ViewProductDTO> showAllProduct() {
		return userServ.fetchAllProduct();
		
	}
	
	@RequestMapping(value = "/view.specific.product", method = RequestMethod.GET)
	public ViewProductDetailedDTO showClickedProduct(@RequestParam("product_id") long product_id) {
		return userServ.fetchSingleProduct(product_id);
	}

	@RequestMapping(value = "/add.product", method = RequestMethod.POST)
	public String addProduct(AddProductDTO addProductDTO) {
		return admServ.addProduct(addProductDTO);
	}
}
