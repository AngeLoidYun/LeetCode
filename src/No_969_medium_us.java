import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 煎饼排序
 *
 * 给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。
 * 我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
 *
 * 返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。
 * 任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
 */

public class No_969_medium_us {
    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList();
        int N = A.length;

        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i+1;
        Arrays.sort(B, new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                return A[j - 1] - A[i - 1];
            }
        });

        for (int i: B) {
            for (int f: ans)
                if (i <= f)
                    i = f+1 - i;
            ans.add(i);
            ans.add(N--);
        }

        return ans;
    }

}
