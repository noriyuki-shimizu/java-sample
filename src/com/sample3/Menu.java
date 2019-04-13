package com.sample3;

import com.sample3.foods.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {

    private Menu() {}

    private static Menu menu = new Menu();

    private static List<String> menuList = new ArrayList<>();

    public static Menu getInstance(List<Food> foodList) {
        menuList = foodList.stream()
                         .map(food -> food.toString())
                         .collect(Collectors.toCollection(ArrayList::new));

        return menu;
    }

    public void display() {
        menuList.forEach(System.out::println);
    }

}
