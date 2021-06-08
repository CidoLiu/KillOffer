/**
 * @author liudongjin
 * @date 2021/3/18 23:15
 * @description 二维数组中的查找，P44
 */
public class Q4FindInSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int num = 5;
        System.out.println(findNumberIn2DArray(matrix, num));
    }

    /**
     * 二阶矩阵从上到下、从左到右升序，判断num是否存在于矩阵中
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
