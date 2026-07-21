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

 class Pair {
    TreeNode node;
    int index;

    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
class Solution {
    int start;
    int end;
    int ans;
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                Pair curr = q.poll();
                TreeNode node = curr.node;
                int ind = curr.index;

                if(i == 0) {
                    start = ind;
                }
                if(i == size - 1) {
                    end = ind;
                }

                if(node.left != null) q.add(new Pair(node.left, 2 * ind + 1));
                if(node.right != null) q.add(new Pair(node.right, 2 * ind + 2));
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}