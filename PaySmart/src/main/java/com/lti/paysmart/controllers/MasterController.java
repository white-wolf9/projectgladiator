package com.lti.paysmart.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.paysmart.dto.AddProductDTO;
import com.lti.paysmart.dto.AdminLoginDTO;
import com.lti.paysmart.dto.CardDetailsRequestDTO;
import com.lti.paysmart.dto.CardDetailsResponseDTO;
import com.lti.paysmart.dto.InstallmentPaymentRequestDTO;
import com.lti.paysmart.dto.LoginResponseDTO;
import com.lti.paysmart.dto.ProductOrderRequestDTO;
import com.lti.paysmart.dto.ProductOrderResponseDTO;
import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.dto.UserRegisterDTO;
import com.lti.paysmart.dto.ViewAllOrderResopnseDTO;
import com.lti.paysmart.dto.ViewProductDTO;
import com.lti.paysmart.dto.ViewProductDetailedDTO;
import com.lti.paysmart.dto.ViewUsersAdminDTO;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.entities.User;
import com.lti.paysmart.interfaces.AdminService;
import com.lti.paysmart.interfaces.UserService;

@RestController
public class MasterController {
	
	@Autowired
	UserService userServ;

	@Autowired
	AdminService admServ;
	
	
	
	@RequestMapping(value = "/register.user", method = RequestMethod.POST)
	public String register(UserRegisterDTO userRegisterDTO) {
		return userServ.performRegister(userRegisterDTO);
	}
	
	@RequestMapping(value = "/add.product", method = RequestMethod.POST)
	public String addProduct(AddProductDTO addProductDTO) {
		return admServ.addProduct(addProductDTO);
	}
	
	@RequestMapping(value = "/view.all.users", method = RequestMethod.POST)
	public List<ViewUsersAdminDTO> viewUserDetails() {

		List<User> list = admServ.viewAllUser();
		List<ViewUsersAdminDTO> responseList = new ArrayList<ViewUsersAdminDTO>();
		
		for(User user_iterator:list) {
			ViewUsersAdminDTO object = new ViewUsersAdminDTO();
			object.setFname(user_iterator.getFname());
			object.setLname(user_iterator.getLname());
			object.setEmail(user_iterator.getEmail());
			object.setPhone_no(user_iterator.getPhone_no());
			object.setAddress(user_iterator.getAddress().getDoorNo()+", "+user_iterator.getAddress().getStreet()+", "+user_iterator.getAddress().getCity());
			object.setUserid(user_iterator.getUser_id());
			
			Path sourceAadharFile = Paths.get("D:/uploads/"+user_iterator.getDocument().getAadharcardfilename());
			Path destAadharFile = Paths.get("src/main/resources/static/uploads/"+user_iterator.getDocument().getAadharcardfilename());
			try {
				Files.copy(sourceAadharFile, destAadharFile, StandardCopyOption.REPLACE_EXISTING);
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			Path sourcePanFile = Paths.get("D:/uploads/"+user_iterator.getDocument().getPancardfilename());
			Path destPanFile = Paths.get("src/main/resources/static/uploads/"+user_iterator.getDocument().getPancardfilename());
			try {
				Files.copy(sourcePanFile, destPanFile, StandardCopyOption.REPLACE_EXISTING);
			}catch (Exception e) {
				// TODO: handle exception
			}
			object.setAadharfile(user_iterator.getDocument().getAadharcardfilename());
			object.setPanfile(user_iterator.getDocument().getPancardfilename());
			responseList.add(object);
		}
		return responseList;
	}

	@RequestMapping(value = "/get.card.details", method = RequestMethod.POST)
	public CardDetailsResponseDTO showCardDetails(@RequestBody CardDetailsRequestDTO cardDetailsRequestDTO) {
		return userServ.fetchCardUser(cardDetailsRequestDTO);
	}
	
	@RequestMapping(value = "/activate.user.card", method = RequestMethod.GET)
	public String showDetails(@RequestParam("user_id") long user_id) {
		return admServ.toggleCard(user_id);
	}
	
	@RequestMapping(value = "/view.all.product.index", method = RequestMethod.POST)
	public List<ViewProductDTO> showAllProduct() {
		return userServ.fetchAllProduct();
		
	}
	
	@RequestMapping(value = "/view.specific.product", method = RequestMethod.GET)
	public ViewProductDetailedDTO showClickedProduct(@RequestParam("product_id") long product_id) {
		return userServ.fetchSingleProduct(product_id);
	}

	@RequestMapping(value = "/place.product.order", method = RequestMethod.POST)
	public ProductOrderResponseDTO placeOrder(@RequestBody ProductOrderRequestDTO productOrderRequestDTO) {
		return userServ.placeOrder(productOrderRequestDTO);
	}
	
	@RequestMapping(value = "/fetch.all.orders", method = RequestMethod.GET)
	public  List<ViewAllOrderResopnseDTO> fetchAllOrder(@RequestParam("user_name") String username) {
		return userServ.fetchAllOrders(username);
	}
	
	@RequestMapping(value = "/pay.order.installment", method = RequestMethod.POST)
	public String payInstallment(@RequestBody InstallmentPaymentRequestDTO installmentPaymentRequestDTO) {
		return userServ.payInstallment(installmentPaymentRequestDTO);
	}

}
