package com.sample6;

import java.util.List;

public class Test {
    public void exec(List<String> args) {
        args.forEach(this::exec);
    }
    public void exec(String arg) {
        System.out.println(arg);
    }
}
