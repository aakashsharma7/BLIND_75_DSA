class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
         int m = text1.length();
        int n = text2.length();
        
        // Create a 2D array to store the lengths of longest common subsequences
        int[][] dp = new int[m + 1][n + 1];
        
        // Iterate through each character in text1 and text2
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // If the characters match, the LCS length at this point
                    // is the LCS length of the previous characters plus one
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If the characters do not match, the LCS length at this point
                    // is the maximum of the LCS lengths considering either character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // The length of the longest common subsequence is in dp[m][n]
        return dp[m][n];
    }
}
