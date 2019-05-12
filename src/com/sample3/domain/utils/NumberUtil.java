package com.sample3.domain.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数値に対するUtilクラス.
 */
public class NumberUtil {

    private NumberUtil() {}

    /**
     * 数値か判定.
     * @param target 対象文字列
     * @return {数値である場合：true, それ以外：false}
     */
    public static boolean isNumber(String target) {
        String regex = "^[0-9]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(target);
        return m.find();
    }

}
