package org.scelac.l.ex2;

import java.util.Arrays;

public class SumCalculator extends Calculator{
    public SumCalculator(int[] numbers) {
        super(numbers);
    }

    @Override
    public int calculate() {
        return Arrays.stream(numbers).sum();
    }
}
