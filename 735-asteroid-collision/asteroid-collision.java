class Solution {
    public int[] asteroidCollision(int[] nums) {    //asteroids = nums

        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && stack.peek()>0 && nums[i]<0 && Math.abs(nums[i]) > stack.peek()) {
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek()>0 && nums[i]<0 && Math.abs(nums[i]) == stack.peek()) {
                stack.pop();
                continue;
            }
            if(!stack.isEmpty() && stack.peek()>0 && nums[i]<0 && Math.abs(nums[i]) < stack.peek()) {
                continue;
            }
            stack.push(nums[i]);
        }

        int[] ans = new int[stack.size()];
        for(int i = stack.size()-1; i>=0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}