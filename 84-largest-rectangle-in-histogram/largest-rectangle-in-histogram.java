class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] prev = new int[n];
        int[] next = new int[n];
        
        for(int i=0; i<n; i++) {
            int curr = heights[i];

            while(!stack.isEmpty() && curr <= heights[stack.peek()]) {  //previous smalller //left->right
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            stack.pop();
        }
        
        for(int i=n-1; i>=0; i--) {
            int curr = heights[i];

            while(!stack.isEmpty() && curr <= heights[stack.peek()]) {  //next smaller  //right->left
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int area = 0;
        for(int i=0; i<n; i++) {
            area = Math.max(area, (next[i]-prev[i]-1) * heights[i]);
        }
        return area;
    }
}