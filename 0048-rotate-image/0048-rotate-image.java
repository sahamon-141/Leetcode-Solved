class Solution {
    public static void swap(int a,int b){
        int temp = a;
        a = b;
        b = a;
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                    rotated[i][j]= matrix[j][i];
            }
        }
        for(int i=0;i<n;i++){
            int left = 0;
            int right = rotated[i].length-1;
            while(left<=right){
                int temp = rotated[i][left];
                rotated[i][left] = rotated[i][right];
                rotated[i][right] = temp;
                left++;
                right--;
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                    matrix[i][j]= rotated[i][j];
            }
        }

    }
}