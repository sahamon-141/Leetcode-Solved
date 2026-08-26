class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int start = 0;
        int count = 0;
        String ans = "";

        for (int end = 0; end < s.length(); end++) {

            if (s.charAt(end) == '1') {
                count++;
            }

            while (count > k) {
                if (s.charAt(start) == '1') {
                    count--;
                }
                start++;
            }

            if (count == k) {

                // Remove unnecessary leading zeros
                while (s.charAt(start) == '0') {
                    start++;
                }

                String current = s.substring(start, end + 1);

                if (ans.equals("") ||
                    current.length() < ans.length() ||
                    (current.length() == ans.length() &&
                     current.compareTo(ans) < 0)) {
                    ans = current;
                }
            }
        }

        return ans;
    }
}