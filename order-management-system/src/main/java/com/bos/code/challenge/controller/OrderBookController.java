package com.bos.code.challenge.controller;


import com.bos.code.challenge.manager.OrderBookManager;
import com.bos.code.challenge.model.Order;
import com.bos.code.challenge.model.OrderType;
import com.bos.code.challenge.model.ResponseCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Created by Atul on 6/7/19.
 */
@RestController
public class OrderBookController {

    @Autowired
    private OrderBookManager orderBookManager;

    @RequestMapping("/addMarketOrder")
    public ResponseCodes addMarketOrder(final @RequestParam(value = "instrumentId") String instrumentId, final @RequestParam("quantity") BigDecimal quantity, final @RequestParam("price") BigDecimal price) {
        final Order order = new Order();
        order.setEntryTime(ZonedDateTime.now(ZoneId.of("UTC")));
        order.setOrderId(UUID.randomUUID().toString());
        order.setQuantity(quantity);
        order.setInstrumentId(instrumentId);
        order.setOrderType(OrderType.MARKET_ORDER);
        return orderBookManager.addMarketOrder(order);

    }


    @RequestMapping("/addLimitOrder")
    @ResponseBody
    public ResponseCodes addLimitOrder(final @RequestParam(value = "instrumentId") String instrumentId, final @RequestParam("quantity") BigDecimal quantity, final @RequestParam("price") BigDecimal price) {
        final Order order = new Order();
        order.setEntryTime(ZonedDateTime.now(ZoneId.of("UTC")));
        order.setOrderId(UUID.randomUUID().toString());
        order.setQuantity(quantity);
        order.setInstrumentId(instrumentId);
        order.setOrderType(OrderType.LIMIT_ORDER);
        return orderBookManager.addLimitOrder(order);
    }
}
