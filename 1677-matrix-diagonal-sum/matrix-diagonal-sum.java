class Solution {
    public int diagonalSum(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<row; i++) {
            sum1 = sum1 + mat[i][i];
            sum2 = sum2 + mat[i][row-i-1];
        }
        int sub = 0;
        if(row==col && row%2!=0) {
            sub = mat[row/2][col/2];
        }
        return sum1 + sum2 - sub;
    }
}