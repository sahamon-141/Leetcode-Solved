class Solution {
    
    public int trap(int[] height) {
        int max = Integer.MIN_VALUE;
        // leftmax
        int leftmax[] = new int[height.length];
        for(int i=0;i<height.length;i++){
            for(int j=i;j<=i;j++){
                if(max<height[j]){
                    max = height[i];
                }
            }
            leftmax[i] = max;
        }
        // rightmax
        max = Integer.MIN_VALUE;
        int rightmax[] = new int[height.length];
        for(int i=height.length-1;i>=0;i--){
            for(int j=i;j>=0;j--){
                if(max<height[i]){
                    max = height[i];
                }
            }
            rightmax[i]=max;
        }
        
        // calculation of total
        int WaterTrapped = 0;
        int Total=0;
        int waterlevel = 0;
        for(int i=0;i<height.length;i++){
            waterlevel = Math.min(leftmax[i],rightmax[i]); // This is the water level
            WaterTrapped = (waterlevel-height[i]); // this is the volume trapped for each level
            if(WaterTrapped<0){
                WaterTrapped=0;
            }
            Total += WaterTrapped;
        }
        return Total;  
    }
}