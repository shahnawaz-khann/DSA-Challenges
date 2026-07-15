class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] right = new int[n];

        int maxRight = height[n-1];
        for(int i=n-1; i>=0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            right[i] = maxRight;
        }

        int ans = 0;

        int maxleft = height[0];

        for(int i=0; i<n; i++) {
            maxleft = Math.max(maxleft, height[i]);
            int min = Math.min(maxleft, right[i]);
            ans = ans + (min - height[i]);
        }
        return ans;
    } 
}