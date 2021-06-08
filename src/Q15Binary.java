/**
 * @author liudongjin
 * @date 2021/6/8 07:38
 * @description 二进制中1的个数，P100
 */
public class Q15Binary {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((flag & n) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    // n & (n - 1) 把n最右边的1变成0
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Q15Binary q15Binary = new Q15Binary();
        System.out.println(q15Binary.hammingWeight2(3));
        System.out.println(q15Binary.hammingWeight2(00000000000000000000000000001011));
    }
}
