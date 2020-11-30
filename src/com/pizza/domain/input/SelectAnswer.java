package com.pizza.domain.input;

import com.pizza.domain.Answer;
import com.pizza.util.DisplayDictionary;
import com.sample3.domain.utils.NumberUtil;

import java.util.Scanner;

public class SelectAnswer {
    protected static final Scanner SCANNER = new Scanner(System.in);

    /**
     * yes か no を判定します.
     * @return yes: true, no: false
     */
    public boolean is() {
        final String yesMessage = String.format("%d: %s", Answer.YES.getValue(), "はい");
        final String noMessage = String.format("%d: %s", Answer.NO.getValue(), "いいえ");
        System.out.println(yesMessage);
        System.out.println(noMessage);

        final String order = SCANNER.next();

        if (!NumberUtil.isNumber(order)) {
            System.out.println(DisplayDictionary.onlyNumeric() + "\n");
            return is();
        }

        final Integer selectNum = Integer.valueOf(order);

        if (!Answer.hasValue(selectNum)) {
            System.out.println(DisplayDictionary.onlyYesOrNo(Answer.YES.getValue(), Answer.NO.getValue()) + "\n");
            return is();
        }

        return Answer.YES.is(selectNum);
    }
}
