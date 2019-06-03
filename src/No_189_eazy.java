/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class No_189_eazy {
    /**
     * 非原地算法
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int l = 0;
        if (nums.length == 1) return;
        int j  = k % nums.length;//
        for (int i = j; i < nums.length; i++) {
            temp[i] = nums[l++];
        }
        for (int i = 0; i < j; i++) {
            temp[i] = nums[l++];
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    /**
     * 原地算法
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        if (nums.length == 1) return;
        int j  = k % nums.length;
        reverse(nums,nums.length-j,nums.length-1);
        reverse(nums,0,nums.length-j-1);
        reverse(nums,0,nums.length-1);
    }

    /**
     * 原地算法辅助方法
     * @param nums 待算数组
     * @param i 开始位置
     * @param j 结束位置
     */
    public void reverse(int[] nums,int i,int j){
        int m = i;
        int n = j;
        int temp;
        for (; m < n; m++,n--) {
            temp = nums[m];
            nums[m] = nums[n];
            nums[n] = temp;
        }
    }
}
