/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        addParent(root);
        BFS(target, k, res);
        return res;
    }
    private void addParent(TreeNode node) {
        if(node == null) {
            return;
        }
        if(node.left != null) parent.put(node.left, node);
        addParent(node.left);

        if(node.right != null) parent.put(node.right, node);
        addParent(node.right);
    }
    private void BFS(TreeNode target, int k, List<Integer> res) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        while(!q.isEmpty()) {
            int size = q.size();
            if(k == 0) {
                break;
            }
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();

                if(curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left) ;
                    visited.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                if(parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    q.add(parent.get(curr));
                    visited.add(parent.get(curr));
                }
            }
            k--;
        }
        while(!q.isEmpty()) {
            res.add(q.poll().val);
        }
    }
}