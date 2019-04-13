package com.sample3;

import com.sample3.food.*;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Stream;

public class Command {
    private Scanner scanner = new Scanner(System.in);

    private List<Food> foodList;

    private Order order;

    public Command() {
        this.foodList = Arrays.asList(
                new Western(1, "ハンバーグカレードリア", 799),
                new Western(2, "ベーコンチーズハンバーグ", 999),
                new Western(3, "3種のエビのドリア", 899),
                new Dessert(4, "マンゴーのショートケーキ", 499),
                new Drink(5, "ドリンクバー", 399),
                new Junk(6, "ポテト", 299)
        );
    }

    public void execute() {
        this.displayMenuList();
        this.displayOperation();
        this.pay();
    }

    private void displayMenuList() {
        Menu menu = Menu.getInstance(this.foodList);
        menu.display();
    }

    private void displayOperation() {
        this.order = new Order();

        System.out.println("お決まりでしたら、番号で教えてください。注文を終える場合は 0 を入力してください。");
        while (true) {
            try {
                    int orderNum = scanner.nextInt();

                    if(orderNum == 0) {
                        break;
                    }

                    Stream<Food> foodStream = this.foodList.stream().filter(food -> orderNum == food.getId());

                    Food food = foodStream.findFirst().get();
                    if(this.isNull(food)) {
                        System.out.println("メニューに存在しません。");
                        continue;
                    }

                    this.order.add(food);

            } catch(InputMismatchException e) {
                System.err.println("数値で入力してください");
            }
        }
    }

    private void pay() {
        Price totalPrice = this.order.getTotalPrice();

        System.out.println("合計注文数点のご注文で、消費税を入れると" + totalPrice.get() + "円になりますが、 今日はサービスして 100 円以下を切り捨てた金額円で結構です。");

        double floorTotalPriceDouble = totalPrice.get() - Math.floor(totalPrice.get() % 100);
        Price floorTotalPrice = new Price((long) floorTotalPriceDouble);

        System.out.println("請求額: " + floorTotalPrice.get() + " 円");

        while (true) {
            try {
                System.out.print("支払額: ");

                Price inputPrice = new Price(scanner.nextInt());
                Price diffPrice = new Price(inputPrice.get() - floorTotalPrice.get());

                System.out.print(" 円");

                if(diffPrice.get() > 0) {
                    System.out.println("お釣りは" + diffPrice.priceFormat() + "です！");

                    break;
                } else if(diffPrice.get() == 0) {
                    System.out.println("ちょうど、お受取いたします！");

                    break;
                } else {
                    Price absPrice = new Price(Math.abs(diffPrice.get()));
                    System.out.println("請求額より" + absPrice.priceFormat() + "少ないです！！");
                }
            } catch(InputMismatchException e) {
                System.err.println("支払額は数値で入力してください。");
            }
        }
        System.out.println("ありがとうございました！");
    }

    private <T> boolean isNull(T t){
        return t == null;
    }
}
