package BinaryTree.二叉树的后序遍历;

public class 二叉树的后序遍历 {

}



/*


今天在搞性质3的证明的时候就再想这是会用到思想还是是浪费时间
结果今天晚上就证明是有用的了

当我想简单改造前、中顺序遍历的代码小改成后序遍历（就像前序编列小改成为中顺序遍历的成功那样）
但是失败了

其实就应该像是搞性质3的证明的时候那样，从另一个角度看，而我的证明就正是这样一个非常新的视角


下面是失败的代码（具体失败原因不清楚，但是感觉和递归那样 指针 == null的时候才添加这里附近有问题）

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *//*

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode temp = null;
        TreeNode center = null;
        while(p != null || !stack.empty()) {
            if(p == null && !stack.empty()) {
                if(center != null) {
                    ans.add(center.val);
                    center = null;
                }
                temp = stack.pop();
                ans.add(temp.val);
                p = temp.right;
                if(!stack.empty()) {
                    center = stack.pop();
                }
        } else if (p != null) {
            stack.push(p);
            p = p.left;
        }
    }
        return ans;
}
}



LeetCode题解
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/binary-tree-postorder-traversal/solutions/431066/er-cha-shu-de-hou-xu-bian-li-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




root.right == prev的用处

    1
     \
      2
     /
    3
这棵树的后序遍历顺序应该是 [3, 2, 1]。

现在我们用这个例子走一遍代码逻辑：

初始化 stack 为空，prev 为 null，当前节点 root 指向根节点 1。
因为 root 不是 null，我们进入内层 while 循环，将节点 1 压入栈中，并尝试访问其左子节点。因为节点 1 的左子节点是 null，我们退出内层循环。
我们从栈中弹出节点 1，并检查它的右子节点。由于它有右子节点 2 并且 prev == null（意味着我们还没有访问过任何节点），所以我们不处理节点 1，而是将其再次压入栈中并将 root 设置为其右子节点 2。
然后我们对节点 2 执行相同的操作，将它压入栈中，并尝试访问其左子节点 3。
节点 3 没有左右子节点，所以我们直接从栈中弹出它。此时，root.right == null 成立，我们将 3 添加到结果列表中，并设置 prev = 3 和 root = null。
回到上一层循环，我们从栈中弹出节点 2。此时，root.right == prev 成立（因为 prev 是 3，而 2 的右子节点确实是 3），所以我们将 2 添加到结果列表中，并更新 prev = 2 和 root = null。
再次回到上一层循环，我们从栈中弹出节点 1。同样地，root.right == prev 成立（因为 prev 是 2，而 1 的右子节点确实是 2），所以我们将 1 添加到结果列表中，并更新 prev = 1 和 root = null。
此时，栈为空，root 也是 null，所以我们结束循环，返回结果列表 [3, 2, 1]。
在这个过程中，root.right == prev 这个条件帮助我们确保了每个节点都是在它的所有子节点都被访问过后才被处理，从而保证了后序遍历的正确性。





或者简单递归

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

cs61b里面的全部处理成一样的情况那样




其实那个推导过程得出的思想并不好
我再做的时候并不能凭借这一点去做成功题目（尽管我由此发现了重做题目的意义！！！）                          //那个推导就是一般的遍历，反而是机械化的思想启发了那个证明
推导的那个是一般的机械的代码体现的思想（举个例子就可以清晰地知道了）
我感到真正的思路反而是从递归调用那里拆开，那些关键部位的理解正是来自于递归，这样反而使得思路变得十分清晰
== 的上面那个其实就是区分到叶子节点和中间的区别是否是左边已经遍历过了，这是递归的简洁性或者说统一性思想所隐藏的
还可以从从root贯穿始终看出题解是从递归拆出来的

*/
