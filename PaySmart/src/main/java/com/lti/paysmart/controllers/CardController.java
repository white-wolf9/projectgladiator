package com.lti.paysmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.paysmart.dto.CardDetailsRequestDTO;
import com.lti.paysmart.dto.CardDetailsResponseDTO;
import com.lti.paysmart.interfaces.AdminService;
import com.lti.paysmart.interfaces.UserService;

@RestController
public class CardController {
	
	@Autowired
	UserService userServ;

	@Autowired
	AdminService admServ;
	

	@RequestMapping(value = "/get.card.details", method = RequestMethod.POST)
	public CardDetailsResponseDTO showCardDetails(@RequestBody CardDetailsRequestDTO cardDetailsRequestDTO) {
		return userServ.fetchCardUser(cardDetailsRequestDTO);
	}
	
	@RequestMapping(value = "/activate.user.card", method = RequestMethod.GET)
	public String showDetails(@RequestParam("user_id") long user_id) {
		return admServ.toggleCard(user_id);
	}
	

}
