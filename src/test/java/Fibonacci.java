public class Fibonacci {
    public static void Fibonacci(int limit) {
        int a = 0;
        int b = 1;
        int sum = 0;
        do {
            sum = a + b;
            a = b;
            b = sum;
            if (sum >= 100) {
                break;
            }
            System.out.println(sum);
        } while (sum <= limit);
    }

}
