package com.kodilla.good.patterns.challenges.Store;

public class ProductOrderService {
    public static void main(String[] args) {

       OrderRequestRetriever orr = new OrderRequestRetriever();


        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new Spoon(), new WebRepository());
        orderProcessor.process(orr.retriever());
    }
}
