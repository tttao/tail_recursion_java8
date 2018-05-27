import java.math.BigInteger;
import java.util.stream.Stream;

public class TailRecursionFibonacci {
    public BigInteger compute(BigInteger u0, BigInteger u1, int n) {
        TailCallExpressionJava8<BigInteger> tce = _compute(u0, u1, n);
        return tce.runRecursiveFunction();
    }

    private TailCallExpressionJava8<BigInteger> _compute(BigInteger u0, BigInteger u1, int n) {
        if (n == 0) {
            return new TailCallExpressionJava8.Done<>(u0);
        }
        if (n == 1) {
            return new TailCallExpressionJava8.Done<>(u1);
        }

        return () -> _compute(u1, u0.multiply(BigInteger.valueOf(1)).add(u1), n-1);
    }

    // From https://github.com/dhaeb/TailCalls
    @FunctionalInterface
    public interface TailCallExpressionJava8<T> {
        TailCallExpressionJava8<T> apply();

        default T result() {
            throw new UnsupportedOperationException("There is no result computed yet!");
        }

        default boolean isCompleted() {
            return false;
        }

        default T runRecursiveFunction() {
            return Stream.iterate(this, TailCallExpressionJava8::apply)
                    .filter(TailCallExpressionJava8::isCompleted)
                    .findFirst()
                    .get()
                    .result();
        }

        public static class Done<T> implements TailCallExpressionJava8<T> {

            private T result;

            @Override
            public TailCallExpressionJava8<T> apply() {
                throw new UnsupportedOperationException("Can't apply a Done object! The result is already available!");
            }

            public Done(T result ) {
                this.result = result;
            }

            @Override
            public boolean isCompleted() {
                return true;
            }

            @Override
            public T result() {
                return result;
            }

            @Override
            public T runRecursiveFunction() {
                return result();
            }
        }

    }
}
