package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        sampleFor();
        sampleMethod();
        sampleClass();
    }

    public static void sampleFor() {
        String str = "hello! world!";
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        char[] chars = str.toCharArray();

        for (int i=0; i<chars.length; i++) {
            System.out.println(chars[i]);
        }

        int cnt=0;
        while (cnt<chars.length) {
            System.out.println(chars[cnt]);
            cnt++;
        }

        List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        int totalNum = 0;
        for(int i=0; i<numList.size(); i++) {
            totalNum += numList.get(i);
        }
        System.out.println(totalNum);

        totalNum = 0;
        for(Integer num: numList) {
            totalNum += num;
        }
        System.out.println(totalNum);

        // Java8ならではの書き方
        totalNum = 0;
        totalNum = numList.stream().reduce((base, num) -> base + num).get();
        System.out.println(totalNum);
    }

    public static void sampleMethod() {
        average(1,4, 3, 5, 10);
    }

    public static void sampleClass() {
        Sample sample = new Sample("taro");
        System.out.println(sample.toString());
    }

    public static void average(int ... numArr) {
        int total = 0;
        for(int i=0; i<numArr.length; i++) {
            total += numArr[i];
        }
        System.out.println("平均：" + (double) total / numArr.length);
    }
}
