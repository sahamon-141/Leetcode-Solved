class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // Base case for sums matching k exactly
        
        int currSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currSum += num;
            
            if (prefixMap.containsKey(currSum - k)) {
                count += prefixMap.get(currSum - k);
            }
            
            prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);
        }
        
        return count;
    }
}