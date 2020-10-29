package main.java.tree;


import main.java.entity.TreeNode;

/**
 * 2020.10.29 打卡
 * lc129. 求根到叶子节点数字之和
 *
 * 描述: 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和
 *
 * 样例:
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 * 题解: 该题直接 dfs 深搜, 使用一个局部变量记录每条路径上的总和, 当 root.left == null && root.right == null 说明到叶子节点
 * 然后, 求和即可
 * @author regotto
 */
public class Lc129SumRootToLeafNumbers {

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return ans;
        dfs(root, 0);
        return ans;
    }

    /**
     * dfs 深搜迭代
     * @param root
     * @param i 局部变量, 用于记录每条路径上的值
     */
    private void dfs(TreeNode root, int i) {
        if (root == null) return;
        // 到叶子节点, 求和
        int k = i * 10 + root.val;
        if (root.left == null && root.right == null) ans += k;
        dfs(root.left, k);
        dfs(root.right, k);
    }

}
