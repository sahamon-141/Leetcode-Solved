class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(nums, 0, current, result);
        return result;
    }
    
    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // Add the current subset to result
        result.add(new ArrayList<>(current));
        
        // Generate subsets by including each element starting from index
        for (int i = index; i < nums.length; i++) {
            // Include nums[i] in subset
            current.add(nums[i]);
            
            // Recur for next index
            backtrack(nums, i + 1, current, result);
            
            // Backtrack - remove last element
            current.remove(current.size() - 1);
        }
    }
}