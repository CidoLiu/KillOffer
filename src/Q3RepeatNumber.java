/**
 * @author liudongjin
 * @date 2021/3/16 23:20
 */
public class Q3RepeatNumber {

    /**
     * 利用数组的范围特点，数组代替hash，遍历一次对数组进行计数
     * 时间负责度：O(n)
     * 空间负责度：O(n)
     */
    public static int findRepeatNumberFirst(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] counter = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
            if (counter[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 原地重排数组
     * 时间负责度为O(n)
     * 空间负责度为O(1)
     */
    public static int findRepeatNumberSecond(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                swap(nums, nums[i], i);
                i--;
            }
        }
        return -1;
    }

    public static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    /**
     * 利用二分查找0～n个数在数组中出现的次数，每次缩小范围
     * 时间复杂度：O(nlogn)
     * 空间负责度：O(1)
     */
    public static int findRepeatNumberThird(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;
        while (left<=right) {
            middle = left + (right - left) / 2;
            int counter = count(nums, left, middle);
            if (left == right) {
                if (counter > 1) {
                    return left;
                } else {
                    return -1;
                }
            }
            if (counter > middle - left + 1) {
//                right = middle - 1;
                right = middle; // 避免刚好middle是重复的数字
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static int count(int[] nums, int left, int right) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >=  left && nums[i] <= right) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 0, 2, 5, 3};
        int[] nums2 = {1,2,3,3,4};
        System.out.println(findRepeatNumberThird(nums2));
    }
}
