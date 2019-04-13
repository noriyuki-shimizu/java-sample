package com.sample3;

import com.sample3.food.Food;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private Menu() {}

    private static Menu menu = new Menu();

    private static List<String> menuList = new ArrayList<>();

    public static Menu getInstance(List<String> menuList) {
        menu.menuList = menuList;
        return menu;
    }

    public void display() {
        menuList.forEach(System.out::println);
    }

}
