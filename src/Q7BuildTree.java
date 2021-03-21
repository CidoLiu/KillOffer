/**
 * @author liudongjin
 * @date 2021/3/18 23:55
 */
public class Q7BuildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }
        int len = preorder.length;
        return buildTree(preorder, 0, len - 1, inorder, 0, len - 1);
    }

    public TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                              int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int split = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == preorder[preLeft]) {
                split = i;
            }
        }
        int leftLength = split - inLeft;
        root.left = buildTree(preorder, preLeft + 1, preLeft + leftLength, inorder, inLeft, split - 1);
        root.right = buildTree(preorder, preLeft + leftLength + 1, preRight, inorder, split + 1, inRight);
        return root;
    }
}
