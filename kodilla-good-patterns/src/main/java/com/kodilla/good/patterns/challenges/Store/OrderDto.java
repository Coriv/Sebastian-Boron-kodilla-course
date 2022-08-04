package com.kodilla.good.patterns.challenges.Store;

public class OrderDto {
    private OrderRequest orderRequest;
    private boolean sold;

    public OrderDto(OrderRequest orderRequest, boolean sold) {
        this.orderRequest = orderRequest;
        this.sold = sold;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public boolean isSold() {
        return sold;
    }
}
