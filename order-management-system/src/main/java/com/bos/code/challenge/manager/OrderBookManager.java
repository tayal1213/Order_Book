package com.bos.code.challenge.manager;

import com.bos.code.challenge.model.*;
import com.google.common.collect.ImmutableMap;

/**
 * Created by Atul on 6/7/19.
 */
public class OrderBookManager {


    private ImmutableMap<OrderBookType, OrderBook> ORDER_BOOK_MAP = ImmutableMap
            .of(OrderBookType.MARKET_ORDER_BOOK, new OrderBook(), OrderBookType.LIMIT_ORDER_BOOK, new OrderBook());

    private ImmutableMap<OrderType, OrderBookType> ORDER_TYPE_TO_BOOK_MAP = ImmutableMap
            .of(OrderType.MARKET_ORDER, OrderBookType.MARKET_ORDER_BOOK, OrderType.LIMIT_ORDER, OrderBookType.LIMIT_ORDER_BOOK);


    public ResponseCodes addMarketOrder(final Order order){
        final OrderBook marketOrderBook = getMarketOrderBook();
        final ResponseCodes responseCodes;
        if(marketOrderBook.getOrderBookStatus().equals(OrderBookStatus.OPEN)){
            marketOrderBook.getOrders().add(order);
            responseCodes = ResponseCodes.ORDER_ADDED;
        }else {
            responseCodes = ResponseCodes.ORDER_BOOK_CLOSED;
        }

        return responseCodes;
    }

    public ResponseCodes addLimitOrder(final Order order){
        final OrderBook limitOrderBook = getLimOrderBook();
        final ResponseCodes responseCodes;
        if(limitOrderBook.getOrderBookStatus().equals(OrderBookStatus.OPEN)){
            limitOrderBook.getOrders().add(order);
            responseCodes = ResponseCodes.ORDER_ADDED;
        }else {
            responseCodes = ResponseCodes.ORDER_BOOK_CLOSED;
        }
        return responseCodes;
    }

    private OrderBook getMarketOrderBook(){
        final OrderBook marketOrderBook = ORDER_BOOK_MAP.get(OrderBookType.MARKET_ORDER_BOOK);
        if(marketOrderBook.getOrderBookStatus() == null){
            marketOrderBook.setOrderBookStatus(OrderBookStatus.OPEN);
        }
        return marketOrderBook;
    }

    private OrderBook getLimOrderBook(){
        final OrderBook limitOrderBook = ORDER_BOOK_MAP.get(OrderBookType.LIMIT_ORDER_BOOK);
        if(limitOrderBook.getOrderBookStatus() == null){
            limitOrderBook.setOrderBookStatus(OrderBookStatus.OPEN);
        }
        return limitOrderBook;
    }

}
