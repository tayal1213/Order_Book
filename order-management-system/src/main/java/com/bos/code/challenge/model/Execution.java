package com.bos.code.challenge.model;

import java.math.BigDecimal;

/**
 * Created by Anupam on 7/7/19.
 */
public class Execution {

    private String orderId;
    private BigDecimal executionPrice;
    private BigDecimal executionQuantity;
    private String instrumentId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getExecutionPrice() {
        return executionPrice;
    }

    public void setExecutionPrice(BigDecimal executionPrice) {
        this.executionPrice = executionPrice;
    }

    public BigDecimal getExecutionQuantity() {
        return executionQuantity;
    }

    public void setExecutionQuantity(BigDecimal executionQuantity) {
        this.executionQuantity = executionQuantity;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    @Override
    public String toString() {
        return "Execution{" +
                "orderId='" + orderId + '\'' +
                ", executionPrice=" + executionPrice +
                ", executionQuantity=" + executionQuantity +
                ", instrumentId='" + instrumentId + '\'' +
                '}';
    }
}
