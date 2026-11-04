class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int one = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                one++;
            }
            else {
                one = 0;
            }
            max = Math.max(max, one);
        }
        return max;
    }
}