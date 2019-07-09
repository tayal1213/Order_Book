package com.bos.code.challenge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Atul on 6/7/19.
 */
public class OrderBook {

    private String instrumentId;
    private String name;
    private OrderBookType orderBookType;
    private OrderBookStatus orderBookStatus;
    private List<Order> orders = new ArrayList<>();
    private List<Execution> executions = new ArrayList<>();


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

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public List<Execution> getExecutions() {
        return executions;
    }

    public void setExecutions(List<Execution> executions) {
        this.executions = executions;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "instrumentId='" + instrumentId + '\'' +
                ", name='" + name + '\'' +
                ", orderBookType=" + orderBookType +
                ", orderBookStatus=" + orderBookStatus +
                ", orders=" + orders +
                ", executions=" + executions +
                '}';
    }
}
