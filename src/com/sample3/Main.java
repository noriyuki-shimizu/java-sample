package com.sample3;

import com.sample3.food.Food;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    private static Menu menu = new Menu();

    private static long totalPrice = 0;

    public static void main(String[] args) {
        displayMenuList();
        displayOperation();
        pay();
    }

    private static String priceFormat(long price) {
        NumberFormat numberFormat = NumberFormat.getInstance();

        return numberFormat.format(price);
    }

    private static void displayMenuList() {
        menu = new Menu(
                "1. ハンバーグカレードリア 799 円",
                "2. ベーコンチーズハンバーグ 999 円",
                "3. 3種のエビのドリア 899 円",
                "4. マンゴーのショートケーキ 499 円",
                "5. ドリンクバー 399 円",
                "6. ポテト 10000 円"
        );

        System.out.println("こちらがメニューです。");

        menu.display();
    }

    private static void displayOperation() {
        System.out.println("お決まりでしたら、番号で教えてください。注文を終える場合は 0 を入力してください。");
        while (true) {

            int orderNum = scan.nextInt();

            if(orderNum == 0) {
                break;
            }

            for(Food food : menu.getFoodList()) {
                if(food.getId() == orderNum) {
                    totalPrice += food.getPrice();

                    System.out.println(food.getName() + " + 1");

                    break;
                }
            }
        }
    }

    private static void pay() {
        System.out.println("合計注文数点のご注文で、消費税を入れると" + priceFormat(totalPrice) + "円になりますが、 今日はサービスして 100 円以下を切り捨てた金額円で結構です。");
        int floorTotalPrice = (int) (totalPrice - Math.floor(totalPrice % 100));

        System.out.println("請求額: " + priceFormat(floorTotalPrice) + " 円");

        while (true) {
            System.out.print("支払額: ");
            int inputPrice = scan.nextInt();

            System.out.println(" 円");

            if(inputPrice - floorTotalPrice > 0) {
                System.out.println("お釣りは" + priceFormat(inputPrice - floorTotalPrice) + "です！");

                break;
            } else if(inputPrice - floorTotalPrice == 0) {
                System.out.println("ちょうど、お受取いたします！");

                break;
            } else {
                System.out.println("請求額より" + priceFormat(Math.abs(inputPrice - floorTotalPrice)) + "少ないです！！");
            }
        }
        System.out.println("ありがとうございました！");
    }
}
