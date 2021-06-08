/**
 * @author liudongjin
 * @date 2021/3/18 23:41
 * @description 从尾到头打印链表，P58
 */
public class Q6ReversePrint {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        int[] ans = new int[len];
        p = head;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] = p.val;
            p = p.next;
        }
        return ans;
    }
}
