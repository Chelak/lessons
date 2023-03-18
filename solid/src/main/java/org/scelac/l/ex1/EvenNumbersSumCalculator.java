package org.scelac.l.ex1;

import java.util.Arrays;

public class EvenNumbersSumCalculator extends SumCalculator {

    public EvenNumbersSumCalculator(int[] numbers) {
        super(numbers);
    }
    @Override
    public int calculate(){
        return Arrays.stream(numbers).filter(i -> i % 2 == 0).sum();
    }


}
