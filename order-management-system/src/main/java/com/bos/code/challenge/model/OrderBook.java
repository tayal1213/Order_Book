package com.bos.code.challenge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anupam on 6/7/19.
 */
public class OrderBook {

    private String name;
    private OrderBookType orderBookType;
    private OrderBookStatus orderBookStatus;
    private List<Order> orders = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderBookType getOrderBookType() {
        return orderBookType;
    }

    public void setOrderBookType(OrderBookType orderBookType) {
        this.orderBookType = orderBookType;
    }

    public OrderBookStatus getOrderBookStatus() {
        return orderBookStatus;
    }

    public void setOrderBookStatus(OrderBookStatus orderBookStatus) {
        this.orderBookStatus = orderBookStatus;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "name='" + name + '\'' +
                ", orderBookType=" + orderBookType +
                ", orderBookStatus=" + orderBookStatus +
                ", orders=" + orders +
                '}';
    }
}
