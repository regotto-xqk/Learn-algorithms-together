package main.java.basic;

import java.util.Scanner;

/**
 * 归并排序, 二分思想, 先二分处理, 然后利用中间数组排序
 * @author regotto
 */
public class MergeSort {

    static void mergeSort(int[] q, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        //中间数组, 存储 l~r 之间的值
        int[] tmp = new int[q.length];
        while (i <= mid && j <= r) {
            if (q[i] < q[j]) tmp[k++] = q[i++];
            else tmp[k++] = q[j++];
        }
        while (i <= mid) tmp[k++] = q[i++];
        while (j <= r) tmp[k++] = q[j++];
        // tmp 中存储的是已经排好序的, 将其覆盖到 q 中
        for (i = l, j = 0; i <= r; i++, j++) q[i] = tmp[j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] q = new int[n + 1];
        for (int i = 1; i <= n; i++) q[i] = sc.nextInt();
        mergeSort(q, 0, n);
        for (int i = 1; i <= n; i++) System.out.print(q[i] + " ");
    }

}
