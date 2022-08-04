package com.kodilla.good.patterns.challenges.Store;

public interface RepositoryService {
    void saveOrderInformation(OrderRequest orderRequest, int productID);
}
