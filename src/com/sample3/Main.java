package com.sample3;

import com.sample3.domain.foods.*;
import com.sample3.domain.foods.list.FoodList;
import com.sample3.usecase.intaractor.Command;
import com.sample3.usecase.ICommand;

import java.util.Arrays;

public class Main {

    private static FoodList foodList = new FoodList(Arrays.asList(
            new Western("ハンバーグカレードリア", 799),
            new Western("ベーコンチーズハンバーグ", 999),
            new Western("3種のエビのドリア", 899),
            new Dessert("マンゴーのショートケーキ", 499),
            new Drink("ドリンクバー", 399),
            new Junk("ポテト", 299)
    ));

    private static ICommand command = new Command(foodList);

    public static void main(String[] args) {
        command.displayMenuList();
        command.displayOperation();
        command.pay();
    }

}
