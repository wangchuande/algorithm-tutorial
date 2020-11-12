package com.algorithm.tutorial.sort;

public class QuickSort {

    public int[] sortArray(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }


    public void quickSort(int[] nums, int start, int end) {
        int pivot = partition(nums, start, end);

        if (pivot != start) {
            quickSort(nums, start, pivot - 1);
        }

        if (pivot != end) {
            quickSort(nums, pivot + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int value = nums[end];

        int i = start;
        int j = i;

        while (j <= end) {
            if (nums[j] < value) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }

            j++;
        }
        nums[end] = nums[i];
        nums[i] = value;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 3, -5};

        arr = new QuickSort().sortArray(arr);

        for (int i = 0; i < args.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
