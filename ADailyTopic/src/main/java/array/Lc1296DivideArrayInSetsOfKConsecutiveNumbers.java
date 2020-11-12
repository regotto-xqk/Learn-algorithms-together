package main.java.array;

import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 True；否则，返回 False。
 *
 * 样例
 *  输入：nums = [1,2,3,3,4,4,5,6], k = 4
 *  输出：true
 *  解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
 *
 *  题解: 该题使用 PriorityQueue 存储元素, 该数据结构保证了 nums 有序, 且可满足添加删除操作
 * @author regotto
 */
public class Lc1296DivideArrayInSetsOfKConsecutiveNumbers {

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer i : nums) queue.add(i);
        while (!queue.isEmpty()) {
            // 拿出堆顶元素, 以该元素为基础, 删除 t + i 的数
            int t = queue.poll();
            for (int i = 1; i < k; i++) {
                // 要删除的元素不存在, 返回 false
                if (!queue.remove(t + i)) return false;
            }
        }
        return true;
    }

}
