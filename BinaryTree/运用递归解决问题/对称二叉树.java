package BinaryTree.运用递归解决问题;


/*

对称二叉树
给你一个二叉树的根节点 root ， 检查它是否轴对称。



示例 1：


输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：


输入：root = [1,2,2,null,3,null,3]
输出：false


提示：

树中节点数目在范围 [1, 1000] 内
-100 <= Node.val <= 100


进阶：你可以运用递归和迭代两种方法解决这个问题吗？

作者：LeetCode
链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xoxzgv/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/



public class 对称二叉树 {
    public static void main(String[] args) {

    }
}






/*


对递归和双指针技术还是不熟


想到了两边一起，但是还是走老的遍历思路改良的道路
递归确实不能处理上面的（全局变量也不可以）只能传送，但是这个方法十分突兀


其实只要确保传入的是目标就好，会自动（递归）判断（！！！）
而不是设置全局变量或者传东西


还是要专题多练习
之前这些只能算是熟悉


*/
