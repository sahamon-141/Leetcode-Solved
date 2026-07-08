class Solution {
    public static boolean isValid(int row,int col,int n){
        return row >= 0 && row < n && col >= 0 && col < n;
    }
    public boolean checkValidGrid(int[][] grid) {
        int[] x = {-1,1,2,2,-2,-2,1,-1};
        int[] y = {2,2,1,-1,1,-1,-2,-2};
        int currx = 0; int curry = 0;
        int index = 1;
        if(grid[0][0]!=0) return false;
        int n = grid.length;
        boolean valid = false;
        for(int i=0;i<n*n-1;i++){
            valid=false;
            for(int j=0;j<8;j++){
                int newx = currx+x[j];
                int newy = curry+y[j];
                if(isValid(newx,newy,n)){
                    if(grid[newx][newy]==index){
                        valid=true;
                        index++;
                        currx = newx;
                        curry = newy;
                        break;
                    }
                }
            }
            if(valid==false) return false;
        }
        return true;

    }
}