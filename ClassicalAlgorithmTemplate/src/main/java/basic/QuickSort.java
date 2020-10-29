package main.java.basic;

/**
 * 快速排序, 经典二分思路, 递归进行二分
 * 单次执行过程:
 *      选取数组中间点, 分别从数组左边, 右边遍历(遍历过程中再进行交换位置操作), 找到该数在数组中合适的位置
 * @author regotto
 */
import java.util.*;
public class QuickSort {

    public static void quickSort(int q[], int l ,int r) {
        if (l >= r ) return;
        int t = q[(l + r)/2], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while(q[i] < t);
            do j--; while(q[j] > t);
            if (i < j) swap(q, i, j);
        }
        quickSort(q, l, j);
        quickSort(q, j+1, r);
    }

    public static void swap(int[] x, int i, int j) {
        int t = x[i];
        x[i] = x[j];
        x[j] = t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] x = new int[size];
        for (int i = 0; i < size; i++) {
            x[i] = sc.nextInt();
        }
        quickSort(x, 0, size - 1);
        for (int i = 0; i < size; i++) {
            System.out.print(x[i] + " ");
        }
    }
}