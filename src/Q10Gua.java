/**
 * @author liudongjin
 * @date 2021/3/21 15:31
 */
public class Q10Gua {

    public static int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        int ans = 0;
        for (int i = 2; i < n; i++) {
            ans = (first + second) % 1000000007;
            first = second;
            second = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numWays(3));
    }
}
