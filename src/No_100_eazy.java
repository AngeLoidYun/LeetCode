import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 */
public class No_100_eazy {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue1= new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty()){
            TreeNode node1 = queue1.poll();
            if(queue2.isEmpty()) return false;
            TreeNode node2 = queue2.poll();
            if (node1 == null&&node2 == null){
                continue;
            }else if(node1 ==null || node2 == null){
                return false;
            }
            if(node1.val != node2.val){
                return false;
            }
            queue1.offer(node1.left);
            queue1.offer(node1.right);
            queue2.offer(node2.left);
            queue2.offer(node2.right);
        }
        return true;
    }
    }

/**
 * 执行用时 : 2 ms, 在Same Tree的Java提交中击败了46.57% 的用户
 * 内存消耗 : 33.7 MB, 在Same Tree的Java提交中击败了89.84% 的用户
 * 好慢啊......
 */

