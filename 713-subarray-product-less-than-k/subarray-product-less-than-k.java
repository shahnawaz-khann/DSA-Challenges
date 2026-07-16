class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int prod = 1;

        int left = 0;

        for(int i=0; i<nums.length; i++) {
            prod = prod * nums[i];

            while(prod >= k) {
                prod = prod / nums[left];
                left++;
            }
            count = count + (i - left + 1);
        }
        return count;
    }
}