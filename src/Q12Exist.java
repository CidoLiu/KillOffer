/**
 * @author liudongjin
 * @date 2021/3/21 21:55
 * @description 矩阵中的路径，判断字符矩阵中是否包含某一字符串路径，P89
 */
public class Q12Exist {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int wordIndex = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (exist(board, i, j, word, wordIndex, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, int i, int j, String word, int wordIndex, boolean[][] visited) {
        if (wordIndex == word.length()) {
            return true;
        }
        boolean hasPath = false;
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == word.charAt(wordIndex)
                && !visited[i][j]) {
            wordIndex++;
            visited[i][j] = true;
            hasPath = exist(board, i + 1, j, word, wordIndex, visited)
                    || exist(board, i - 1, j, word, wordIndex, visited)
                    || exist(board, i, j + 1, word, wordIndex, visited)
                    || exist(board, i, j - 1, word, wordIndex, visited);
            if (!hasPath) {
                visited[i][j] = false;
                --wordIndex;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        Q12Exist test = new Q12Exist();
        char[][] board = {{'a'}};
        System.out.println(test.exist(board, "ab"));
    }
}
