class Solution {
    public int characterReplacement(String s, int k) {
        int lo = 0;
        int[] arr = new int[26];
        int max_count = 0;
        int max_length = 0;

        for(int hi = 0; hi<s.length(); hi++){
            arr[s.charAt(hi)-'A']++;
            int freq = arr[s.charAt(hi)-'A'];
            max_count = Math.max(max_count,freq);
            
            while(hi- lo + 1 - max_count > k){
                arr[s.charAt(lo)-'A']--;
                lo++;
            }
            max_length = Math.max(max_length,hi-lo+1);
        }
        return max_length;
    }
}
