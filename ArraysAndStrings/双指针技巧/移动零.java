package ArraysAndStrings.双指针技巧;


/*

移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意，必须在不复制数组的情况下原地对数组进行操作。



示例 1:

输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
示例 2:

输入: nums = [0]
输出: [0]


提示:

        1 <= nums.length <= 104
        -231<= nums[i] <= 231- 1


进阶：你能尽量减少完成的操作次数吗？

相关标签

        Java



作者：LeetCode
链接：https://leetcode.cn/leetbook/read/array-and-string/c6u02/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/



public class 移动零 {

    class Solution {
        public void moveZeroes(int[] nums) {
            int temp = 0;
            int j = 0;
            for(int i = nums.length - 1;i >= 0;i --) {
                if(nums[i] == 0) {
                    j = i;
                    while(j + 1 < nums.length && nums[j + 1] != 0) {
                        temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                        j ++;
                    }
                }
            }
        }
    }

}



/*


合思想

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array/solutions/728105/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-tudo/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



要定期回顾结果
做题不是目的，而是哪个解题体系梳理
体系才是，所以做之前要复习体系（要找好记录方法）


*/
