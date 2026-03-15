/**
 * @author: Wxj
 * 337. 打家劫舍 III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
 * 除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root。返回在不触动警报的情况下，小偷能够盗取的最高金额。
 * <p>输入描述:
 * root = [3,2,3,null,3,null,1]
 * <p>输出描述:
 * 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 */
package com.company.brush.tree;

import java.util.HashMap;
import java.util.Map;

public class Rob3 {
    Map<TreeNode, Integer> on = new HashMap<>(); // <选该节点, 该节点及其子树所能贡献的最大金额>
    Map<TreeNode, Integer> off = new HashMap<>(); // <不选该节点, 该节点及其子树所能贡献的最大金额>

    public int solution(TreeNode root) {
        dfs(root);
        return Math.max(on.getOrDefault(root, 0), off.getOrDefault(root, 0));
    }

    // 后序遍历
    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        // 选取该节点，则该节点的左右子树不能被选中
        on.put(node, node.val + off.getOrDefault(node.left, 0) + off.getOrDefault(node.right, 0));
        // 不选该节点，则该节点的左右子树可以选中，选或不选取最大
        off.put(node, Math.max(on.getOrDefault(node.left, 0), off.getOrDefault(node.left, 0)) + Math.max(on.getOrDefault(node.right, 0), off.getOrDefault(node.right, 0)));
    }
}
