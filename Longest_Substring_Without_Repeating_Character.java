package Blind_75_DSA.String;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Character {
    public int lengthOfLongestSubstring(String s){
        int left =  0, right = 0;
        Set<Character> seen = new HashSet();
        int max = 0;

        while(right < s.length()){
            char c = s.charAt(right);
            if(seen.add(c)){
                max = Math.max(max,right-left+1);
                right++;
            }else{
                while(s.charAt(left)!=c){
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.remove(c);
                left++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Character solution = new Longest_Substring_Without_Repeating_Character();
        String testString  = "abcabcbb";
        int longestlength = solution.lengthOfLongestSubstring(testString);
        System.out.println(longestlength);
    }
}
