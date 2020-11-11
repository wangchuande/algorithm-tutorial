package com.algorithm.tutorial.sort;

public class SelectionSort {

    public void selectSort(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
    }

    public static void main(String[] args) {

        int[] arr = {5, 6, 7, 3, 13, 2, 5, 6, 4};

        new SelectionSort().selectSort(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
