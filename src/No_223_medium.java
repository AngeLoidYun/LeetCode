/**
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * <p>
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 * <p>
 * 示例:
 * <p>
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 */
public class No_223_medium {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int s = 0;
        if (E >= C || G <= A || H <= B || F >= D) {//必定不想交
            s = 0;
        } else {
            int x1 = Math.max(A, E);//相交部分的左边只能有AE决定，下同
            int x2 = Math.min(C, G);

            int y1 = Math.max(B, F);
            int y2 = Math.min(D, H);

            s = (x2 - x1) * (y2 - y1);
        }

        return (C-A) * (D-B) + (G-E) * (H-F) - s;
    }
}
