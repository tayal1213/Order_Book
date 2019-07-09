package com.bos.code.challenge.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bos.code.challenge.manager.OrderBookManager;
import com.bos.code.challenge.model.AddExecutionRequest;
import com.bos.code.challenge.model.AddExecutionResponse;
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
	
	private static final Logger log = LogManager.getLogger(OrderBookController.class.getName());

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public ResponseEntity<AddOrderResponse> addOrder(final @RequestBody AddOrderRequest request) {
		
		log.info("Adding order for :" + request.getInstrumentId());
		final Order order = new Order();
		order.setEntryTime(ZonedDateTime.now(ZoneId.of("UTC")));
		order.setOrderId(request.getOrderType() + "-" + UUID.randomUUID().toString());
		order.setQuantity(request.getQuantity());
		order.setInstrumentId(request.getInstrumentId());
		order.setOrderType(OrderType.valueOf(request.getOrderType()));
		final ResponseCodes responseCode = orderBookManager.addOrder(order);
		final AddOrderResponse addOrderResponse = responseCode != null ? new AddOrderResponse(responseCode.getDescription(), responseCode.getCode())
																	   : new AddOrderResponse(CommonConstants.CODE, CommonConstants.DESCRIPTION);
		final HttpStatus status = responseCode != null ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
		return new ResponseEntity(addOrderResponse, status);

	}


	@RequestMapping(value = "/addExecution", method = RequestMethod.POST)
	public ResponseEntity<AddExecutionResponse> addExecution(final @RequestBody AddExecutionRequest executionRequest) {
		log.info("Executing order for :" + executionRequest.getInstrumentId());
		final ResponseCodes responseCodes = orderBookManager.addExecution(executionRequest.getInstrumentId(),
				executionRequest.getExecutionQuantity(),
				executionRequest.getExecutionPrice());

		final AddOrderResponse addOrderResponse = responseCodes != null ?
				new AddOrderResponse(responseCodes.getDescription(), responseCodes.getCode())
				: new AddOrderResponse(CommonConstants.CODE, CommonConstants.DESCRIPTION);
		final HttpStatus status = responseCodes != null ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
		return new ResponseEntity(addOrderResponse, status);

	}


}
