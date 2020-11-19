package main.java.monotonous_stack;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * 题目:给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
 * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组
 * 样例:
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 *
 * 题解:
 *  此题做法与 402 题一样, 之前那题是从一个数组中选 k 个, 该题可以看做在 num1 中选 k1个, num2 中选 k2 个, k1 + k2 = k
 *  例: nums1 中选 2 个 65, nums 中选 3 个 983, 然后合并 98653
 *  采用单调栈及归并思路可解
 * @author regotto
 */
public class Lc321CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[0];
        // 从 nums1 中选 i 个, 从 nums2 中选 k-i 个
        for (int i = 0; i <= k && i <= nums1.length; i++) {
            if (i <= k && k - i <= nums2.length) {
                int[] tmp = mge(subMax(nums1, i), subMax(nums2, k - i));
                if (cmp(ans, 0, tmp, 0)) ans = tmp;
            }
        }
        return ans;
    }

    public int[] mge(int[] subMax, int[] subMax1) {
        return null;
    }

    int[] subMax(int[] nums, int i) {
        int[] sub = new int[i];
        int cur = 0, r = nums[0];
        return null;
    }

    public boolean cmp(int[] ans, int i, int[] tmp, int j) {
        if (j > tmp.length) return true;
        if (i > ans.length) return false;
        if (ans[i] > tmp[j]) return true;
        if (ans[i] < tmp[j]) return false;
        return cmp(ans, i + 1, tmp, j + 1);
    }

}
