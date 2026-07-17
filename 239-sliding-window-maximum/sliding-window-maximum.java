class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();

        int left = 0;
        int j = 0;
        int[] ans = new int[nums.length - k + 1];

        for(int i=0; i<nums.length; i++) {
    
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.addLast(i);

            if(i - left + 1 > k) {
                left++;
            }
            if(!q.isEmpty() && q.peekFirst() < left) {
                q.pollFirst();
            }

            if(i-left+1 == k) {
                ans[j++] = nums[q.peekFirst()];
            }
        }
        return ans;
    }
}