package main.java.monotonous_stack;

/**
 * 11.15 每日一题
 * 题目:
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 样例:
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 题解:
 * 要保证形成最小数, 必然是尽可能的从前往后找, 遇到大的数就删, 使得当前数保持一个递减的状态, 因此可以采用一个
 * 单调栈的思路
 * 例如:
 * 1 4 3 2 2 1 9
 * 1 push
 * 1 4 push
 * 1 4 3入栈, 发现之前的数比他大, pop 4
 * 1 3 2入栈, 同理 pop 3
 * 1 2 2入栈, 同理 pop 2
 * 此时已经 pop 3个数, 后续数直接入栈, 得
 * 1 2 1 9
 * 这个入栈, 出栈的过程, 可直接用字符串模拟
 * @author regotto
 */
public class Lc402RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder ans = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int idx = 0;
            // 记录出现相反位置数的下标
            for (int j = 1; j < ans.length() && ans.charAt(j) >= ans.charAt(j - 1); j++) idx = j;
            ans.deleteCharAt(idx);
            //删除前导零
            while (ans.length() > 1 && ans.charAt(0) == '0') ans.deleteCharAt(0);
        }
        return ans.toString();
    }

}
