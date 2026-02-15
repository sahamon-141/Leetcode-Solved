class Solution {
    public static int squaredDis(int[] point){
     return point[0]*point[0] + point[1]*point[1];   
    }
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                return squaredDis(p1) - squaredDis(p2);
            }
        });
        int[][] result = new int[k][];
        for(int i=0;i<k;i++){
            int[] temp = new int[2];
            temp[0] = points[i][0];
            temp[1] = points[i][1];
            result[i] = temp;
        }
        return result;
        
    }
}