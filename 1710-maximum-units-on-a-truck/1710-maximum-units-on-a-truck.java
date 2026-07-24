class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int capacity = truckSize;
        int output = 0;
        for(int i=0;i<boxTypes.length;i++){
            if(capacity>=boxTypes[i][0]){
                output+= boxTypes[i][0]*boxTypes[i][1];
                capacity-=boxTypes[i][0];
            }
            else{
                output+= boxTypes[i][1]*capacity;
                capacity = 0;
            }
        }
        return output;
    }
}