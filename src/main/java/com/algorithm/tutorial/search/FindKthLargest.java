package com.algorithm.tutorial.search;

import java.util.Random;

public class FindKthLargest {

    /**
     * leetcode #215
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    public int findKthLargest(int[] nums, int start, int end, int k) {
        int i = randomPartition(nums, start, end);
        if (i + 1 == k) {
            return nums[i];
        }

        return (i + 1) < k ? findKthLargest(nums, i + 1, end, k) : findKthLargest(nums, start, i - 1, k);
    }

    private int randomPartition(int[] nums, int start, int end) {
        Random rand = new Random();
        int random = rand.nextInt(end - start + 1) + start;
        swap(nums, end , random);
        return partition(nums, start, end);
    }

    private int partition(int[] nums, int start, int end) {
        int i = start;
        int j = i;
        int value = nums[end];

        while (j < end) {
            if (nums[j] > value) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }

        nums[end] = nums[i];
        nums[i] = value;

        return i;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
