class Solution {
    int[][] grid; 
    int n;
    int m;

    public boolean closed(int i,int j){
        if(i>=n || i<0 || j>=m || j<0) return false;
        if(grid[i][j]==1) return true;
        grid[i][j] = 1;
        return closed(i+1,j) & closed(i-1,j) & closed(i,j+1) & closed(i,j-1);
    }
    public int closedIsland(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        int count = 0;
        for(int i=0; i<n ; i++){
            for(int j=0 ; j<m;j++){
                if(grid[i][j]==0 && closed(i,j)) count++;
            }
        }
        return count;

    }
}