class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int max = 0;
        int depth = 0;
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c=='(') depth++;
            if(c==')') depth--;
            max = Math.max(depth,max);
        }
        return max;
    }
}