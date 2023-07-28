package com.company;

import java.util.Date;

@Service
public class OrderService {

    private LogService logService;
    private NotificationService notificationService;
    private Order order;
    private CategoryTypeService categoryTypeService;

    public OrderService(
            NotificationService notificationService,
            LogService logService,
            TariffService tariffService,
            CategoryTypeService categoryTypeService
    ) {
        this.notificationService = notificationService;
        this.logService = logService;
        this.categoryTypeService = categoryTypeService;
    }

    public Order createOrder(String orderType, String description) {
        Order newOrder = new Order();
        newOrder.setCreatedAt(new Date());
        newOrder.setOrderType(orderType);
        newOrder.setDescription(description);
        // newOrder.setTariffDetails(this.tariffService.getTariffDetails(orderType));

        Integer orderCategory = this.categoryTypeService.getType(orderType);
        if(orderCategory != null) {
            newOrder.setCategory(orderCategory);
        }

        notificationService.notifyIfNewOrderIsCreated(newOrder);
        logService.sendLog(newOrder);

        this.order = newOrder;

        return newOrder;
    }

    public void changeOrderDetails(String description) {
        this.getOrder().setDescription(description);
        logService.sendLog(order);
    }

    public Order getOrder() {
        return this.order;
    }
}
