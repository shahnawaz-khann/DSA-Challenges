class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n]; 

        for(int i=n-1; i>=0; i--) {
            stack.push(nums[i]);
        }

        for(int i = n-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            arr[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return arr;
    }
}