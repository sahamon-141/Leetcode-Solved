import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If character is already seen, move left pointer
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            // Update latest index of character
            map.put(c, right);

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}