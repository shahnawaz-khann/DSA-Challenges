class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int j = 0;
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0; i<nums.length; i++) {
            while(!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.addLast(i);
            if(q.peekFirst() < left) {
                q.pollFirst();
            }
            if(i - left + 1 == k) {
                ans[j++] = nums[q.peekFirst()];
                left++;
            }
        }
        return ans;
    }
}