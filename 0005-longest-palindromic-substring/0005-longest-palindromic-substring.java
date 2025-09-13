import java.util.*;
class Solution {
    public static boolean isPalindrome(String s){
        int n = s.length();
        int l =0;
        int r = n-1;
        while (l<=r) {
            char a = s.charAt(l);
            char b = s.charAt(r);
            if(a!=b){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;
        
        String longest = "";
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = s.substring(i, j + 1);
                if (isPalindrome(substring) && substring.length() > longest.length()) {
                    longest = substring;
                }
            }
        }
        
        return longest;
    }
}