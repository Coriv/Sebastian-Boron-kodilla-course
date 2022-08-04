package com.kodilla.good.patterns.challenges.Store;

public class WebRepository implements RepositoryService {
    @Override
    public void saveOrderInformation(OrderRequest orderRequest, int productID) {
        System.out.println("Save to repository: \nUser: " + orderRequest.getUser().getLogin() + " " +
                "bought product number: " + productID + "\nDate of order: " + orderRequest.getDateOfOrder());
    }
}