class Solution {
    int start = 0;
    int max = 0;
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return s.substring(start, start+max);
    }
    private void expand(String s, int i, int j) {
        while(i>=0 && j<=s.length()-1 && s.charAt(i) == s.charAt(j)) {
            if(j-i+1 > max) {
                max = j-i+1;
                start = i;
            }
            i--; j++;
        }
    }
}