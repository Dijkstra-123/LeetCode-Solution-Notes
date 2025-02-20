package LinkedList.双指针技巧;/*删除链表的倒数第N个节点
 *给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 *
 *
 *示例 1：
 *
 *
 *输入：head = [1,2,3,4,5], n = 2
 *输出：[1,2,3,5]
 *示例 2：
 *
 *输入：head = [1], n = 1
 *输出：[]
 *示例 3：
 *
 *输入：head = [1,2], n = 1
 *输出：[1]
 *
 *
 *提示：
 *
 *链表中结点的数目为 sz
 *1 <= sz <= 30
 *0 <= Node.val <= 100
 *1 <= n <= sz
 *
 *
 *进阶：你能尝试使用一趟扫描实现吗？
 *
 *相关标签
 *
 *Java
 *
 *
 *
 *作者：LeetCode
 *链接：https://leetcode.cn/leetbook/read/linked-list/jf1cc/
 *来源：力扣（LeetCode）
 *著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class 删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lower = head;
        ListNode fast = lower;

        for(int i = 1;i <= n;i ++){
            fast = fast.next;
        }

        if(fast == null){
            head = head.next;
            return head;
        }

        fast = fast.next;
        while(fast != null){
            fast = fast.next;
            lower = lower.next;
        }

        ListNode p = lower.next;
        lower.next = p.next;
        p = null;
        return head;
    }
}

/*
 *   双指针若是单纯当作是技巧那么也太无趣了
 *   但是根据小龙的理解理论，我把它给解开了
 *
 *    这就是函数思维
 *    韩顺平老师也讲到过类似的思想，就是化繁为简，先死后活（其实也就是机械思想）
 *    首先就是把一个过程给拆解成各个小的部分
 *    fori 1 - 100 再到1 - n，就像把函数的特殊情况用未知数来替代
 *    双指针技术就是把相对位置给和找到具体的地方拆开————倒数第n个，以最后为基础第1个往后倒着数第n个
 *    但是我们可把往后数第n个和找到最后一个拆开来
 *    使用相对位置概念
 *    再找到满足条件的时候，把问题给卡死
 *
 *    这和我过去的那种各个方向词汇（指针的个数，绝对与相对的搜索不同），思想为王。拆分思想绝对更加自然
 *    可能说的还是不清楚，所以还要多做题目总结确定
 */