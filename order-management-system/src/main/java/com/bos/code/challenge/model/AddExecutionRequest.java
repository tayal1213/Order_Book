package com.bos.code.challenge.model;

import java.math.BigDecimal;

/**
 * Created by Atul on 7/7/19.
 */
public class AddExecutionRequest {

    private String instrumentId;
    private BigDecimal executionQuantity;
    private BigDecimal executionPrice;

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public BigDecimal getExecutionQuantity() {
        return executionQuantity;
    }

    public void setExecutionQuantity(BigDecimal executionQuantity) {
        this.executionQuantity = executionQuantity;
    }

    public BigDecimal getExecutionPrice() {
        return executionPrice;
    }

    public void setExecutionPrice(BigDecimal executionPrice) {
        this.executionPrice = executionPrice;
    }

    @Override
    public String toString() {
        return "AddExecutionRequest{" +
                "instrumentId='" + instrumentId + '\'' +
                ", executionQuantity=" + executionQuantity +
                ", executionPrice=" + executionPrice +
                '}';
    }
}
