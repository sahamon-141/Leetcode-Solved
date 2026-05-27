class Solution {
    public int firstUniqChar(String s) {
        /*
        HashMap<Character, Stack<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                Stack<Integer> st = new Stack<>();
                st.push(i);
                map.put(c, st);
            } else {
                map.get(c).push(i);
            }
        }
        
        int firstIndex = Integer.MAX_VALUE;
        for (Stack<Integer> st : map.values()) {
            if (st.size() == 1) {
                firstIndex = Math.min(firstIndex, st.peek());
            }
        }
        
        return firstIndex == Integer.MAX_VALUE ? -1 : firstIndex;
        */
        int[] freq = new int[26];
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}