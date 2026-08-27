class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtracking(s, 0, curr, res);
        return res;
    }
    private void backtracking(String s, int start, List<String> curr, List<List<String>> res) {
        if(start == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i<s.length(); i++) {
            if(isPalindrome(s, start, i)) {
                curr.add(s.substring(start, i+1));
                backtracking(s, i+1, curr, res);
                curr.remove(curr.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}