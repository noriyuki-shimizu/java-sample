package com.sample4;

public class Main {
    public static void main(String[] args) {
        Long num1 = 10L;
        Long num2 = 10L;

        Long loop = 1000000000000000000L;

        for(long i=0; i<loop; i++) {
            if(num1 == num2) {
//                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
