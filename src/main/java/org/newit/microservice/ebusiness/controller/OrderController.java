package org.newit.microservice.ebusiness.controller;

import java.util.List;

import org.newit.microservice.ebusiness.model.Order;
import org.newit.microservice.ebusiness.service.OrderService;
import org.newit.microservice.ebusiness.view.OrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

@Controller
public class OrderController{

    @Autowired
    private OrderService orderService;



    @RequestMapping(value = "/order/detail/{orderId}",method = RequestMethod.GET)
    @ResponseBody
    public Order orderDetail(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        return order;
    }

    @RequestMapping(value = "/order/buyerList/{buyerId}",method = RequestMethod.GET)
    @ResponseBody
    public List<Order> buyerOrderList(@PathVariable Long buyerId) {

        return orderService.getOrderListByBuyerId(buyerId);
    }


    @RequestMapping(value = "/order/sellerList/{sellerId}",method = RequestMethod.GET)
    @ResponseBody
    public List<Order> sellerOrderList(@PathVariable Long sellerId) {
        return orderService.getOrderListBySellerId(sellerId);
    }

    @RequestMapping(value = "/order/create",method = RequestMethod.POST)
    @ResponseBody
    public String createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return "success";
    }
}
