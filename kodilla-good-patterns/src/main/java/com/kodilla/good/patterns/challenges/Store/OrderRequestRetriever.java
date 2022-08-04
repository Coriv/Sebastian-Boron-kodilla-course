package com.kodilla.good.patterns.challenges.Store;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retriever() {
        User user = new User("First User");
        LocalDateTime timeOfOrder = LocalDateTime.of(2022, 07, 30, 15, 00);

        return new OrderRequest(user, timeOfOrder);
    }
}
