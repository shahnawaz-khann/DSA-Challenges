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
    int row;
    int hd;
    Pair(TreeNode node, int row, int hd) {
        this.node = node;
        this.row = row;
        this.hd = hd;
    }
}
class Solution {
    Map<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                Pair curr = q.poll();
                TreeNode node = curr.node;
                int row = curr.row;
                int hd = curr.hd;

                if(!map.containsKey(hd)) {
                    map.put(hd, new TreeMap<>());
                }
                TreeMap<Integer, List<Integer>> rowMap = map.get(hd);
                if(!rowMap.containsKey(row)) {
                    rowMap.put(row, new ArrayList<>());
                }
                rowMap.get(row).add(node.val);

                if(node.left != null) q.add(new Pair(node.left, row + 1, hd - 1));
                if(node.right != null) q.add(new Pair(node.right, row + 1, hd + 1));
            }
        }
        for(TreeMap<Integer, List<Integer>> rowMap : map.values()) {
            List<Integer> col = new ArrayList<>();
            for(List<Integer> list : rowMap.values()) {
                Collections.sort(list);
                col.addAll(list);
            }
            res.add(col);
        }
        return res;
    }
}