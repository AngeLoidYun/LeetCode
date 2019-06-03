import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_637_eazy {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sums = new ArrayList<>();//输出结果集合
        TreeNode levelLastNode = root;//当前层最后一个节点
        TreeNode nextLevelLastNode =root;//下一层最后一个节点
        int count = 0;//一层的节点数量
        double sum = 0;//一层的val之和
        Queue<TreeNode> queue = new LinkedList<>();//辅助队列
        if(root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();

                sum+=cur.val;
                count ++;
                if(cur.left!=null){
                    queue.offer(cur.left);
                    nextLevelLastNode = cur.left;
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                    nextLevelLastNode = cur.right;
                }
                if(cur == levelLastNode){
                    sums.add(sum/count);
                    levelLastNode = nextLevelLastNode;
                    sum = count = 0;
                }
        }
        return sums;
    }

}
