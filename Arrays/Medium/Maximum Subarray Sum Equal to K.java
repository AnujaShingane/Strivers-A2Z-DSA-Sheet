      ⊛ The brute force approach is find the all possible subarrays and calculate the sum which is equal to K. (Time complexity: O(N^3)
      ⊛  We only need to calculate the maximum sum so we can avoid our third loop and when ever previous sum is less than curr sum we will updated our sum until sum != K. (O(N^2))
      ⊛ Now there is another optimized way for this.
      ⊛ Time Complexity: O(N ) & Space Complexity: O(1).


/*
 * Subarray with Given Sum
   Problem Statement: Subarray with Given Sum
   
   Given an array and a sum k, generate the subarray whose elements sum to k.
   
   Examples:
   
   Example 1:
   Input:
    arr = {1, 7, 3, 9}, k = 10
   
   Output: 7 3
   Explanation:
    Of all the subarrays, 7 and 3 sums to 10.
   
   Example 2:
   Input: arr = {2,1,3,4,5,6}, k = 10
   Output: 2 1 3 4
   Explanation: Of all the subarrays, 2, 1, 3 and 4 sums to 10

 */

public class Subarray_Sum_Equal_to_K {
    public static void subArrWithSumK(int nums[], int k)
    {
        ***
        // Bruteforce Approach: Time complexity: O(N^2) & Space Complexity: O(1).
       class Solution {
          public int subarraySum(int[] nums, int k) {
              int count = 0;
      
              for(int i = 0 ; i < nums.length ; i++){
                  int sum = 0;
                  for(int j = i ; j < nums.length ; j++){
                      sum = sum + nums[j];
                      if(sum == k){
                          count++;
                      }
            }
        }
        return count;
    }
}
        

        // Optimized Solution: Time Complexity: O(N) to find subarray and O(N) to print subarray & Space complexity: O(1)
        import java.util.HashMap;

            class Solution {
                public int subarraySum(int[] nums, int k) {
                    int sum = 0, count = 0;
                    HashMap<Integer, Integer> map = new HashMap<>();
                    map.put(0, 1); // Base case for subarrays starting at index 0
            
                    for (int num : nums) {
                        sum += num;
                        if (map.containsKey(sum - k)) {
                            count += map.get(sum - k); // Count valid subarrays
                        }
                        map.put(sum, map.getOrDefault(sum, 0) + 1);
                    }
                    return count;
                }
            }


    public static void main(String[] args) {
        int[] nums = { 1, 9, 3, 7 };
        int k = 10;
        subArrWithSumK(nums, k);
    }
}
