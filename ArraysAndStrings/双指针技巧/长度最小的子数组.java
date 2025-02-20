package ArraysAndStrings.双指针技巧;

/*

长度最小的子数组
给定一个含有n个正整数的数组和一个正整数 target 。

找出该数组中满足其总和大于等于 target 的长度最小的 子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。



示例 1：

输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组[4,3]是该条件下的长度最小的子数组。
示例 2：

输入：target = 4, nums = [1,4,4]
输出：1
示例 3：

输入：target = 11, nums = [1,1,1,1,1,1,1,1]
输出：0


提示：

        1 <= target <= 109
        1 <= nums.length <= 105
        1 <= nums[i] <= 104


进阶：

如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。

作者：LeetCode
链接：https://leetcode.cn/leetbook/read/array-and-string/c0w4r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/


public class 长度最小的子数组 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int sum = 0;
            int minLength = 100001;
            int start = 0;
            int end = 0;
            for(int i = 0;i < nums.length;i ++) {
                sum += nums[i];
                end = i;
                while(sum >= target) {
                    if(end - start + 1 < minLength) {
                        minLength = end - start + 1;
                    }
                    sum -= nums[start];
                    start ++;
                }
            }
            while(start <= end) {
                if(sum < target) {
                    break;
                }
                if(sum >= target) {
                    if(end - start + 1 < minLength) {
                        minLength = end - start + 1;
                    }
                    sum -= nums[start];
                    start ++;
                }
            }
            if(minLength == 100001) {
                return 0;
            }
            return minLength;
        }
    }
}



/*

合并思想被验证了
例子
用实例去研究

题解以及一题多解后面重复做的时候再来研究

*/

