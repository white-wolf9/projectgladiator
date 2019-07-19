package com.lti.paysmart.dto;

import com.lti.paysmart.enums.CardStatus;
import com.lti.paysmart.enums.CardTypes;

public class CardDetailsResponseDTO {
	
	public String name;
	public String type;
	public double cardbalance;
	public String cardstatus;
	public long cardno;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getCardbalance() {
		return cardbalance;
	}
	public void setCardbalance(double cardbalance) {
		this.cardbalance = cardbalance;
	}
	public String getCardstatus() {
		return cardstatus;
	}
	public void setCardstatus(String cardstatus) {
		this.cardstatus = cardstatus;
	}
	public long getCardno() {
		return cardno;
	}
	public void setCardno(long cardno) {
		this.cardno = cardno;
	}

	
}
