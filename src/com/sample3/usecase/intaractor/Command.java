package com.sample3.usecase.intaractor;

import com.sample3.domain.foods.Food;
import com.sample3.domain.foods.list.FoodList;
import com.sample3.domain.shop.Menu;
import com.sample3.domain.shop.Order;
import com.sample3.domain.shop.price.Price;
import com.sample3.domain.utils.NumberUtil;
import com.sample3.usecase.ICommand;

import java.util.Optional;
import java.util.Scanner;

/**
 * ユースケースによる実装クラス.
 */
public class Command implements ICommand {
    /** 標準入力 */
    private Scanner scanner = new Scanner(System.in);

    /** フードリスト */
    private FoodList foodList;

    /** 注文管理 */
    private Order order;

    public Command(FoodList foodList) {
        this.foodList = foodList;
    }

    @Override
    public void displayMenuList() {
        Menu menu = Menu.getInstance(this.foodList);
        menu.display();
    }

    @Override
    public void displayOperation() {
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

            Optional<Food> optionalFood = this.foodList.getOrderFood(orderNum);
            if (optionalFood.isEmpty()) {
                System.out.println("【 " + inputOrder + " 】" + "はメニューに存在しません。");
                continue;
            }

            this.order.add(optionalFood.get());

        }
    }

    @Override
    public void pay() {
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
