package main.java.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 11.11 自由之路, 简单线性dp题, 由于 r 串中字符可能是存在重复, 因此使用 HashMap<Character, List<Integer>> 存储每个
 * 字符出现的下标
 * dp[i][j] 表示遍历 k, r[i] == k[j] 时的最小步数
 *  d[i][j] = min(d[i][j], dp[i - 1][x] + Math.min(Math.abs(j - x), n - Math.abs(j - x)) + 1)
 * @author regotto
 */
public class Lc514FreedomTrail {

    public int findRotateSteps(String r, String k) {

        int n = r.length(), m = k.length();
        List<Integer>[] p = new List[26];
        for (int i = 0; i < 26; i++) {
            p[i] = new ArrayList<>();
        }
        // 记录 r 中每个字符的位置
        for (int i = 0; i < n; i++) {
            p[r.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[m][n];
        for (int i= 0; i < m; i++) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        // 初始化 dp[0], 记录 k 中每个字符, 在 r 中最少旋转次数, 旋转包含 2 部分, 正向(i), 反向(n - i)
        for (int i : p[k.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }

        for (int i = 1; i < m; i++) {
            // 处理 r, k 相同的字符
            for (int j : p[k.charAt(i) - 'a']) {
                for (int x : p[k.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][x] + Math.min(Math.abs(j - x), n - Math.abs(j - x)) + 1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

}
