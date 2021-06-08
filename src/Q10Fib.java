/**
 * @author liudongjin
 * @date 2021/3/21 15:19
 * @description 斐波那契数列，P74
 */
public class Q10Fib {

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int p = 0;
        int q = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = (p + q) % 1000000007;
            p = q;
            q = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fib(45));
    }
}
