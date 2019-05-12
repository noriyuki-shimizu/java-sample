package com.sample3.domain.shop;

import com.sample3.domain.shop.price.Price;
import com.sample3.domain.foods.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 注文.
 */
public class Order {

    private List<Food> orderList = new ArrayList<>();

    private Function<List<Food>, Price> totalPriceCalcFunc = foodList -> {
        long totalPrice = foodList.stream().map(food -> food.getPrice().get())
                                .reduce((base, price) -> base + price).get();

        return new Price(totalPrice);
    };

    public void add(Food food) {
        this.orderList.add(food);

        System.out.println("### + " + food.toString());
        System.out.println("### 現在の合計金額(消費税込み): " + this.getTotalPrice().priceFormat() + " 円");
    }

    public Price getTotalPrice() {
        return this.totalPriceCalcFunc.apply(this.orderList);
    }

}
