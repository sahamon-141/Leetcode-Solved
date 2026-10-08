class Solution {
    public static boolean isSafe(int[][] mat,int i, int j, int n,int m){
        if(i>=0 && i<n && j>=0 && j<m){
            return true;
        }
        return false;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0;i<n;i++){
            
            for(int j=0;j<m;j++){
                boolean flag = true;
                for(int[] dir:directions){
                    int nx = i+dir[0];
                    int ny = j+dir[1];

                    if(isSafe(mat,nx,ny,n,m) && mat[nx][ny]>mat[i][j]){
                        flag = false;
                    }
                }
                if(flag) return new int[] {i,j};
            }
        }

        return new int[]{-1,-1};
    }
}