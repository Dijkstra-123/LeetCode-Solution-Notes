package BinaryTree.运用递归解决问题;


/*

路径总和
给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。

叶子节点 是指没有子节点的节点。



示例 1：


输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
输出：true
解释：等于目标和的根节点到叶节点路径如上图所示。
示例 2：


输入：root = [1,2,3], targetSum = 5
输出：false
解释：树中存在两条根节点到叶子节点的路径：
        (1 --> 2): 和为 3
        (1 --> 3): 和为 4
不存在 sum = 5 的根节点到叶子节点的路径。
示例 3：

输入：root = [], targetSum = 0
输出：false
解释：由于树是空的，所以不存在根节点到叶子节点的路径。


提示：

树中节点的数目在范围 [0, 5000] 内
-1000 <= Node.val <= 1000
        -1000 <= targetSum <= 1000
相关标签

        Java



作者：LeetCode
链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xo566j/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/


public class 路径总和 {
    public static void main(String[] args) {

    }
}


/*

减少处理特殊情况的思想


多举例子？
但是如果体力累的话，个人根本没办法

如果直接处理复杂情况会出错就可说明这样几乎是对自己没有用的，不用说这个时候状态什么的
最好是先递归再拆开



递归
递归可以通过传送sum的数值，可以直接给下一个递归                                                                               //传送的不美不对
这样做的好处就是就是每个部分的都是不一样的，各个部分（各个递归函数的sum函数）都是独立的（不需要再处理删除和删除可能带来的影响，能少处理）
没有那没多代码，更不容易出错


正负号其实就是区别的一种

for循环也可以搞出那种，除非本身有递归特性

CS61B真不是吹的！！！



























class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        fun(root);
        return ans;
    }

    private void fun(TreeNode root) {
        if(root == null) {
            return;
        }
        fun(root.left);
        fun(root.right);
        ans.add(root.val);
    }
}

就拿后序遍历来说，这样子就简单多了，没有复杂的东西。

*/

