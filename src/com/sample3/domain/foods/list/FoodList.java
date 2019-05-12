package com.sample3.domain.foods.list;

import com.sample3.domain.foods.Food;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FoodList {
    private List<Food> values;

    public FoodList(List<Food> values) {
        this.values = values;
    }

    public List<Food> get() {
        return this.values;
    }

    public Optional<Food> getOrderFood(int orderNum) {
        Stream<Food> foodStream = this.values.stream().filter(food -> orderNum == food.getId());

        return foodStream.findFirst();
    }

}
