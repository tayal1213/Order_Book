package com.bos.code.challenge.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Order {
	private String orderId;
	private String instrumentId;
	private BigDecimal quantity;
	private ZonedDateTime entryTime;
	private OrderType orderType;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public ZonedDateTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(ZonedDateTime entryTime) {
		this.entryTime = entryTime;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderId='" + orderId + '\'' +
				", instrumentId='" + instrumentId + '\'' +
				", quantity=" + quantity +
				", entryTime=" + entryTime +
				", orderType=" + orderType +
				'}';
	}
}
