package com.kodilla.good.patterns.challenges.Store;

public class OrderProcessor {

    private InformationService informationService;
    private OrderService orderService;
    private RepositoryService repositoryService;

    public OrderProcessor(InformationService informationService, OrderService orderService, RepositoryService repositoryService) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.repositoryService = repositoryService;
    }

    public OrderDto process(OrderRequest orderRequest) {
        boolean orderAccepted = orderService.isOrdered();
        if(orderAccepted) {
            informationService.sendOrderConfirmation(orderService.getItemID());
            repositoryService.saveOrderInformation(orderRequest, orderService.getItemID());
            return new OrderDto(orderRequest, true);
        } else
            return new OrderDto(orderRequest, false);
    }
}

