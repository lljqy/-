package algorithm_learning.Sort;

import java.util.Arrays;

class Sort {

    /* 冒泡排序 */
    public int[] bubbleSort(int[] nums) {
        int[] nums1 = nums.clone();
        int length = nums1.length;
        boolean hasChange = true;
        for (int i = 0; i < length - 1 && hasChange; i++) {
            hasChange = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums1[j] > nums1[j + 1]) {
                    swap(nums1, j, j + 1);
                    hasChange = true;
                }
            }
        }
        return nums1;
    }

    /* 插入排序 */
    public int[] insertSort(int[] nums) {
        int[] nums1 = nums.clone();
        for (int i = 1, j, current; i < nums1.length; i++) {
            current = nums1[i];
            for (j = i - 1; j >= 0 && nums1[j] > current; j--) {
                nums1[j + 1] = nums1[j];
            }
            nums1[j + 1] = current;
        }
        return nums1;
    }

    /* 归并排序 */
    public int[] mergeSort(int[] nums) {
        int[] nums1 = nums.clone();
        _mergeSort(nums1, 0, nums1.length - 1);
        return nums1;
    }

    private void _mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) >> 1;
        _mergeSort(nums, lo, mid);
        _mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int[] nums1 = nums.clone();
        int k = lo, i = lo, j = mid + 1;
        while (k <= hi) {
            if (i > mid) {
                // 左边的复制完毕
                nums[k++] = nums1[j++];
            } else if (j > hi) {
                // 右边的复制完毕
                nums[k++] = nums1[i++];
            } else if (nums1[j] < nums1[i]) {
                // 左边边都没有复制完毕，右边的数比左边小
                nums[k++] = nums1[j++];
            } else {
                // 左边边都没有复制完毕，左边的数比右边小
                nums[k++] = nums1[i++];
            }
        }
    }

    /* 快速排序 */
    public int[] quickSort(int[] nums) {
        int[] nums1 = nums.clone();
        _quickSort(nums1, 0, nums1.length - 1);
        return nums1;
    }

    private void _quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(nums, lo, hi);
        _quickSort(nums, lo, p - 1);
        _quickSort(nums, p + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int delta = hi - lo;
        int pivot = (int)(Math.random() * (delta + 1)) + lo;
        swap(nums, pivot, hi);
        int i, j;
        for (i = lo, j = lo; j < hi; j++){
            if (nums[j] < nums[hi]){
                swap(nums, i++, j);
            }
        }
        swap(nums, i, j);
        return i;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 7, 9, 5, 8};
        Sort sort = new Sort();
        System.out.println(Arrays.toString(sort.bubbleSort(nums)));
        System.out.println(Arrays.toString(sort.insertSort(nums)));
        System.out.println(Arrays.toString(sort.mergeSort(nums)));
        System.out.println(Arrays.toString(sort.quickSort(nums)));
    }
}