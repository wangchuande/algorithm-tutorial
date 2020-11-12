package com.algorithm.tutorial.sort;

public class MergeSort {

    public int[] sortArray(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }


    private void mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }

        int mid = start - ((start - end) / 2);

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, end, mid);


    }

    private void merge(int[] arr, int start, int end, int mid) {

        int length = end - start + 1;

        int[] newArr = new int[length];

        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                newArr[k] = arr[i];
                i++;
            } else {
                newArr[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            newArr[k] = arr[i];
            i++;
            k++;
        }

        while (j <= end) {
            newArr[k] = arr[j];
            j++;
            k++;
        }


        for (int x = 0; x < length; x++) {
            arr[start + x] = newArr[x];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 3, -5};

        arr = new MergeSort().sortArray(arr);

        for (int i = 0; i < args.length; i++) {

            System.out.print(arr[i]);
        }
    }
}
