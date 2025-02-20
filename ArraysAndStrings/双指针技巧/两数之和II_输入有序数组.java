package ArraysAndStrings.双指针技巧;

import java.util.Arrays;

/*

两数之和 II - 输入有序数组
给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。

以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。

你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。

你所设计的解决方案必须只使用常量级的额外空间。


示例 1：

输入：numbers = [2,7,11,15], target = 9
输出：[1,2]
解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
示例 2：

输入：numbers = [2,3,4], target = 6
输出：[1,3]
解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
示例 3：

输入：numbers = [-1,0], target = -1
输出：[1,2]
解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。


提示：

        2 <= numbers.length <= 3 * 104
        -1000 <= numbers[i] <= 1000
numbers 按 非递减顺序 排列
-1000 <= target <= 1000
仅存在一个有效答案
        相关标签

Java



作者：LeetCode
链接：https://leetcode.cn/leetbook/read/array-and-string/cnkjg/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/



public class 两数之和II_输入有序数组 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            Arrays.sort(numbers);
            int left = 0;
            int right = numbers.length - 1;
            int[] ans = new int[2];
            int sum = 0;
            while(left < right) {
                sum = numbers[left] + numbers[right];
                if(sum == target) {
                    ans[0] = left + 1;
                    ans[1] = right + 1;
                    break;
                } else if(sum > target) {
                    right --;
                } else if(sum < target) {
                    left ++;
                }
            }
            return ans;
        }
    }
}




/*

和I一样

序思想已经证明了自己的有效性
各个题目都用到了
但是我们并不知道序思想背后的东西，这是我在布尔巴基学派那里看来的
也许以后有机会去研究，但是绝对不是现在


序思想并不能证明这样做的正确性
我一开始想到的是这样两边开始删除，然后考虑各个情况——这样做之后出现这样或者那样的情况怎么班
但是这种错杂复杂的情况是难以确定的，基本上可以肯定就是这样的
我后来从单首尾的视角来看——其实就是删去不可以的，删去后又是相同的情形
先排序，放在两端，大了就是最大的不行，因为最大的和最小的一起都大了，和别的就更不行了
先排序，放在两端，小了就是最小的不行，因为最小的和最大的一起都大了，和别的就更不行了
就是换个角度

至于这个视角是不是就是使得问题简单化的那些部分的其他视角那就不得而知了

*/
