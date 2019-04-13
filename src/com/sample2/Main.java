package com.sample2;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Sub sub = new Sub("taro");

        sub.display();
        sub.method2();

    }

    private static void method1() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(9);

        //イテレータを使って、このように書くのがキレイ。
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            int i = it.next();
            if(i % 2 == 0) it.remove();
        }

        //listがどんな状態か表示してみる。
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
