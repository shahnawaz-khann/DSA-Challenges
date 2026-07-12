class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int area = 0;

        for(int i=0; i<=n; i++) {
            int curr = (i == n) ? 0 : heights[i];

            while(!stack.isEmpty() && curr < heights[stack.peek()]) {
                int height = heights[stack.pop()];

                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                int width = i - left - 1;
                area = Math.max(area, height * width);
            }
            stack.push(i);
        }
        return area;
    }
}