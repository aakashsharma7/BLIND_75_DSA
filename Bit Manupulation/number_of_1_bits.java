class Solution {
    public int hammingWeight(int n) {
        int count = 0; // Initialize count of '1' bits
        while (n != 0) {
            count += n & 1; // Add the least significant bit to the count
            n >>>= 1; // Unsigned right shift by 1 to process the next bit
        }
        return count; // Return the total count of '1' bits
    }
}
