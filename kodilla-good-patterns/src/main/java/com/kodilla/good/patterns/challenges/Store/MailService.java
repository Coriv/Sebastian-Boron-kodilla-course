package com.kodilla.good.patterns.challenges.Store;

public class MailService implements InformationService{
    @Override
    public void sendOrderConfirmation(int orderID) {
        System.out.println("Your order number: " + orderID + " is preparing to send");
    }
}
