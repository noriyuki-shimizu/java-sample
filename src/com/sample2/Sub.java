package com.sample2;

import java.util.function.Function;
import java.util.function.IntSupplier;

public class Sub extends Jene<String> {
    public Sub(String str) {
        super(str);
    }

    @Override
    public void display() {
        System.out.println(super.t);
    }

    @Override
    public void method1(String str) {
        System.out.println(super.t + " : " + str);
    }

    // 関数型インターフェース
    private Function<Integer, Integer> func = num -> {
        return num + 10;
    };

    private IntSupplier intSupplier = () -> 1000;

    private IntSupplier intSupplier2 = new IntSupplier() {
        @Override
        public int getAsInt() {
            return 1000;
        }
    };

    public void method2() {
        System.out.println(this.intSupplier.getAsInt());
    }

}
