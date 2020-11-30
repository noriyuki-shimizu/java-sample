package com.pizza.domain;

import java.util.stream.Stream;

public enum Answer {
    YES(1) {
        @Override
        public boolean is(final Integer value) {
            return YES.value.equals(value);
        }
    },
    NO(2) {
        @Override
        public boolean is(final Integer value) {
            return NO.value.equals(value);
        }
    }
    ;

    Answer(final Integer value) {
        this.value = value;
    }

    private final Integer value;

    public abstract boolean is(Integer value);

    public static boolean hasValue(final Integer value) {
        return Stream.of(Answer.values())
                .map(Answer::getValue)
                .anyMatch(v -> v.equals(value));
    }

    public Integer getValue() {
        return value;
    }
}
