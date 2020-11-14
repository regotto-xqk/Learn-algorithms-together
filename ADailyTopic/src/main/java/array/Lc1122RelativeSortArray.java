package main.java.array;

/**
 * 11.14 每日一题
 * 题目:
 * 给你两个数组，arr1 和 arr2, arr2 中的元素各不相同, arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 样例:
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * 题解: 使用计数排序
 * 记录 arr1 中每个元素出现的个数, 然后遍历 arr2, arr2 中出现了该元素, 则生成多个添加到 ans 中
 * 最后将 arr2 中没出现的元素一一添加到 ans 后面
 * @author regotto
 */
public class Lc1122RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] tmp = new int[1001];
        int[] ans = new int [arr1.length];
        for (int x : arr1) tmp[x]++;
        int j = 0;
        for (int x : arr2) {
            for (int i = 0; i < tmp[x]; i++) {
                ans[j++] = x;
            }
            tmp[x] = 0;
        }
        for (int i = 0; i < 1001; i++)
            for (int k = 0; k < tmp[i]; k++)
                ans[j++] = i;
        return ans;
    }

}
