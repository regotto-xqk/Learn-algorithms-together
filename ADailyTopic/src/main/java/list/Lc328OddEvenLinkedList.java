package main.java.list;

import main.java.entity.ListNode;

/**
 * 题目: 给定一个单链表，把所有的奇下标节点和偶下标节点分别排在一起
 * 样例:
 *  输入: 1->2->3->4->5->NULL
 *  输出: 1->3->5->2->4->NULL
 *
 * 题解: 用 4 个节点 h, o, p, e
 * h 代表 奇下标头结点, o 代表偶下标尾节点
 * p 代表偶下标头结点, e 代表偶下标尾节点
 * @author regotto
 */
public class Lc328OddEvenLinkedList {

    public ListNode oddEvenList(ListNode h) {
        if (h == null || h.next == null) return h;
        ListNode o = h, p = h.next, e = p;
        while (o.next != null && e.next != null) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return h;
    }

}
