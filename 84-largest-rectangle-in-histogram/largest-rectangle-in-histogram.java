class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int[] prev = new int[n];
        int[] next = new int[n];
        
        for(int i=0; i<n; i++) {
            int curr = heights[i];

            while(!stack1.isEmpty() && curr <= heights[stack1.peek()]) {  //previous smalller //left->right
                stack1.pop();
            }
            prev[i] = stack1.isEmpty() ? -1 : stack1.peek();
            stack1.push(i);
        }

        for(int i=n-1; i>=0; i--) {
            int curr = heights[i];

            while(!stack2.isEmpty() && curr <= heights[stack2.peek()]) {  //next smaller  //right->left
                stack2.pop();
            }
            next[i] = stack2.isEmpty() ? n : stack2.peek();
            stack2.push(i);
        }

        int area = 0;
        for(int i=0; i<n; i++) {
            area = Math.max(area, (next[i]-prev[i]-1) * heights[i]);
        }
        return area;
    }
}