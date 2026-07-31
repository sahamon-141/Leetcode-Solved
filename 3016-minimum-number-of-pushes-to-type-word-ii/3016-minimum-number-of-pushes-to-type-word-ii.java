class Solution {
    public int minimumPushes(String word) {
        // Step 1: Count frequencies of each character
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Step 2: Sort frequencies in ascending order
        Arrays.sort(freq);
        
        int totalPushes = 0;
        int distinctCount = 0;
        
        // Step 3: Iterate backwards from the highest frequency
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break; // No more characters left
            
            // Map 8 characters per level
            int level = (distinctCount / 8) + 1;
            totalPushes += freq[i] * level;
            distinctCount++;
        }
        
        return totalPushes;
    }
}