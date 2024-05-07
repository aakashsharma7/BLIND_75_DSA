class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        //first Approach 

        // for(int i = 0; i < nums.length; i++){
        //     for(int j = i + 1; j < nums.length; i++){
        //         if(nums[i] == nums[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;

        //Second Approach
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
