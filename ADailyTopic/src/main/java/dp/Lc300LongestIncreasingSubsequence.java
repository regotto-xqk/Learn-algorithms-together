package main.java.dp;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * 题目:
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 题解: dp 可解, dp[i] 表示当前到 i 最长上升子序列长度, d[j] 表示 0 ~ i-1 内最长的上升子序列长度, 当前状态等于 0~i-1中最大值
 *  dp[i] = max(dp[i], dp[j] + 1)
 * @author regotto
 */
public class Lc300LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        // 数组中可能只有一个值, 因此将 ans, dp[0] 初始化为 1
        dp[0] = 1;
        int ans = 1;
        // 每个点都需进行一次迭代(以当前点为基础, 找最长上升子序列)
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
