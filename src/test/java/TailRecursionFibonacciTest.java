import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class TailRecursionFibonacciTest {

    @org.junit.Test
    public void simple_compute() {
        TailRecursionFibonacci fibonacci = new TailRecursionFibonacci();
        long result = fibonacci.compute(BigInteger.ZERO, BigInteger.ONE, 3).longValue();
        assertEquals(8, result);
    }

    // You can check the result on http://www.javascripter.net/math/calculators/fibonaccinumberscalculator.htm
    @org.junit.Test(expected = StackOverflowError.class)
    public void stack_overflow() {
        TailRecursionFibonacci fibonacci = new TailRecursionFibonacci();
        System.out.println("Result:" + fibonacci.compute(BigInteger.ZERO, BigInteger.ONE, 50000).toString());
    }
}