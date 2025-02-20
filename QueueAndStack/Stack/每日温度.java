package QueueAndStack.Stack;
/*每日温度
给定一个整数数组temperatures表示每天的温度，返回一个数组answer，其中answer[i]是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0 来代替。



示例 1:

输入: temperatures = [73,74,75,71,69,72,76,73]
输出:[1,1,4,2,1,1,0,0]
示例 2:

输入: temperatures = [30,40,50,60]
输出:[1,1,1,0]
示例 3:

输入: temperatures = [30,60,90]
输出: [1,1,0]


提示：

        1 <=temperatures.length <= 105
        30 <=temperatures[i]<= 100

作者：LeetCode
链接：https://leetcode.cn/leetbook/read/queue-stack/genw3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

import java.util.Stack;

public class 每日温度 {
    //想了好久最后超出时间就去看了别人的，第二天回忆思路写的
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = 0;i < temperatures.length;i ++){
            if(stack.empty() || temperatures[stack.peek()] >= temperatures[i]){
                stack.push(i);
            } else {
                while(!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                    ans[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ans;
    }
}


/*
1，暴力求解
最简单的方式是暴力求解，遍历每一个元素，然后再从当前元素往后找比它大的，找到之后记录下他俩位置的差值，然后停止内层循环，如果没找到默认为0。

public int[] dailyTemperatures(int[] T) {
    int length = T.length;
    int[] res = new int[length];
    for (int i = 0; i < length; i++) {
        for (int j = i + 1; j < length; j++) {
            if (T[j] > T[i]) {
                res[i] = j - i;
                break;
            }
        }
    }
    return res;
}


2，使用栈解决
暴力求解毕竟效率不高，我们还可以只用栈来解决，这个栈中存放的是数组元素的下标，我们画个图看下

代码如下

public int[] dailyTemperatures(int[] T) {
    Stack<Integer> stack = new Stack<>();
    int[] ret = new int[T.length];
    for (int i = 0; i < T.length; i++) {
        while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
            int idx = stack.pop();
            ret[idx] = i - idx;
        }
        stack.push(i);
    }
    return ret;
}

作者：数据结构和算法
链接：https://leetcode.cn/leetbook/read/queue-stack/genw3/?discussion=OGBxRQ
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

第二种方法我用“到过来干”的栈的思想指导下
一直在寻找逆过来的好处
再通过对题目的具体分析发现比较从后面比较起来可以让后面的得到复用
看题目的例子
输入: temperatures = [73,74,75,71,69,72,76,73]
输出:[1,1,4,2,1,1,0,0]
示例 2:
这里最后一个永远是0然后从倒数接着往下，如果一个i小于前面的一个就看它的前一个的reslut[i + 1],再另外设置递归寻找
这样就可以减少一些时间复杂度

但是其实可以数组做动态，栈做选择（栈在放入的时候直接依据条件限制放入和pop出）
而我则是把栈作为动态（存放一整个数组），再去数组里面用下标查找

这里面有“倒着干”的思想的引导
也有之前看《啊哈算法》积累的数学序的思考（不等式链条在计算机中的传递）
是复合思想，比较困难

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        //从后面开始查找
        for (int i = res.length - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < res.length) {
                if (T[j] > T[i]) {
                    //如果找到就停止while循环
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    //如果没找到，并且res[j]==0。说明第j个元素后面没有
                    //比第j个元素大的值，因为这一步是第i个元素大于第j个元素的值，
                    //那么很明显这后面就更没有大于第i个元素的值。直接终止while循环。
                    break;
                } else {
                    //如果没找到，并且res[j]！=0说明第j个元素后面有比第j个元素大的值，
                    //然后我们让j往后挪res[j]个单位，找到那个值，再和第i个元素比较
                    j += res[j];
                }
            }
        }
        return res;
    }

作者：数据结构和算法
链接：https://leetcode.cn/leetbook/read/queue-stack/genw3/?discussion=OGBxRQ
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

原来是我把最牛逼的给想到了！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
但是原来while循环就够了（有一些递归就是可以转化成循环的）


接下来该怎么走？
实现我的想法？还是抄一遍？
以后的每一道题目都要这样想一遍吗？
*/
