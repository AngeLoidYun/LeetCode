import entity.TreeNode;

import java.util.*;

/**107. 二叉树的层次遍历 II
 *
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */


public class No_107_eazy {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();//辅助队列
        List<List<Integer>> result= new ArrayList<>();//返回结果
        TreeNode levelLastNode = root;//这一层最后一个节点
        TreeNode nextLevelLastNode = root;//下一层最后一个节点
        if(root != null){
            queue.offer(root);
        }
        List<Integer> level = new ArrayList<>();//每一层的结果
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            level.add(node.val);
            if(node.left!=null){
                queue.offer(node.left);
                nextLevelLastNode = node.left;
            }
            if(node.right !=null){
                queue.offer(node.right);
                nextLevelLastNode = node.right;
            }
            if(node == levelLastNode){
                result.add(level);
                level = new ArrayList<>();//需要一个新内存空间
                levelLastNode = nextLevelLastNode;
            }
        }
        Collections.reverse(result);
        return result;
    }
}
