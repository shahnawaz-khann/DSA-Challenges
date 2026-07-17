class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k==0) {
            return new int[]{};
        }
        if(nums.length==1) {
            return nums;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );
        int[] ans = new int[nums.length - k + 1];
        int left = 0;

        int j = 0;
        
        for(int i=0; i<nums.length; i++) {
            pq.add(new int[]{nums[i], i});

            if(i-left+1 > k) {
                left++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < left) {
                pq.poll();
            }
            
            if(i - left + 1 == k) {
                ans[j++] = pq.peek()[0];
            }
        }
        return ans;
    }
}