package com.sample3.domain.shop;

import com.sample3.domain.foods.Food;
import com.sample3.domain.foods.list.FoodList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * メニュー.
 */
public class Menu {

    private Menu() {}

    private static Menu menu = new Menu();

    private static List<String> menuList = new ArrayList<>();

    public static Menu getInstance(FoodList foodList) {
        menuList = foodList.get().stream()
                         .map(food -> food.toString())
                         .collect(Collectors.toCollection(ArrayList::new));

        return menu;
    }

    public void display() {
        menuList.forEach(System.out::println);
    }

}
