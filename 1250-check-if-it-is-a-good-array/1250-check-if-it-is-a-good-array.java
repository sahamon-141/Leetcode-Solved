class Solution {
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public boolean isGoodArray(int[] nums) {
        int gcdSoFar = 0;
        for(int x:nums){
            gcdSoFar = gcd(gcdSoFar,x);
            if(gcdSoFar==1) return true; 
        }
        return false;
    }
}