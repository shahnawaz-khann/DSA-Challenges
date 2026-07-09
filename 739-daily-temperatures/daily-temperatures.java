class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int[] res = new int[n];

        for(int i = n-1; i>=0; i--) {
            int curr = temperatures[i];
             
            while(!stack.isEmpty() && curr >= temperatures[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}