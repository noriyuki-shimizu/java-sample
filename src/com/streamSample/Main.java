package com.streamSample;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = Collections.nCopies(10000000, "1");

        long start = System.currentTimeMillis();

        List<Integer> collect = list.stream()
                .map(String::valueOf)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");

        long start1 = System.currentTimeMillis();

        List<Integer> collect1 = list.stream()
                .map(l -> {
                    String s = String.valueOf(l);
                    return Integer.parseInt(s);
                })
                .collect(Collectors.toList());

        long end1 = System.currentTimeMillis();
        System.out.println((end1 - start1)  + "ms");
    }
}
