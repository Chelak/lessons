package org.scelac.l.ex1;

import java.util.Arrays;

public class SumCalculator {
    protected int[] numbers;

    public SumCalculator(int[] numbers) {
        this.numbers = numbers;
    }

    public int calculate(){
        return Arrays.stream(numbers).sum();
    }
}
