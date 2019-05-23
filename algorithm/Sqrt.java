package algorithm;

/**
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * .
 */
public class Sqrt {
    public int mySqrt(int x) {
        int result = 0;
        int temp = (result + 1) * (result + 1);
        while(temp > 0 &&  temp <= x) {
            result += 1;
            temp = (result + 1) * (result + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Sqrt test = new Sqrt();
        System.out.println(test.mySqrt(2147395600));
    }
}
