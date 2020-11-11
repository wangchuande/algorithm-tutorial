package com.algorithm.tutorial.sort;

public class InsertSort {
    public void insertSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i;
            for (; j > 0; j--) {
                // 比较的是value
                if (value < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2};

        new InsertSort().insertSort(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
