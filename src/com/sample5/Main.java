package com.sample5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        final int n = 4;

        for (int i=0; i<n; i++) {
            System.out.println((i + 1) + "人目のお名前は？");
            String name = SCANNER.next();
            nameList.add(name);
        }

//        nameList.forEach(System.out::println);

        for (int i=0; i<n; i++) {
            if (i == n - 1) {
                System.out.println((i + 1) + "人目のお名前: " + nameList.get(i) + "!");
                break;
            }
            System.out.print((i + 1) + "人目のお名前: " + nameList.get(i) + "、");
        }
        System.out.println("べニーズへようこそ！");
    }
}
