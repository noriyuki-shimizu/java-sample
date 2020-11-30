package com.pizza.util;

public class DisplayDictionary {
    private static final String WELCOME = "いらっしゃいませ！";
    private static final String COMING_AGAIN = "ありがとうございます！\nまたのお越しをお待ちしております！";
    private static final String ORDER = "注文番号";
    private static final String PIZZA = "ピザ";
    private static final String SIZE = "サイズ";
    private static final String TOPPING = "トッピング";
    private static final String PRICE = "金額";
    private static final String PAYMENT_PRICE = "支払い金額";
    private static final String ONLY_YES_OR_NO = "%d か %d を選択してください。";
    private static final String SELECT_PRODUCT = "下記のメニューからお好きなものを注文してください！";
    private static final String SELECT_PRODUCT_NOT_FOUND = "申し訳ございません。%d のメニューは存在しません。";
    private static final String SELECT_SIZE = "サイズを下記からお選びください！";
    private static final String SELECT_SIZE_NOT_FOUND = "申し訳ございません。%d のサイズは存在しません。";
    private static final String SELECT_TOPPING = "トッピングを下記からお選びください！";
    private static final String SELECT_TOPPING_NOT_FOUND = "申し訳ございません。%d のトッピングは存在しません。";
    private static final String ONLY_NUMERIC = "数値のみ入力してください。";
    private static final String REORDER = "さらに注文しますか？";
    private static final String TOPPING_REORDER = "他にトッピングしますか？";
    private static final String ADD_PIZZA = "ピザを追加しました。";
    private static final String INPUT_PAYMENT_PRICE = "合計金額は %s 円となります。\n支払いの金額を入力してください。";
    private static final String BILL = "%s 円お預かりします。\nお返しは %s 円となります。";

    public static String welcome() {
        return WELCOME;
    }

    public static String comingAgain() {
        return COMING_AGAIN;
    }

    public static String order() {
        return ORDER;
    }

    public static String pizza() {
        return PIZZA;
    }

    public static String size() {
        return SIZE;
    }

    public static String topping() {
        return TOPPING;
    }

    public static String price() {
        return PRICE;
    }

    public static String paymentPrice() {
        return PAYMENT_PRICE;
    }

    public static String onlyYesOrNo(final int yes, final int no) {
        return String.format(ONLY_YES_OR_NO, yes, no);
    }

    public static String selectProduct() {
        return SELECT_PRODUCT;
    }

    public static String selectProductNotFound(final long no) {
        return String.format(SELECT_PRODUCT_NOT_FOUND, no);
    }

    public static String selectSize() {
        return SELECT_SIZE;
    }

    public static String selectSizeNotFound(final long no) {
        return String.format(SELECT_SIZE_NOT_FOUND, no);
    }

    public static String selectTopping() {
        return SELECT_TOPPING;
    }

    public static String selectToppingNotFound(final long no) {
        return String.format(SELECT_TOPPING_NOT_FOUND, no);
    }

    public static String onlyNumeric() {
        return ONLY_NUMERIC;
    }

    public static String reorder() {
        return REORDER;
    }

    public static String toppingReorder() {
        return TOPPING_REORDER;
    }

    public static String addPizza() {
        return ADD_PIZZA;
    }

    public static String paymentAmount(final String price) {
        return String.format(INPUT_PAYMENT_PRICE, price);
    }

    public static String bill(final String billPrice, final String differencePrice) {
        return String.format(BILL, billPrice, differencePrice);
    }
}
