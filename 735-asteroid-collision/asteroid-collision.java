class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            int curr = asteroids[i];
            boolean destroyed = false;
            while(!stack.isEmpty() && stack.peek() > 0 && curr < 0) {
                int sum = curr + stack.peek();

                if(sum < 0) {
                    stack.pop();
                }
                else if(sum > 0) {
                    destroyed = true;
                    break;
                }
                else {  //sum == 0
                    stack.pop();
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed) {
                stack.push(curr);
            }
        }
        int[] ans = new int[stack.size()];

        for(int i = stack.size()-1; i>=0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}