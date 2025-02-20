package ArraysAndStrings.双指针技巧;

/*

最大连续1的个数
给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。



示例 1：

输入：nums = [1,1,0,1,1,1]
输出：3
解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
示例 2:

输入：nums = [1,0,1,1,0,1]
输出：2


提示：

        1 <= nums.length <= 105
nums[i]不是0就是1.
相关标签

        Java



作者：LeetCode
链接：https://leetcode.cn/leetbook/read/array-and-string/cd71t/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/

public class 最大连续1的个数 {

}



/*


不是非得用双指针
时间 15：34 —— 17：36（才做了两道题目）
我还是没办法凭借着一些思想解决一切问题
也没办法一看到题目就灵活得得到一些思想，都是事后总结
不是做研究，无法像格那样去研究，也许天才的方法是物质的，但是有其它的条件使得他们就像是美丽的自然风光一样，浑然天成

这样看来我还不如像学长说的那样子，缩短思考的时间，加大对题目量的研究     ***



//换成nums[i - 1] == 0其实也应该可以但是没有必要，以后可用时间限制来规避掉
package leetcode;

public class 最大连续1的个数1 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int temp = -1;
        int maxGap = 0;
        int i;
        int times = 0;
        for(i = 0;i < nums.length;i ++) {
            if(nums[i] == 0 && temp == -1 && times == 0) {
                maxGap = i;
                times ++;
                temp = i;
            } else if(nums[i] == 0 && times != 0 && maxGap < i - temp - 1) {
                maxGap = i - temp - 1;
                temp = i;
            }
        }
        if(temp != -1 && temp < nums.length && nums.length - 1 - temp > maxGap) {
            maxGap = nums.length - 1 - temp;
        }
        return maxGap;
    }

    public static void main(String[] args) {
        最大连续1的个数 a = new 最大连续1的个数();
        int[] nums = {1,0,1,1,0,1};
        System.out.println("Max Gap = " + a.findMaxConsecutiveOnes(nums));
    }

}


*/
