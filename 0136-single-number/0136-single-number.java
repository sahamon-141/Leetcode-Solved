class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        
        return -1;
    }
}