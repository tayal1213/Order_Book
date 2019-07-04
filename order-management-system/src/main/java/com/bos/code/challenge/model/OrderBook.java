package com.bos.code.challenge.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderBook {
	
	private int orderId;
	private String entityName;
	private int entityId;
	private int quantity;
	private Date entryDate;
	private boolean isMarketOrder;
	private boolean isLimitOrder;
	private double limitPrice;
	

}
