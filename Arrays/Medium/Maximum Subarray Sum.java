
      ⊛ The brute force approach is find the all possible subarrays and calculate the sum. (Time complexity: O(N^3)
      ⊛  We only need to calculate the maximum sum so we can avoid our third loop and when ever previous sum is less than curr sum we will updated our sum. (O(N^2))
      ⊛  The Best Optimized Approach is to use KADANE'S ALGORITHM
      ⊛ Time Complexity: O(N ) & Space Complexity: O(1).





            
            We loop through the array once. We maintain two variables: currentSum and maxSum.
            At each step, we add the current number to currentSum.
            If currentSum becomes negative, we reset it to 0 — because a negative sum won’t help our future subarrays.
            After each addition, we update maxSum if currentSum is larger.

/*
 * Kadane’s Algorithm : Maximum Subarray Sum in an Array
   Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
   has the largest sum and return its sum and print the subarray.
   
   Examples:
   
   Example 1:
   Input: arr = [-2,1,-3,4,-1,2,1,-5,4] 
   Output: 6 
   Explanation: [4,-1,2,1] has the largest sum = 6. 
   
   Examples 2: 
   Input: arr = [1] 
   Output: 1 
   Explanation: Array has only one element and which is giving positive sum of 1. 

       */
                  
      ✅ 1. Standard Kadane’s Algorithm (for arrays with possible negative numbers)
      🔹 Goal: Find the maximum subarray sum (can be negative if all elements are negative).

      public int maxSubArray(int[] nums) {
          int maxSoFar = nums[0];
          int maxEndingHere = nums[0];
      
          for (int i = 1; i < nums.length; i++) {
              maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
              maxSoFar = Math.max(maxSoFar, maxEndingHere);
          }
      
          return maxSoFar;
      }
              
        // Optimized Solution: Using Kadane's algorithm
        // Time complexity: O(N) & Space Complexity: O(1).
            *** Kadane's Algo
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            if(maxSum < currSum){
                maxSum = currSum;
            }
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
