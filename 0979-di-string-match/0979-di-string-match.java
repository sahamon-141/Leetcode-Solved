class Solution {
    public int[] diStringMatch(String s) {
        int low = 0;
        int n = s.length();
        int high = n;
        int[] result = new int[n+1];
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c=='I'){
                result[i] = low;
                low++;
            }
            else{
                result[i] = high;
                high--;
            }
            
        }
        if(s.charAt(s.length()-1)=='D'){result[s.length()] = low;}
        else{
            result[s.length()] = high;
        }
        return result;

    }
}