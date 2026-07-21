/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int i;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = postorder.length - 1;
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, inorder.length - 1);
    }
    private TreeNode buildTree(int[] postorder, int left, int right) {
        if(left > right) return null;
        int rootval = postorder[i--];
        TreeNode root = new TreeNode(rootval);
        int mid = map.get(rootval);

        root.right = buildTree(postorder, mid+1, right);
        root.left = buildTree(postorder, left, mid - 1);

        return root;
    }
}