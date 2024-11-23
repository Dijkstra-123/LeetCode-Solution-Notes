package LinkedList.环形链表;

/*61. 旋转链表
        已解答
中等
        相关标签
相关企业
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。



示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]
示例 2：


输入：head = [0,1,2], k = 4
输出：[2,0,1]


提示：

链表中节点的数目在范围 [0, 500] 内
-100 <= Node.val <= 100
     0 <= k <= 2 * 109
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class 旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        int num = 0;
        ListNode last = pre;
        while (last.next != null) {                    //多角度找反例
            num++;
            last = last.next;
        }
        if (num == 1) {
            return head;
        }
        k = k % num;                                   //超出的情况
        while (k != 0) {
            if (fast.next != null) {
                fast = fast.next;
            }
            k--;
        }
        while (fast != slow && fast.next != null) {    //fast != slow
            slow = slow.next;
            fast = fast.next;
        }
        head = slow.next;
        slow.next = null;
        fast.next = pre.next;
        return head;
    }
}

/*
要注意不同的特殊情况
注意节点的个数和移动的个数
分类：
节点的个数 < 移动步数
节点的个数 > 移动步数
（这样就是无穷列举）

如cs61b里面说到的设计不变量就可以不用去管特殊情况
cs61b里说的是哨兵
但是这里更加合适的是环形列表

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/rotate-list/solutions/681812/xuan-zhuan-lian-biao-by-leetcode-solutio-woq1/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
