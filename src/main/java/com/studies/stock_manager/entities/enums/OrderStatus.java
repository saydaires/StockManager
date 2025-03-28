package com.studies.stock_manager.entities.enums;

public enum OrderStatus {
    PROCESSING("Processing"),
    SENT("Sent"),
    DELIVERED("Delivered");

    private String orderStatus;

    OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
