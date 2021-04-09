/**
 * @author liudongjin
 * @date 2021/3/22 09:52
 */
public class Q13Moving {
    public int movingCount(int m, int n, int k) {
        if (m == 0 || n == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        return check(0, 0, k, visited);
    }

    public int check(int i, int j, int k, boolean[][] visited) {
        int m = visited.length;
        int n = visited[0].length;
        int ans = 0;
        if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && sum(i) + sum(j) <= k) {
            visited[i][j] = true;
            ans = 1;
            ans += check(i - 1, j, k, visited);
            ans += check(i + 1, j, k, visited);
            ans += check(i, j - 1, k, visited);
            ans += check(i, j + 1, k, visited);
        }
        return ans;
    }

    public int sum(int x) {
        int ans = 0;
        while (x > 0) {
            ans += x % 10;
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q13Moving test = new Q13Moving();
        System.out.println(test.movingCount(16, 8, 4));
    }
}
