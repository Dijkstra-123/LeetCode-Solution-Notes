package BinaryTree.总结;

/*

从前序与中序遍历序列构造二叉树
给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。



示例 1:


输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]
示例 2:

输入: preorder = [-1], inorder = [-1]
输出: [-1]


提示:

        1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder和inorder均 无重复 元素
inorder均出现在preorder
preorder保证 为二叉树的前序遍历序列
inorder保证 为二叉树的中序遍历序列

作者：LeetCode
链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xoei3r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/



public class 从前序与中序遍历序列构造二叉树 {

}




/*

子树的根自己也是递归
根也是递归的（只不过是分树和子树）          //这是树的递归定义早已经证明过的













下面的中后也是一样的

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len=inorder.length;
        if(len==0)return null;
        return dfs(inorder,postorder,0,len-1,0,len-1);
    }

    TreeNode dfs(int[] inorder, int[] postorder,int head1,int tail1, int head2,int tail2){
        if(head2>tail2)return null;

        int val=postorder[tail2];
        TreeNode root=new TreeNode(val);
        if(head2==tail2)return root;

        int mid=0;  //拆分点mid的位置是相对的，因为h1!=h2
        while(inorder[head1+mid]!=val)mid++;

        root.left=dfs(inorder, postorder, head1, head1+mid-1, head2, head2+mid-1);
        root.right=dfs(inorder, postorder, head1+mid+1, tail1, head2+mid, tail2-1);

        return root;
    }
}

作者：JalonJia
链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xo98qt/?discussion=Yf1ku7
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
