package com.osds.bookstorebackend.modal;

import java.util.List;

public class OrderRequest {

    private List<OrderPOJO> orderItems;

    public List<OrderPOJO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderPOJO> orderItems) {
        this.orderItems = orderItems;
    }
}
