package LinkedList.双向链表;

/*430. 扁平化多级双向链表
        已解答
中等
        相关标签
相关企业
你会得到一个双链表，其中包含的节点有一个下一个指针、一个前一个指针和一个额外的 子指针 。这个子指针可能指向一个单独的双向链表，也包含这些特殊的节点。这些子列表可以有一个或多个自己的子列表，以此类推，以生成如下面的示例所示的 多层数据结构 。

给定链表的头节点 head ，将链表 扁平化 ，以便所有节点都出现在单层双链表中。让 curr 是一个带有子列表的节点。子列表中的节点应该出现在扁平化列表中的 curr 之后 和 curr.next 之前 。

返回 扁平列表的 head 。列表中的节点必须将其 所有 子指针设置为 null 。



示例 1：



输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
输出：[1,2,3,7,8,11,12,9,10,4,5,6]
解释：输入的多级列表如上图所示。
扁平化后的链表如下图：

示例 2：



输入：head = [1,2,null,3]
输出：[1,3,2]
解释：输入的多级列表如上图所示。
扁平化后的链表如下图：

示例 3：

输入：head = []
输出：[]
说明：输入中可能存在空列表。


提示：

节点数目不超过 1000
        1 <= Node.val <= 105


如何表示测试用例中的多级链表？

以 示例 1 为例：

        1---2---3---4---5---6--NULL
         |
                 7---8---9---10--NULL
             |
                     11--12--NULL
序列化其中的每一级之后：

        [1,2,3,4,5,6,null]
        [7,8,9,10,null]
        [11,12,null]
为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。

        [1,2,3,4,5,6,null]
        [null,null,7,8,9,10,null]
        [null,11,12,null]
合并所有序列化结果，并去除末尾的 null 。

        [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
*/

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

public class 扁平化多级双向链表 {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node preHead = new Node();
        preHead.next = head;
        Node p = preHead;
        Node childHead;
        Node childNext;

        while (p.next != null) {
            p = p.next;
            if (p.child != null) {
                childHead = flatten(p.child);
                childNext = p.next;

                // Connect the child list to the current node
                p.next = childHead;
                childHead.prev = p;
                p.child = null;

                // Move to the end of the child list
                while (p.next != null) {
                    p = p.next;
                }

                // Connect the remaining part of the original list
                if (childNext != null) {
                    p.next = childNext;
                    childNext.prev = p;
                }
            }
        }

        return head;
    }
}


/*
学习、做题的时候千万不要看视频放松
累了就去休息 除非是身体有问题怎么休息都休息不好



看了leetcode解题区域的大佬
总感觉官方题解应该再多加一句 工作指针应该跳到合并后的最后一个节点！不然就有可能是O（n2）的！！就是下面注释的那一行！ 兄弟们顶一顶！！！
可以想象的是一个n长的第一层别，n长的下一层

发现还是不能只是去看官方的题解的
*/
