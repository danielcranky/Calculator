package com.danielcranky;

public class Num {
    private int value;
    private NumType type;

    Num(int value, NumType type) {
        this.value = value;
        this.type = type;
    }

    NumType getType() {
        return type;
    }

    int getValue() {
        return value;
    }
}
