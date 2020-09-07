package leetcode;

public class MatchSequenceTest {
    private static final int SIZE = 256;

    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1; // 初始化散列表bc
        }
        // 把模式串的每一个字符的ASCII码作为下标
        for (int i = 0; i < m; i++) {
            int ascii = (int) b[i];
            bc[ascii] = i;
        }
    }

    /**
     *
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     * @return
     */
    private int bm(char[] a, int n, char[] b, int m) {
        // 构建哈希表
        int[] bc = new int[SIZE];
        generateBC(b, m, bc);

        int i = 0; // i 表示主串与模式串堆对齐的第一个字符
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
                if (a[i+j] != b[j])  // 找到坏字符在模式串中对应的位置j
                    break;
            }
            if (j < 0) {
                return i; // 匹配成功返回与模式串第一个匹配的字符的位置
            }
            // 往后滑动: a[i+j] 是坏字符bad_char,  bc[bad_char] 就是坏字符在模式串中的下标x 移动 j-x 位,i += j-x
            i = i + (j - bc[(int)a[i+j]]);
        }
        return -1;
    }

}
