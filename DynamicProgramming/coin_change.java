class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        // Base case: to make amount 0, 0 coins are needed
        dp[0] = 0;
        
        // Fill the dp array
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still amount + 1, it means it's not possible to form that amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
