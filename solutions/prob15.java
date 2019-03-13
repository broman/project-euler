import java.math.BigInteger;
public class prob15 {
    public static void main(String[] args) {
        new prob15().latticePaths(40, 20);
    }
    public void latticePaths(int n, int k) {
        // This is actually extremely easy.
        // Using binomial coeffecients, we can reckon that:
        // n! / (n-k)!k!
        BigInteger numerator = factorial(BigInteger.valueOf(n));
        BigInteger denominator = factorial(BigInteger.valueOf(n-k))
            .multiply(factorial(BigInteger.valueOf(k)));
        System.out.println(numerator.divide(denominator));
    }
    public BigInteger factorial(BigInteger n) {
        // Thanks for not having operator overloading Java! >:(
        if(n.equals(BigInteger.valueOf(0))) return BigInteger.valueOf(1);
        return(n.multiply(factorial(n.subtract(BigInteger.valueOf(1)))));
    }
}
