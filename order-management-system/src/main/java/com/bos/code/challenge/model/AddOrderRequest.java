package com.bos.code.challenge.model;

import java.math.BigDecimal;

public class AddOrderRequest {

	private String instrumentId;
	private BigDecimal quantity;
	private BigDecimal price;
	private String orderType;

	
	



	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "AddOrderRequest [instrumentId=" + instrumentId + ", quantity=" + quantity + ", price=" + price
				+ ", orderType=" + orderType + "]";
	}



}
