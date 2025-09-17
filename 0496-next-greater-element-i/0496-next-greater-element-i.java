class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i] = -1;
        }

        for(int i=0;i<nums1.length;i++){
            int k=0;
            while(nums1[i]!=nums2[k]){
                k++;
            }
            for(int j=k;j<nums2.length;j++){
                if(nums1[i]<nums2[j]){
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}