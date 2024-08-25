package com.example.orderservice.dto;


import com.example.orderservice.entity.Order;
import com.example.orderservice.vo.RequestOrder;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDto implements Serializable {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;

    public Order toEntity() {
        Order order = new Order();
        order.setProductId(this.getProductId());
        order.setQty(this.getQty());
        order.setUnitPrice(this.getUnitPrice());
        order.setTotalPrice(this.getTotalPrice());
        order.setOrderId(this.getOrderId());
        order.setUserId(this.getUserId());
        return order;
    }

    public static OrderDto of(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setProductId(order.getProductId());
        orderDto.setQty(order.getQty());
        orderDto.setUnitPrice(order.getUnitPrice());
        orderDto.setTotalPrice(order.getTotalPrice());
        orderDto.setOrderId(order.getOrderId());
        orderDto.setUserId(order.getUserId());
        return orderDto;
    }

    public static OrderDto of(RequestOrder requestOrder) {
        OrderDto orderDto = new OrderDto();
        orderDto.setProductId(requestOrder.getProductId());
        orderDto.setQty(requestOrder.getQty());
        orderDto.setUnitPrice(requestOrder.getUnitPrice());
        orderDto.setTotalPrice(requestOrder.getQty() * requestOrder.getUnitPrice());
        return orderDto;
    }
}
