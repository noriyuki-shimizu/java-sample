package com.sample3.usecase;

/**
 * 実装におけるユースケース.
 */
public interface ICommand {

    /** メニューの表示 */
    public void displayMenuList();

    /** 注文 */
    public void displayOperation();

    /** 支払い */
    public void pay();

}
