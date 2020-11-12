package main.java.fast_slow_point;

import main.java.entity.ListNode;

/**
 * 题目:
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 样例:
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。`
 *
 * 题解: 使用快慢指针, fast 移速是 slow 的 2 倍, 由于链表具有环, 那 fast, slow 指针则会进入到死循环中, 当某一刻, fast 与 slow 在环中相遇
 * 相遇时, 设 slow 从 head, 开始遍历, fast 往下走, 当 slow 与 fast 再次相遇, 则是环的入口
 * 证明如下:
 *  设链表中环外部分的长度为 a。slow 指针进入环后，又走了 b 的距离与 fast 相遇。此时，fast 指针已经走完了环的 n 圈，因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nc
 *  根据题意，任意时刻，fast 指针走过的距离都为 slow 指针的 22 倍。因此，我们有
 *  a+(n+1)b+nc=2(a+b) ⟹ a=c+(n−1)(b+c)
 *  有了 a=c+(n-1)(b+c) 的等量关系，我们会发现：从相遇点到入环点的距离加上 n-1 圈的环长，恰好等于从链表头部到入环点的距离。
 *
 * @author regotto
 */
public class Lc142LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode f = head.next, s = head;
        while (f != null) {
            f = f.next;
            s = s.next;
            if (f == null) return null;
            f = f.next;
            // fast 与 slow 在环中某位置相遇
            if (s == f) {
                s = head;
                f = f.next;
                // s 从头开始走, f 往下走, 二者再次相遇时, 就是环入口
                while (s != f) {
                    s = s.next;
                    f = f.next;
                }
                return s;
            }
        }
        return null;
    }

}
