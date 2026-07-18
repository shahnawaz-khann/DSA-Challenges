class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currMax = 1; int currMin = 1;

        for(int i=0; i<nums.length; i++) {

            if(nums[i] < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            currMax = Math.max(currMax * nums[i], nums[i]);
            currMin = Math.min(currMin * nums[i], nums[i]);

            max = Math.max(max, currMax);
        }
        return max;
    }
}   