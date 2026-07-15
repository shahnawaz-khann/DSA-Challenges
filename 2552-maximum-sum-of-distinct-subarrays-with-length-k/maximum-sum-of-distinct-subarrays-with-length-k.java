class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0; long max = 0;
        int left = 0;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {

            while(set.contains(nums[i])) {
                set.remove(nums[left]);
                sum = sum - nums[left];
                left++;
            }
            set.add(nums[i]);
            sum = sum + nums[i];

            if(i - left + 1 == k) {
                max = Math.max(max, sum);
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
        }
        return max;
    }
}