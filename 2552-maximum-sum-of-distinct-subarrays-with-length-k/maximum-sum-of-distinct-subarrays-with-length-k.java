class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left = 0;
        long max = Long.MIN_VALUE; long sum = 0;
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i])) {
                while(set.contains(nums[i])) {
                    set.remove(nums[left]);
                    sum -= nums[left];
                    left++;
                }
            }
            sum += nums[i];
            set.add(nums[i]);

            if(i - left + 1 == k) {
                max = Math.max(max, sum);
                sum = sum - nums[left];
                set.remove(nums[left]);
                left++;
            }
        }
        return max == Long.MIN_VALUE ? 0 : max;
    }
}