class Solution {
    public int maxArea(int[] height) {
        /*
        int maxwater = Integer.MIN_VALUE;
        int water=0;
        for(int i=0;i<height.length;i++){
            for(int j=i;j<height.length;j++){
                water = Math.min(height[i],height[j]) * (j-i);
                if(water>maxwater){maxwater = water;}
            }
        }
        return maxwater;
        */
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;
            maxArea = Math.max(maxArea, currentArea);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;

    }
}