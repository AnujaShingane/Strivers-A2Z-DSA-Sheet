
      ⊛ The most easiest Approach is sort the Array as order as 0, 1, 2 (Time complexity: O(NlogN).
      ⊛  The most Optimized Solution is to use Dutch National Flag Algorithm
      ⊛ Time Complexity: O(N ) & Space Complexity: O(1).





1 --> Arrays.sort(arr);


Initialize: low = 0, mid = 0, high = n - 1
Loop while mid <= high:
If nums[mid] == 0 --> swap with low, increment both low and mid
If nums[mid] == 1  -->  just move mid forward
If nums[mid] == 2  -->  swap with high, decrement high





class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}



            


/*
 * Sort an array of 0s, 1s and 2s
   Problem Statement: Given an array consisting of only 0s, 1s and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)
   
   Example 1:
   
   Input: nums = [2,0,2,1,1,0]
   Output: [0,0,1,1,2,2]
   
   Input: nums = [2,0,1]
   Output: [0,1,2]
   
   Input: nums = [0]
   Input: nums = [0]

*/
import java.util.Arrays;

public class SortColors {
    public static void swap(int[] nums, int low, int high){
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
    public static void sortColors(int[] nums) {
        /*
         * Brute Force Approach: Using sorting--> Time Complexity: O(NlogN) & Space Complexity: O(1)
         * Arrays.sort(nums);
         * 
        */ 

        /* 
           Solution 2: Using Count Sort --> Time Complexity: O(N) & Space Complexity: O(1)
           int countZero = 0, countOne = 0, countTwo = 0;
           for(int i = 0; i < nums.length; i++){
               if(nums[i] == 0){
                   countZero++;
               }
               else if(nums[i] == 1){
                   countOne++;
               }
               else{
                   countTwo++;
               }
           }
           int k = 0;
           while(k < countZero){
               nums[k++] = 0;
           }
           while(k < (countOne + countZero)){
               nums[k++] = 1;
           }
           while(k < nums.length){
               nums[k++] = 2;
           }
        */
        
        // Optimized Approach: “Dutch National Flag problem” Time Complexity: O(N) & Space Complexity: O(1)
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while(mid <= high){
            switch(nums[mid]){
                case 0: swap(nums, low++, mid++);
                break;
                case 1: mid++;
                break;
                case 2: swap(nums, high--, mid);
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
