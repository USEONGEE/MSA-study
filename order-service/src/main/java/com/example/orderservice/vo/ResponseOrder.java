package com.example.orderservice.vo;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.Order;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseOrder {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Date createdAt;

    private String orderId;

    public static ResponseOrder of(Order order) {
        ResponseOrder responseOrder = new ResponseOrder();
        responseOrder.setProductId(order.getProductId());
        responseOrder.setQty(order.getQty());
        responseOrder.setUnitPrice(order.getUnitPrice());
        responseOrder.setTotalPrice(order.getTotalPrice());
        responseOrder.setCreatedAt(order.getCreatedAt());

        return responseOrder;
    }

    public static ResponseOrder of(OrderDto orderDto) {
        ResponseOrder responseOrder = new ResponseOrder();
        responseOrder.setProductId(orderDto.getProductId());
        responseOrder.setQty(orderDto.getQty());
        responseOrder.setUnitPrice(orderDto.getUnitPrice());
        responseOrder.setTotalPrice(orderDto.getTotalPrice());

        return responseOrder;
    }
}