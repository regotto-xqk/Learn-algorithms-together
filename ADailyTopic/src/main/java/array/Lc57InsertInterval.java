package main.java.array;

import java.util.ArrayList;

/**
 * 2020.11.4 每日一题
 * 57题 给出一个无重叠的 ，按照区间起始端点排序的区间列表.
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠
 *
 * 模板题: 区间合并
 * @author regotto
 */
public class Lc57InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) return intervals;
        ArrayList<int[]> tmp = new ArrayList<>();
        int k = 0;
        while (k < intervals.length && intervals[k][1] < newInterval[0]) tmp.add(intervals[k++]);
        if (k < intervals.length) {
            newInterval[0] = Math.max(newInterval[0], intervals[k][0]);
            while (k < intervals.length && intervals[k][1] <= newInterval[1]) newInterval[1] = Math.max(newInterval[1], intervals[k++][1]);
        }
        tmp.add(newInterval);
        while (k < intervals.length) tmp.add(intervals[k++]);
        int[][] res = new int[tmp.size()][2];
        for (int i = 0; i < tmp.size(); i++) res[i] = tmp.get(i);
        return res;
    }

}
