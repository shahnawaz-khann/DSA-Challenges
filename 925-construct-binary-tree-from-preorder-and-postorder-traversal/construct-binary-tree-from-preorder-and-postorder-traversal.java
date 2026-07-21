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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i=0; i<postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return buildTree(preorder, 0, postorder.length - 1);
    }
    private TreeNode buildTree(int[] preorder, int left, int right) {
        if(left > right) return null;
        TreeNode root = new TreeNode(preorder[i++]);
        if(left == right) {
            return root;
        }
        int leftroot = preorder[i];
        int mid = map.get(leftroot);

        
        root.left = buildTree(preorder, left, mid);
        root.right = buildTree(preorder, mid + 1, right - 1);

        return root;
    }
}