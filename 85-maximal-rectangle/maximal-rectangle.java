class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] pref = new int[m][n];

        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j = 0; j<m; j++) {
                if(matrix[j][i] == '1') {
                    sum++;
                }
                else {
                    sum = 0;
                }
                pref[j][i] = sum;
            }
        }

        int maxArea = 0;
        for(int[] heights : pref) {
            maxArea = Math.max(maxArea, largestRectangleInHistogram(heights));
        }
        return maxArea;
    }
    private int largestRectangleInHistogram(int[] heights) {
        int n = heights.length;
        int area = 0;

        Stack<Integer> stack = new Stack<>();

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