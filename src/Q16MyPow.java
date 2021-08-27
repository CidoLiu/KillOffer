/**
 * @author liudongjin
 * @date 2021/6/9 08:04
 * @description 求数值的整数次方
 */
public class Q16MyPow {

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if(n == 0) {
            return 1;
        }
        // Math.abs: Note that if the argument is equal to the value of Integer.MIN_VALUE, the most negative representable int value, the result is that same value, which is negative.
        double result = myPowAbsN(x, Math.abs(n));
        if (n < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    public double myPowAbsN(double x, int n) {
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    public static void main(String[] args) {
        Q16MyPow q16MyPow = new Q16MyPow();
        System.out.println(q16MyPow.myPow(5, 2));
        System.out.println(q16MyPow.myPow(4, -2));
        System.out.println(q16MyPow.myPow(2.00000, -2147483648));
        /**
         * int -2147483648 因为编码的原因，它的绝对值也是负数，所以对于这一特殊数据不能处理
         * 若将类型强制转换为long计算，会导致超时
         */
    }
}
