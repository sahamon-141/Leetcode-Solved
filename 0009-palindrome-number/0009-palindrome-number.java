class Solution {
    public boolean isPalindrome(int x) {
        int rem = 0;
        int palindrome = 0;
        int original = x;
        while(x>0){
            rem = x%10;
            palindrome = palindrome*10 + rem;
            x = x/10;
        }
        if(original==palindrome){
            return true;
        }
        return false;
    }
}