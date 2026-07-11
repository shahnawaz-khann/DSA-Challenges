class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        int curr = price;

        while(!stack.isEmpty() && curr >= stack.peek()[0]) {
            span = span + stack.pop()[1];
        }
        stack.push(new int[]{curr, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */