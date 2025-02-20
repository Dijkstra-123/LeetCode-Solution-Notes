package ArraysAndStrings.双指针技巧;


/*

移除元素
给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素。元素的顺序可能发生改变。然后返回nums中与val不同的元素的数量。

假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：

更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
返回 k。
用户评测：

评测机将使用以下代码测试您的解决方案：

int[] nums = [...]; // 输入数组
int val = ...; // 要移除的值
int[] expectedNums = [...]; // 长度正确的预期答案。
// 它以不等于 val 的值排序。

int k = removeElement(nums, val); // 调用你的实现

assert k == expectedNums.length;
sort(nums, 0, k); // 排序 nums 的前 k 个元素
for (int i = 0; i < actualLength; i++) {
        assert nums[i] == expectedNums[i];
        }
如果所有的断言都通过，你的解决方案将会 通过。



示例 1：

输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2,_,_]
解释：你的函数函数应该返回 k = 2, 并且 nums 中的前两个元素均为 2。
你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
示例 2：

输入：nums = [0,1,2,2,3,0,4,2], val = 2
输出：5, nums = [0,1,4,0,3,_,_,_]
解释：你的函数应该返回 k = 5，并且 nums 中的前五个元素为 0,0,1,3,4。
注意这五个元素可以任意顺序返回。
你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。


提示：

        0 <= nums.length <= 100
        0 <= nums[i] <= 50
        0 <= val <= 100
相关标签

        Java



作者：LeetCode
链接：https://leetcode.cn/leetbook/read/array-and-string/cwuyj/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/


public class 移除元素 {
    public class 除元素 {

        public int removeElement(int[] nums, int val) {
            int left = 0;
            int right = nums.length - 1;
            int num = nums.length;
            while (left <= right) {
                while (left <= right && nums[left] != val) {
                    left++;
                }
                while (left <= right && nums[right] != val) {
                    right--;
                }
                if (left <= right) {
                    if (right + 1 < nums.length) {
                        right = right + 1;
                    }
                    nums[left] = nums[right];
                    nums[right] = -1;
                    num--;
                } else {
                    break;
                }
            }
            //nums = ans;
            return num;
        }
    }
}



/*

package leetcode;

import java.util.Arrays;

public class 移除元素 {

    public int removeElement(int[] nums,int val) {
        int left = 0;
        int right = nums.length - 1;
        int num = nums.length;
        while(left <= right) {
            while(left <= right && nums[left] != val) {
                left ++;
            }
            while(left <= right && nums[right] != val) {
                right --;
            }
            if(left <= right) {
                if(right + 1 < nums.length) {
                    right = right + 1;
                }
                nums[left] = nums[right];
                nums[right] = -1;
                num --;
            } else {
                break;
            }
        }
        //nums = ans;
        return num;
    }


    public static void main(String[] args) {
        移除元素 a = new 移除元素();
        int[] nums = {3,2,2,3};
        int val = a.removeElement(nums, 3);
        System.out.println("removeElement = " + val);
        System.out.println("nums[] = " + Arrays.toString(nums));
    }
}


这是我在eclipse里面写的
我受到了定势思维（还是left和right一个在最左边一个在最右边，但是其实我想到了直接补足的情况）的影响而成
我还是想把左边直接移动到右边去（这样看来还有个思想就是——把要处理的一起来，即找即移，不要另外分情况，找到了就马上补上去而不是分情况的整体移动）


这个思想可以这么看：
合并处理思想（试图去找关系去连结）
1遍历——特殊情况（遇到val）——特殊操作
2正常——继续遍历
合二为一：查找中直接左边动，但是不改变数值，把静态的遇到val当作特殊（把遍历的for和移动的for合二为一）


看来我没有领悟万能法则
正如我之前所想到的那样，我其实还是在做题，去领会思路，是在试图弄懂方法背后的东西，不可能第一次就做出来题目（无法马上分析，这种思想本质上还是做题的）
这次幸好我没有纠结，我及时去看答案才发现答案和我所想的出入较大

技巧就是双指针，但是若是不总结思想下次估计也还是会走入思维定势的陷阱

*/


