package main.java.basic;

import java.util.Scanner;

/**
 * 二分模板: 二分有 2 种写法, 当数组内容是: 1 2 3 3 3 3 4, 查找 3 时, 不同的二分模板, 查找 3 的位置不同, 模板伪代码如下
 * 二分模板
 *      模板1:
 *      while (l < r) {
 *          int mid = l + r >> 1;
 *          if (q[mid] >= target) r = mid;
 *          else l = mid + 1;
 *      }
 *      // 此时 l 代表最左边的 3, 即 q[2]
 *      if (q[l] == target) System.out.print(l)
 *
 *      模板2:
 *      while (l < r) {
 *          int mid = l + r + 1 >> 1;
 *          if (q[mid] <= target) l = mid;
 *          else r = mid - 1;
 *      }
 *      // 此时 l 代表最右边的 3, 即 q[5]
 *      if (q[l] == target) System.out.print(l)
 *
 * 题目:
 *      给定一个按照升序排列的长度为n的整数数组，以及 q 个查询。
 *      对于每个查询，返回一个元素k的起始位置和终止位置（位置从0开始计数）。
 *      如果数组中不存在该元素，则返回“-1 -1”。
 *
 * 输入格式
 * 第一行包含整数n和q，表示数组长度和询问个数。
 * 第二行包含n个整数（均在1~10000范围内），表示完整数组。
 * 接下来q行，每行包含一个整数k，表示一个询问元素。
 *
 * 输出格式
 * 共q行，每行包含两个整数，表示所求元素的起始位置和终止位置。
 * 如果数组中不存在该元素，则返回“-1 -1”。
 *
 * 样例:
 *      输入样例：
 *          6 3
 *          1 2 2 3 3 4
 *          3
 *          4
 *          5
 *      输出样例：
 *          3 4
 *          5 5
 *          -1 -1
 * @author regotto
 */
public class BinaryTemplate {

    private static Scanner sc = new Scanner(System.in);

    static void numberScope(int n, int[] q, int k) {
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (q[mid] >= k) r = mid;
            else l = mid + 1;
        }
        if (q[l] != k) System.out.println("-1 -1");
        else {
            System.out.print(l + " ");
            l = 0;
            r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (q[mid] <= k) l = mid;
                else r = mid - 1;
            }
            System.out.println(l);
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        int[] q = new int[n];
        for (int i = 0; i < n; i++) q[i] = sc.nextInt();
        for (int i = 0; i < m; i++) {
            numberScope(n, q, sc.nextInt());
        }
    }

}
