class Solution {
    static void swap(int x,int y){
        int temp = x;
        x = y;
        y=temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(nums[i]<nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}