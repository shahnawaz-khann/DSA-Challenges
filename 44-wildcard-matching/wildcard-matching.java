class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return wm(s, p, 0, 0, dp);
    }
    private boolean wm(String s, String p, int i, int j, Boolean[][] dp) {
        if(i == s.length() && j == p.length()) {
            return true;
        }
        if(i == s.length()) {
            for(int index = j; index < p.length(); index++) {
                if(p.charAt(index) != '*') {
                    return false;
                }
            }
            return true;
        }
        if(j == p.length() && i != s.length()) {
            return false;
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        if(p.charAt(j) == '?') {
            return dp[i][j] = wm(s, p, i+1, j+1, dp);
        }
        else if(p.charAt(j) == '*') {
            return dp[i][j] = wm(s, p, i, j+1, dp) || wm(s, p, i+1, j, dp);
        }
        else {
            return dp[i][j] = s.charAt(i) == p.charAt(j) && wm(s, p, i+1, j+1, dp);
        }
    }
}