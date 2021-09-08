package ru.shapik.leet_code.medium.array;

public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        SearchRotatedSortedArray array = new SearchRotatedSortedArray();

        System.out.println(array.search(new int[]{7,8,1,2,3,4,5,6}) == 2);
        System.out.println(array.search(new int[]{7,8,1,2,3,4,5,6}, 2) == 3);

        System.out.println(array.search(new int[]{4,5,6,7,0,1,2}, 3) == -1);
        System.out.println(array.search(new int[]{4,5,7,0,1,2,3}, 6) == -1);
        System.out.println(array.search(new int[]{4,5,6,7,0,1,2}, 0) == 4);
        System.out.println(array.search(new int[]{1,3}, 0) == -1);
        System.out.println(array.search(new int[]{4,5,6,7,0,1,2}, 4) == 0);
    }

    public int search(int[] nums, int target) {
        if (nums[0] > nums[nums.length - 1] && nums[0] > target && target > nums[nums.length - 1]) return -1;
        if (nums.length <= 4) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) return i;
            }
            return -1;
        }

        if (nums[0] > nums[nums.length - 1]){
            int index = search(nums);
            if (target >= nums[0])
                return search(nums, 0 , index -1, target);
             else
                return search(nums, index, nums.length -1, target);

        } else {
            return search(nums, 0, nums.length -1, target);
        }
    }

    private int search(int[]arr, int low, int hight, int target) {
        while (low<=hight) {
            int middle = (hight - low)/2 + low;
            if (arr[middle] == target) return middle;
            if (arr[middle] > target) {
                hight = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
    private int search(int[] arr) {
        int start = 0;
        int end = arr.length -1;
        while (start <= end) {
            int middle = (end-start)/2 + start;
            if (arr[middle-1]>arr[middle]) return middle;
            int test = (middle - start) /2 + start;
            if (arr[start] < arr[middle]) {
                start = middle;
            } else if (arr[start] < arr[(middle - start) /2 + start]){
                start = (middle - start) /2 + start ;
            } else {
                end = (middle - start) /2 + start +1;
            }
        }
        return -1;
    }
}
