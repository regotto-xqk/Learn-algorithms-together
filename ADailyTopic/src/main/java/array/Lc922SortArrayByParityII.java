package main.java.array;

/**
 * 11.12 简单题, 直接模拟即可, 找偶数位位置, 判断该是是否偶数, 不是则与奇数位交换
 *
 * 题目描述:
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *
 * @author regotto
 */
public class Lc922SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            // 当前数是奇数
            if ((A[i] & 1) != 0) {
                // 找到奇下标的偶数
                while ((A[j] & 1) != 0) j += 2;
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }
        return A;
    }

}
