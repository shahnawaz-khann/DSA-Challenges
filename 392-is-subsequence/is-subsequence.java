class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0; 
        int k = 0;

        while(i < t.length() && k<s.length()) {
            if(t.charAt(i) == s.charAt(k)) {
                k++;
            }
            i++;
        }
        return k == s.length();
    }
}