class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left_small = new int[n];
        int[] right_small = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty()&& heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()) right_small[i]=n;
            else right_small[i] = s.peek();
            s.push(i);
         }
         s.clear();
         for(int i=0;i<n;i++){
            while(!s.isEmpty()&& heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()) left_small[i]=-1;
            else left_small[i] = s.peek();
            s.push(i);
         }
            int max = Integer.MIN_VALUE;
         for(int i=0;i<n;i++){
            int width = right_small[i]-left_small[i]-1;
            int area = width*heights[i];
            max = Math.max(area,max);
         }
         return max;

    }
}