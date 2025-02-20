package ArraysAndStrings.旋转图像;

/*
旋转矩阵
给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。

不占用额外内存空间能否做到？



示例 1：

给定 matrix =
[
        [1,2,3],
        [4,5,6],
        [7,8,9]
        ],

原地旋转输入矩阵，使其变为:
        [
        [7,4,1],
        [8,5,2],
        [9,6,3]
        ]
示例 2：

给定 matrix =
[
        [ 5, 1, 9,11],
        [ 2, 4, 8,10],
        [13, 3, 6, 7],
        [15,14,12,16]
        ],

原地旋转输入矩阵，使其变为:
        [
        [15,13, 2, 5],
        [14, 3, 4, 1],
        [12, 6, 8, 9],
        [16, 7,10,11]
        ]

作者：LeetCode
链接：https://leetcode.cn/leetbook/read/array-and-string/clpgd/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/

public class 旋转矩阵 {
    class Solution {
        public void rotate(int[][] matrix) {
            int[][] temp = new int[matrix.length][matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    temp[j][matrix.length - i - 1] = matrix[i][j];
                }
            }
            for (int i = 0; i < matrix.length; i++) {

                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = temp[i][j];
                }
            }
        }
    }
}



/*
我直接另外开了一个数组用来存放旋转后的结果再把结果赋值给需要改变的二维数组
我想过原地旋转，但是却只是想着从外层到内层正方形上部分的的旋转（部分是分开的），这样不能找到方法遍历完全（或者说很麻烦）

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/rotate-image/solutions/526980/xuan-zhuan-tu-xiang-by-leetcode-solution-vu3m/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


分治法，从外向内，一圈一圈地旋转；时间复杂度O(n
2
)，空间复杂度O(1)

class Solution {
    public:
    void rotate(vector<vector<int>>& matrix) {
        rotateSub(matrix, 0);
    }

    void rotateSub(vector<vector<int>>& matrix, int m) {
        int n = matrix.size();
        if (m >= n / 2) return;
        // 旋转从外面开始数的第 m + 1 圈
        int q = n - 2 * m;
        int r, c, sr, sc;
        for (int i = 0; i < q - 1; ++i) {
            r = m + i, c = m;
            int tmp = matrix[r][c];
            for (int j = 0; j < 3; ++j) {
                sr = n - 1 - c;
                sc = r;
                matrix[r][c] = matrix[sr][sc];
                r = sr, c = sc;
            }
            matrix[r][c] = tmp;
        }
        rotateSub(matrix, m + 1);
    }
};
*/
