package main.java.monotonous_stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 题目:
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 样例:
 * 输入：s = "bcabc"
 * 输出："abc"
 * 题解:
 * 此题与 402 一样, 单调栈可解决
 * @author regotto
 */
public class Lc316RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        LinkedList<Character> stk = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stk.contains(c)) continue;
            // 栈顶元素大于要添加的元素, 且栈顶元素在之后串中已经存在, 则栈顶元素可删除
            while (!stk.isEmpty() && stk.getFirst() > c && s.substring(i).contains(stk.getFirst() + "")) stk.removeFirst();
            stk.addFirst(c);
        }
        StringBuilder ans = new StringBuilder();
        for (Character c : stk) ans.append(c);
        return ans.reverse().toString();
    }

}
