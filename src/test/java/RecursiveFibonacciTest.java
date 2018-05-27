import static org.junit.Assert.*;

public class RecursiveFibonacciTest {

    @org.junit.Test
    public void simple_compute() {
        RecursiveFibonacci recursiveFibonacci = new RecursiveFibonacci();
        int result = recursiveFibonacci.compute(1, 2, 3);
        assertEquals(8, result);
    }

    @org.junit.Test(expected = StackOverflowError.class)
    public void stack_overflow() {
        RecursiveFibonacci recursiveFibonacci = new RecursiveFibonacci();
        recursiveFibonacci.compute(1, 2, 100000);
    }
}