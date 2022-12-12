package org.scelac.l.ex1;

public class App {
  public static void main(String[] args) {
    int[] numbers = new int[] { 5, 7, 9, 8, 1, 6, 4 };
    SumCalculator sum = new SumCalculator(numbers);
    System.out.println("The sum of all numbers: " + sum.calculate());

    EvenNumbersSumCalculator evenSum = new EvenNumbersSumCalculator(numbers);
    System.out.println("The sum of all the even numbers: " + evenSum.calculate());

    //question
    SumCalculator evenSum2 = new EvenNumbersSumCalculator(numbers);
    System.out.printf("The sum of all the even numbers2: " + evenSum2.calculate());
  }
}
