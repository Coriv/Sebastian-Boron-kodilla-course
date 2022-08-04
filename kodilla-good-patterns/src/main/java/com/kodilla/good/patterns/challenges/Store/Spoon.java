package com.kodilla.good.patterns.challenges.Store;

public class Spoon implements OrderService{
    final static int PRODUCT_ID = 23131;
    @Override
    public boolean isOrdered() {
        return true;
    }

    @Override
    public int getItemID() {
        return PRODUCT_ID;
    }
}
