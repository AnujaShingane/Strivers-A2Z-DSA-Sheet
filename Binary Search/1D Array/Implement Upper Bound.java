/*
 * Q. Write a program to find the Ceil Value in an Array.
 * 
 * Input:
 * int[] nums = {1,2,8,10,11,12,19};
   int target = 5;
   Output: 2 (which is the index of 8 i.e ceil value).

*/


public class Implement_Upper_Bound_In_Sorted_Array {
    public static int findCeil(int[] nums, int target){
        /*
         * BruteForce Approach: Time complexity: O(N) & Space complexity: O(1).
         * int ceil = Integer.MAX_VALUE;
           for(int i = 0; i < nums.length; i++){
               if(ceil > nums[i] && nums[i] >= target){
                   ceil = nums[i];
               }
           }
           if(ceil == Integer.MAX_VALUE){
               ceil = -1;
           }
        */
        
        // Solution 2: Optimized
        // Time complexity: O(logN) & Space complexity: O(1).
         my--
        class Solution {
          public int searchInsert(int[] nums, int target) {
              int n = nums.length;
              int low = 0 ;
              int high = n-1;
              int ans = n; // hypothetical ans (last ind. +1)
      
              while(low <= high){
                  int mid = (low + high)/2;
                  //maybe an answer
                  if(nums[mid] > target){
                      ans = mid;
                      //look for more smaller index on left
                      high = mid-1;
                  }
                  else{
                      low = mid + 1; // look for right
                  }
              }
              return ans;
          }
      }
    public static void main(String[] args) {
        int[] nums = {1,2,8,10,11,12,19};
        int target = 5;
        System.out.println(findCeil(nums, target));
    }
}
