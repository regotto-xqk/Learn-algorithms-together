package main.java.array;

/**
 * 11.10, 此题找规律题, 123456 < 123465 < 123546
 * 先从右往左找到最后一对逆序对的位置, 例如上面的 65, 找到 4 这个数的位置, 然后从 4 后面
 * 的数中找到一个与 abs(4 - x) 最小的数, 例如上面的 5, 然后交换二者, 最后从 4 之后的位置直接翻转
 * @author regotto
 */
public class L31NextPermutation {

    public void nextPermutation(int[] nums) {
        int k = nums.length - 1;
        while (k > 0 && nums[k - 1] >= nums[k]) k--;
        if (k == 0) reverse(nums, 0, nums.length - 1);
            // 1 2 3 4 6 5 => 1 2 3 5 4 6
        else {
            int t = k;
            // 找到 4 之后比 4 大的最小的数
            while (t < nums.length && nums[t] > nums[k - 1]) t++;
            // 交换 4, 5 位置, 然后将 5 之后的数翻转
            swp(nums, k - 1, t - 1);
            reverse(nums, k, nums.length - 1);
        }
    }

    void reverse(int[] n, int l, int r) {
        while (l < r) {
            int t = n[l];
            n[l++] = n[r];
            n[r--] = t;
        }
    }

    void swp(int[] n, int i, int j) {
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }

}
