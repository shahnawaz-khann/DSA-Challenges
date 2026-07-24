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
    int count = 0;
    Map<Long, Integer> map = new HashMap<>();
    long currSum = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        map.put(0L, 1);
        dfs(root, targetSum);
        return count;
    }
    private void dfs(TreeNode root, int targetSum) {
        if(root == null) return;
        currSum += root.val;
        if(map.containsKey(currSum - targetSum)) count += map.get(currSum - targetSum);

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

        map.put(currSum, map.get(currSum) - 1);
        if(map.get(currSum) == 0) map.remove(currSum); 

        currSum -= root.val;
    }
}