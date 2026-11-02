class Solution {
    public void moveZeroes(int[] nums) {
        int zero = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                zero++;
            }
        }
        int k = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        while(zero-- > 0) {
            nums[k++] = 0;
        }
    }
}