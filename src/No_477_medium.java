import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class No_477_medium {

    public static void main(String[] args) {

        System.out.println(totalHammingDistance(new int[]{4,14,2}));
    }


    /**
     * 分别计算两个数字之间的汉明距离再计算总和
     * 结果：那是必定超时了啊你在想p吃
     * @param nums
     * @return
     */
    public static int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += HammingDistance(nums[i],nums[j]);
            }
        }
        return sum;
    }


    public static int HammingDistance(int a, int b ){
        return Integer.bitCount (a ^ b);
    }

    /**
     * 新方案，计算所有元素上每一位1的个数为cnt，0的个数就是nums.length - cnt ，
     * 这样每一位就可以产生cnt*(nums.length-cnt)的汉明距离
     * @param nums
     * @return
     */
    public static int totalHammingDistance1(int[] nums){
        int totalDistance = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;//在32位二进制中，每一位上所有元素的1的个数
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j]>>i & 1) != 0){
                    cnt ++;
                }
            }
            totalDistance += cnt*(nums.length-cnt);
        }
        return  totalDistance;
    }
}
