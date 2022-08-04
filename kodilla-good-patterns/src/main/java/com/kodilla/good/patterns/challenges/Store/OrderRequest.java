package com.kodilla.good.patterns.challenges.Store;

import java.time.LocalDateTime;

public class OrderRequest {
        private User user;
        private LocalDateTime dateOfOrder;

    public OrderRequest(User user, LocalDateTime dateOfOrder) {
        this.user = user;
        this.dateOfOrder = dateOfOrder;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }
}
