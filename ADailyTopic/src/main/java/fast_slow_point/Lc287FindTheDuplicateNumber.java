package main.java.fast_slow_point;

/**
 * 此题与 142 题一模一样
 *
 * 题目:
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 样例:
 *  输入: [1,3,4,2,2]
 *  输出: 2
 * @author regotto
 */
public class Lc287FindTheDuplicateNumber {

    int findDuplicate(int[] nums) {
        int f = 0, s = 0;
        while (true) {
            f = nums[nums[f]];
            s = nums[s];
            if (s == f) {
                f = 0;
                while (nums[f] != nums[s]) {
                    f = nums[f];
                    s = nums[s];
                }
                return nums[s];
            }
        }
    }

}
