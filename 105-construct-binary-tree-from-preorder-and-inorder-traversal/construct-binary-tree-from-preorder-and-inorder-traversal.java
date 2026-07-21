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
    int i = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length - 1);
    }
    private TreeNode buildTree(int[] preorder, int left, int right) {
        if(left > right) {
            return null;
        }
        int rootval = preorder[i++];
        int mid = map.get(rootval);

        TreeNode root = new TreeNode(rootval);
        
        root.left = buildTree(preorder, left, mid - 1);
        root.right = buildTree(preorder, mid+1, right);

        return root;
    }
}