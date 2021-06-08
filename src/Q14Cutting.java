import java.util.Arrays;

/**
 * @author liudongjin
 * @date 2021/4/10 10:38
 * @description 剪绳子，将长度为n的绳子剪成m段，求每段绳子的最大乘积是多少，动态规划，P96
 */
public class Q14Cutting {
    static class Solution {
        public int cuttingRope(int n) {
            if (n < 2) {
                return 1;
            }
            if (n == 2) {
                return 1;
            }
            if (n == 3) {
                return 2;
            }
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;

            for (int i = 4; i <= n; i++) {
                int max = 0;
                for (int j = 1; j <= i / 2; j++) {
                    int temp = dp[j] * dp[i - j];
                    if (temp > max) {
                        max = temp;
                    }
                    dp[i] = max;
                }
            }
            System.out.println(Arrays.toString(dp));
            return dp[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(10));
    }
}
