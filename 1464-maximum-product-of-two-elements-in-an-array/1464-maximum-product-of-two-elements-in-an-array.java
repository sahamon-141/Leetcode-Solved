class Solution {
    public int maxProduct(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(first<=nums[i]){
                second = first;
                first = nums[i];
            }
            else if(second<=nums[i]){
                second = nums[i];
            }
            
        }
        
        return (first-1)*(second-1);
    }
}