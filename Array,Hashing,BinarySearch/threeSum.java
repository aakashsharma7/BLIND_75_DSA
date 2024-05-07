import java.util.*;
import java.util.List;
import java.util.ArrayList;
// import java.util.getHash;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);  //nlogn
        
        HashSet<Long> set = new HashSet<>();
        int tar = 0;
        for(int i = 0; i < nums.length; i++){
            int ntar = tar - nums[i];

            int li = i + 1;
            int ri = nums.length - 1;
            while(li < ri){
                if(nums[li] + nums[ri] < ntar){
                    li++;
                   } else if(nums[li] + nums[ri] > ntar){
                        ri--;
                        }else{
                            long hash = getHash(nums[i], nums[li], nums[ri]);
                            if(set.contains(hash) == false){
                                ans.add(Arrays.asList(nums[i], nums[li], nums[ri]));
                                set.add(hash);
                            }
                            li++;
                            ri--;
                        }
                    }
                }
                return ans;
}

private long getHash(int x, int y, int z){
    long hash = x;

    hash *= 100000;
    hash += y;
    hash *= 100000;
    hash += z;
    return hash;
   }
}
 public class main {
    public static void main(String[] args) {
        threeSum ts = new threeSum();
        
        // Example usage:
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = ts.threeSum(nums);
        
        // Print the result
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
