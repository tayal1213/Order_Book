package com.bos.code.challenge.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bos.code.challenge.manager.OrderBookManager;
import com.bos.code.challenge.model.AddOrderRequest;
import com.bos.code.challenge.model.AddOrderResponse;
import com.bos.code.challenge.model.Order;
import com.bos.code.challenge.model.OrderType;
import com.bos.code.challenge.model.ResponseCodes;
import com.bos.code.challenge.util.CommonConstants;

/**
 * Created by Atul on 6/7/19.
 */
@RestController
public class OrderBookController {

	@Autowired
	private OrderBookManager orderBookManager;

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public ResponseEntity<AddOrderResponse> addMarketOrder(final @RequestBody AddOrderRequest request) {
		final Order order = new Order();
		final AddOrderResponse response = new AddOrderResponse();
		ResponseCodes responseCode = null;
		HttpStatus status;
		order.setEntryTime(ZonedDateTime.now(ZoneId.of("UTC")));
		order.setOrderId(UUID.randomUUID().toString());
		order.setQuantity(request.getQuantity());
		order.setInstrumentId(request.getInstrumentId());
		if (request.getOrderType().equals(OrderType.MARKET_ORDER.name()))
			responseCode = orderBookManager.addMarketOrder(order);
		else
			responseCode = orderBookManager.addLimitOrder(order);
		if (responseCode != null) {
			response.setDescription(responseCode.getDescription());
			response.setCode(responseCode.getCode());
			status = HttpStatus.OK;
			return new ResponseEntity<AddOrderResponse>(response, status);
		} else {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setCode(CommonConstants.CODE);
			response.setDescription(CommonConstants.DESCRIPTION);
			return new ResponseEntity<AddOrderResponse>(response, status);
		}

	}


}
