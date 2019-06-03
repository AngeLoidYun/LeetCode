/**
 * 2019年5月30日 15:15:04通过，简单题。
 * 思路是找到第一行以及第一列所有元素（共m+n-1个）然后依次向右下角遍历即可
 */


public class No_766_eazy {


    public boolean isToeplitzMatrix(int[][] matrix) {
        int line = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < column; i++) {
            int p = 0;
            int q = i;
            int temp = matrix[p][q];
            for (; p < line && q < column; p++, q++) {
                if (matrix[p][q] != temp) {
                    return false;
                }
            }
        }
        for (int i = 1; i < line; i++) {
            int p = i;
            int q = 0;
            int temp = matrix[p][q];
            for (; p < line && q < column; p++, q++) {
                if (matrix[p][q] != temp) {
                    return false;
                }
            }
        }
        return true;
    }

}
