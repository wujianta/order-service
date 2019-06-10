package org.newit.microservice.ebusiness.service;

import java.util.Calendar;
import java.util.List;

import org.newit.microservice.ebusiness.model.Order;
import org.newit.microservice.ebusiness.repository.OrderRepository;
import org.newit.microservice.ebusiness.view.OrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;



    public Order getOrderById(Long orderId) {
        return orderRepository.getOrderById(orderId);
    }

    public OrderView getOrderView(Order order){
        OrderView orderView = new OrderView();

        return orderView;
    }
    public void createOrder(Order order) {

        orderRepository.insert(order);
    }

    public List<Order> getOrderListByBuyerId(long buyerId) {
        return orderRepository.getOrderListByBuyerId(buyerId);
    }

    public List<Order> getOrderListBySellerId(long sellerId) {
        return orderRepository.getOrderListBySellerId(sellerId);
    }

}
