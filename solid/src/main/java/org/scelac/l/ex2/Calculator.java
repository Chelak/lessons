package org.scelac.l.ex2;

public abstract class Calculator {
    protected int[] numbers;

    public Calculator(int[] numbers) {
        this.numbers = numbers;
    }

    public abstract int calculate();
}
