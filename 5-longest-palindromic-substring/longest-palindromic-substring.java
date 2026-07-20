class Solution {
    int start = 0;
    int maxLength = 0;
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        
        for(int i=0; i<s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return s.substring(start, start + maxLength);
    }
    private void expand(String s, int i, int j) {

        while(i >= 0 && j <= s.length()-1 && s.charAt(i) == s.charAt(j)) {
            if(j - i + 1 > maxLength) {
                maxLength = j - i + 1;
                start = i;
            }
            i--; j++;
        }
    }
}