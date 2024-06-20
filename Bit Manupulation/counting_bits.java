class Solution {
    public int[] countBits(int n) {
         int[] result = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // result[i] is the number of 1's in the binary representation of i
            // which is result[i >> 1] + (i & 1)
            result[i] = result[i >> 1] + (i & 1);
        }
        
        return result;
    }
}
