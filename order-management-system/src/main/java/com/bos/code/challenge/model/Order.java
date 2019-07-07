package com.bos.code.challenge.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Order {
	private String orderId;
	private String instrumentId;
	private BigDecimal quantity;
	private BigDecimal limitPrice;
	private ZonedDateTime entryTime;
	private OrderType orderType;
	private OrderStatus orderStatus = OrderStatus.ORDER_PENDING;
	private Side side = Side.BUY; //default value

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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public BigDecimal getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(BigDecimal limitPrice) {
		this.limitPrice = limitPrice;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderId='" + orderId + '\'' +
				", instrumentId='" + instrumentId + '\'' +
				", quantity=" + quantity +
				", limitPrice=" + limitPrice +
				", entryTime=" + entryTime +
				", orderType=" + orderType +
				", orderStatus=" + orderStatus +
				", side=" + side +
				'}';
	}
}
