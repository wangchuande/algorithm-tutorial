package com.algorithm.tutorial.sort;

public class BubbleSort {
    public void bubbleSort(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {5, 6, 7, 3, 13, 2, 5, 6, 4};

        new BubbleSort().bubbleSort(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
