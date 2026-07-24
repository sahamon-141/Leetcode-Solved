class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            int currentDiff = arr[i + 1] - arr[i]; // No Math.abs needed since it is sorted
            
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                result.clear(); // Found a smaller difference, discard previous pairs
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (currentDiff == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i + 1])); // Matches current minimum
            }
        }
        return result;
    }
}