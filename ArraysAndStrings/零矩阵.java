package ArraysAndStrings;

public class 零矩阵 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            int[][] book = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        book[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (book[i][j] == 1) {
                        int x = i, y = j;
                        //下
                        while (x < matrix.length) {
                            matrix[x][y] = 0;
                            x++;
                        }
                        //上
                        x = i;
                        y = j;
                        while (x >= 0) {
                            matrix[x][y] = 0;
                            x--;
                        }
                        //左
                        x = i;
                        y = j;
                        while (y >= 0) {
                            matrix[x][y] = 0;
                            y--;
                        }
                        //右
                        x = i;
                        y = j;
                        while (y < matrix[0].length) {
                            matrix[x][y] = 0;
                            y++;
                        }
                    }
                }
            }
        }
    }
}



/*

更优化的方法是利用矩阵的第一行和第一列作为标记，从而避免使用额外的空间并减少不必要的遍历
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/zero-matrix-lcci/solutions/742402/ling-ju-zhen-by-leetcode-solution-7ogg/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
