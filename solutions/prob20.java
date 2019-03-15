import java.math.BigInteger;

// Find the sum of the digits of 100!

/*
 * We can use the factorial method from Problem 15 to solve this problem.
*/

public class prob20 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int sum = sumOfDigits(factorial(BigInteger.valueOf(100)));
        long end = System.nanoTime();
        System.out.println(sum);
        System.out.println("Took " + (end - start) / 100000 + "ms");
    }
    public static BigInteger factorial(BigInteger n) {
        // Thanks for not having operator overloading Java! >:(
        if(n.equals(BigInteger.valueOf(0))) return BigInteger.valueOf(1);
        return(n.multiply(factorial(n.subtract(BigInteger.valueOf(1)))));
    }
    public static int sumOfDigits(BigInteger n) {
        int sum = 0;
        String digits = n.toString();
        for(int i = 0; i < digits.length(); i++) {
            int digit = (int) (digits.charAt(i) - '0');
            sum += digit;
        }
        return sum;
    }
}