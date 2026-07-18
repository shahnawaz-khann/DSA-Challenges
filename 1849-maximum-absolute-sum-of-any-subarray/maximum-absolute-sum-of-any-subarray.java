class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = nums[0]; int min = nums[0];
        int currMax = 0; int currMin = 0;
        
        for(int i=0; i<nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            max = Math.max(max, currMax);

            currMin = Math.min(currMin + nums[i], nums[i]);
            min = Math.min(min, currMin);
        }
        return Math.max(max, Math.abs(min));
    }
}