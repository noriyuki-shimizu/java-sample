package com.sample3;

import com.sample3.Utils.NumberUtil;
import com.sample3.foods.*;

import java.util.*;
import java.util.stream.Stream;

public class Command {
    private Scanner scanner = new Scanner(System.in);

    private List<Food> foodList;

    private Order order;

    public Command() {
        this.foodList = Arrays.asList(
                new Western("ハンバーグカレードリア", 799),
                new Western("ベーコンチーズハンバーグ", 999),
                new Western("3種のエビのドリア", 899),
                new Dessert("マンゴーのショートケーキ", 499),
                new Drink("ドリンクバー", 399),
                new Junk("ポテト", 299)
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
            String inputOrder = scanner.next();

            if (!NumberUtil.isNumber(inputOrder)) {
                System.out.println("番号を指定してください。");

                continue;
            }

            int orderNum = Integer.parseInt(inputOrder);

            if (orderNum == 0) {
                break;
            }

            Stream<Food> foodStream = this.foodList.stream().filter(food -> orderNum == food.getId());

            Optional<Food> optionalFood = foodStream.findFirst();
            if (optionalFood.isEmpty()) {
                System.out.println("【 " + inputOrder + " 】" + "はメニューに存在しません。");
                continue;
            }

            Food food = optionalFood.get();

            this.order.add(food);

        }
    }

    private void pay() {
        Price totalPrice = this.order.getTotalPrice();

        System.out.print("合計注文数点のご注文で、消費税を入れると" + totalPrice.getPlusTax().priceFormat() + " 円になりますが、 ");
        System.out.println("今日はサービスして 100 円以下を切り捨てた金額円で結構です。");

        Price servicePrice = totalPrice.getPlusTax().getServicePrice();

        System.out.println("請求額: " + servicePrice.priceFormat() + " 円");

        while (true) {
            System.out.print("支払額: ");

            String inputPrice = scanner.next();

            if (!NumberUtil.isNumber(inputPrice)) {
                System.out.println("支払額は数値で入力してください。");

                continue;
            }

            Price payPrice = new Price(Integer.parseInt(inputPrice));
            Price diffPrice = new Price(payPrice.get() - servicePrice.get());

            if (diffPrice.get() > 0) {
                System.out.println("お釣りは" + diffPrice.priceFormat() + " 円です！");

                break;
            } else if (diffPrice.get() == 0) {
                System.out.println(servicePrice.priceFormat() + " 円ちょうど、お受取いたします！");

                break;
            } else {
                Price absPrice = new Price(Math.abs(diffPrice.get()));
                System.out.println("請求額より" + absPrice.priceFormat() + " 円少ないです！！");
            }
        }
        System.out.println("ありがとうございました！");
    }

}
