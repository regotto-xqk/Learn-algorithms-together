package main.java.dichotomy;

import javafx.scene.layout.Priority;

import java.util.PriorityQueue;

/**
 * 求数组中位数(该中位数需要动态维护)
 * 题目:
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如:
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 示例：
 *  addNum(1)
 *  addNum(2)
 *  findMedian() -> 1.5
 *  addNum(3)
 *  findMedian() -> 2
 *
 *  题解:
 *      使用一个大顶堆, 一个小顶堆维护数据, 例: 1 2 3 4 5 6, 大顶堆存左边 123, 小顶堆存右边 456, 大顶堆与小顶堆直接 size 相等或差 1
 *      中位数就是小顶堆与大顶堆的 (down.top() + up.top()) / 2.0; 时间 O(N*logN)
 *
 * @author regotto
 */
public class Lc295FindMedianFromDataStream {

    class MedianFinder {

        PriorityQueue<Integer> down = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> up = new PriorityQueue<>();

        /** initialize your data structure here. */
        public MedianFinder() {}

        public void addNum(int num) {
            if (down.isEmpty() || num <= down.peek()) {
                down.add(num);
                if (down.size() > up.size() + 1) {
                    up.add(down.poll());
                }
            } else {
                up.add(num);
                if (up.size() > down.size()) {
                    down.add(up.poll());
                }
            }
        }

        public double findMedian() {
            if ((down.size() + up.size()) % 2 == 0) return down.peek();
            return (down.peek() + up.peek()) / 2.0;
        }
    }

}
