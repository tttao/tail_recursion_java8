public class RecursiveFibonacci {
    public int compute(int u0, int u1, int n) {
        if (n == 0) {
            return u0;
        }

        if (n == 1) {
            return u1;
        }

        return compute(u0, u1, n - 1) + 2 * compute(u0, u1, n - 2);
    }
}
