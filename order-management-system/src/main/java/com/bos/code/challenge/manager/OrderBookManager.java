package com.bos.code.challenge.manager;

import com.bos.code.challenge.controller.OrderBookController;
import com.bos.code.challenge.model.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Atul on 6/7/19.
 */
public class OrderBookManager {

    private Map<String, OrderBook> INSTRUMENT_ID_ORDER_BOOK_MAP = new HashMap<String, OrderBook>();
    
    private static final Logger log = LogManager.getLogger(OrderBookManager.class.getName());

    public ResponseCodes addOrder(final Order order) {
        final OrderBook orderBook = getOrderBook(order.getInstrumentId(), false);
        final ResponseCodes responseCodes;
        if (orderBook.getOrderBookStatus().equals(OrderBookStatus.OPEN)) {
            orderBook.getOrders().add(order);
            responseCodes = ResponseCodes.ORDER_ADDED;
            updateOrderBookStatus(orderBook);
        } else {
        	log.info("Order book is closed for  :" +order.getInstrumentId());
            responseCodes = ResponseCodes.ORDER_BOOK_CLOSED;
        }

        return responseCodes;
    }

    public ResponseCodes addExecution(final String instrumentId, final BigDecimal executionQuantity, final BigDecimal price) {
        final OrderBook orderBook = getOrderBook(instrumentId, true);
        final ResponseCodes responseCodes;
        if(orderBook !=null && orderBook.getOrderBookStatus().equals(OrderBookStatus.CLOSE) && orderBook.getOrders().stream().filter(order -> !order.getOrderStatus().equals(OrderStatus.ORDER_FILLED)).collect(Collectors.toList()).size() > 0) {
        	BigDecimal residualQuantity = executionQuantity;
            if(executionQuantity.compareTo(BigDecimal.ZERO) > 0){
                residualQuantity = executeMarketOrders(price, orderBook, residualQuantity);
            }
            if(residualQuantity.compareTo(BigDecimal.ZERO) >  0){
                executeLimitOrders(price, orderBook, residualQuantity);
            }
            responseCodes = ResponseCodes.EXECUTION_SUCCESSFULL;
        }else {
        	log.info("All Order have filled");
        	responseCodes = ResponseCodes.EXECUTION_UNSUCCESSFULL;
        }
        return responseCodes;
    }

    private OrderBook getOrderBook(final String instrumentId, final boolean isExecution) {
        OrderBook orderBook = INSTRUMENT_ID_ORDER_BOOK_MAP.get(instrumentId);
        if(orderBook == null && !isExecution) {
        	orderBook = new OrderBook();
        	orderBook.setOrderBookStatus(OrderBookStatus.OPEN);
        	INSTRUMENT_ID_ORDER_BOOK_MAP.put(instrumentId, orderBook);
        }
        return orderBook;
    }

    private void updateOrderBookStatus(final OrderBook orderBook) {
        if (orderBook.getOrders().size() >= 2) {
            orderBook.setOrderBookStatus(OrderBookStatus.CLOSE);
        }
    }



    private void executeLimitOrders(BigDecimal price, OrderBook orderBook, BigDecimal residualQuantity) {
        final List<Order> limitOrders = orderBook.getOrders().stream().filter(order -> order.getOrderType().equals(OrderType.LIMIT_ORDER)).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(limitOrders)){
            for (final Order limitOrder : limitOrders) {
                final BigDecimal limitPrice = limitOrder.getLimitPrice();
                final BigDecimal limitOrderQuantity = limitOrder.getQuantity();
                final BigDecimal execQuantity;

                if (residualQuantity.compareTo(BigDecimal.ZERO) > 0 && limitPrice.compareTo(price) >= 0 && !limitOrder.getOrderStatus().equals(OrderStatus.ORDER_FILLED)) {
                    if (limitOrderQuantity.compareTo(residualQuantity) <= 0) {
                        limitOrder.setOrderStatus(OrderStatus.ORDER_FILLED);
                        residualQuantity = residualQuantity.subtract(limitOrderQuantity);
                        execQuantity = limitOrderQuantity;
                    } else {
                        limitOrder.setOrderStatus(OrderStatus.ORDER_PARTIALLY_FILLED);
                        execQuantity = residualQuantity;
                        residualQuantity = BigDecimal.ZERO;
                    }

                    final Execution execution = new Execution();
                    execution.setOrderId(limitOrder.getOrderId());
                    execution.setExecutionPrice(price);
                    execution.setExecutionQuantity(execQuantity);
                    orderBook.getExecutions().add(execution);
                }
            }
        }
    }

    private BigDecimal executeMarketOrders(BigDecimal price, OrderBook orderBook, BigDecimal residualQuantity) {
        final List<Order> marketOrders = orderBook.getOrders().stream().filter(order -> order.getOrderType().equals(OrderType.MARKET_ORDER)).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(marketOrders)){
            for (final Order marketOrder : marketOrders) {
                if (residualQuantity.compareTo(BigDecimal.ZERO) > 0 && !marketOrder.getOrderStatus().equals(OrderStatus.ORDER_FILLED)) {

                    final BigDecimal marketOrderQuantity = marketOrder.getQuantity();
                    final BigDecimal execQuantity;

                    if (marketOrderQuantity.compareTo(residualQuantity) <= 0) {
                        marketOrder.setOrderStatus(OrderStatus.ORDER_FILLED);
                        residualQuantity = residualQuantity.subtract(marketOrderQuantity);
                        execQuantity = marketOrderQuantity;
                    } else {
                        marketOrder.setOrderStatus(OrderStatus.ORDER_PARTIALLY_FILLED);
                        execQuantity = residualQuantity;
                        residualQuantity = BigDecimal.ZERO;
                    }

                    final Execution execution = new Execution();
                    execution.setOrderId(marketOrder.getOrderId());
                    execution.setExecutionPrice(price);
                    execution.setExecutionQuantity(execQuantity);
                    orderBook.getExecutions().add(execution);
                }
            }
        }
        return residualQuantity;
    }

}


