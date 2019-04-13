package com.sample3;

import com.sample3.food.Food;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Food> orderList = new ArrayList<>();

    private long totalPrice;

    public void add(Food food) {
        this.orderList.add(food);
    }

    public void calculation() {
        this.totalPrice = this.orderList.stream().map(food -> food.getPrice())
                .reduce((base, price) -> base + price).get();
    }

}
