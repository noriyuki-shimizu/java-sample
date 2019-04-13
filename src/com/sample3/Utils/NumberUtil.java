package com.sample3.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtil {

    private NumberUtil() {}

    public static boolean isNumber(String target) {
        String regex = "^[0-9]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(target);
        return m.find();
    }

}
