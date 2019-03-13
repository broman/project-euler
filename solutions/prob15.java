import java.math.BigInteger;
public class prob15 {
    public static void main(String[] args) {
        new prob15().latticePaths(40, 20);
    }
    public void latticePaths(int n, int k) {
        // This is actually extremely easy.
        // Using binomial coeffecients, we can reckon that:
        // n! / (n-k)!k!
        System.out.println(factorial(BigInteger.valueOf(n)));
        //System.out.println(num / denom);
    }
    public BigInteger factorial(BigInteger n) {
        if(n.equals(0)) return BigInteger.valueOf(1);
        return(n.multiply(factorial(n.subtract(BigInteger.valueOf(1)))));
    }
}
