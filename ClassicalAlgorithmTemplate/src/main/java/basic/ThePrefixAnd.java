package main.java.basic;

import java.util.Scanner;

/**
 * 前缀和: 主要用于求数组中 l~r 之前的和
 *      思想:
 *          存在数组 A, 使用数组 s, 核心表达式 s[i] =  s[i-1] + A[i]
 *          s[i] = A[0] + A[1] + A[2] + ... + A[i];
 * 案例:
 *      输入一个长度为n的整数序列。
 *      接下来再输入m个询问，每个询问输入一对l, r。
 *      对于每个询问，输出原序列中从第l个数到第r个数的和。
 *
 * 输入格式
 *      第一行包含两个整数n和m。
 *      第二行包含n个整数，表示整数数列。
 *      接下来m行，每行包含两个整数l和r，表示一个询问的区间范围。
 *
 * 输出格式
 *      共m行，每行输出一个询问的结果。
 * 样例:
 *      输入样例：
 *          5 3
 *          2 1 3 6 4
 *          1 2
 *          1 3
 *          2 4
 *      输出样例：
 *          3
 *          6
 *          10
 * 题解:
 *      求数组的前缀和, 然后数组 l~r 的和等价于前缀和 s[r] - s[l]
 * @author regotto
 */
public class ThePrefixAnd {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n], s = new int[n];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            // 求 s 前缀和数组
            s[i] = s[i - 1] + a[i];
        }
        int l = sc.nextInt(), r = sc.nextInt();
        // 用 0~r 之间的和减去 0~l-1 之间的和, 等于 l~r之间的和
        System.out.println(s[r] - s[l - 1]);
    }

}
