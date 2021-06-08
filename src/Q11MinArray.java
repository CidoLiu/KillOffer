/**
 * @author liudongjin
 * @date 2021/3/21 21:34
 * @description 旋转数组的最小数字，如{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，找到最小的数组1，P82
 */
public class Q11MinArray {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int len = numbers.length;
        int left = 0;
        int right = len - 1;
        int minIndex = 0;
        while (numbers[left] >= numbers[right]) {
            if (left == right - 1) {
                minIndex = right;
                break;
            }
            int mid = left + (right - left) / 2;
            // 特殊情况
            if (numbers[mid] == numbers[left] && numbers[mid] == numbers[right]) {
                return findIndex(numbers, left, right);
            }
            if (numbers[mid] >= numbers[left]) {
                left = mid;
            } else if (numbers[mid] <= numbers[right]) {
                right = mid;
            }
        }
        return numbers[minIndex];
    }

    public int findIndex(int[] numbers, int left, int right) {
        int result = left;
        for (int i = left; i <= right; i++) {
            if (numbers[i] <= numbers[result]) {
                result = i;
            }
        }
        return numbers[result];
    }

    public static void main(String[] args) {
        Q11MinArray test = new Q11MinArray();
        System.out.println(test.minArray(new int[]{2, 2, 2, 0, 1}));
    }
}
