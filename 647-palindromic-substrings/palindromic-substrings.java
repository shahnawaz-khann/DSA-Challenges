class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j, dp) == 1) {
                    count++;
                }
            }
        }
        return count;

    }
    private int isPalindrome(String s, int i, int j, int[][] dp) {
        if(i >= j) {
            return 1;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)) {
            dp[i][j] = isPalindrome(s, i+1, j-1, dp);
            return dp[i][j];
        }
        return dp[i][j] = 0;
    }
}