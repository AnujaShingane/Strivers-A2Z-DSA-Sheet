/*
   1248. Count Number of Nice Subarrays
   Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
   
   Return the number of nice sub-arrays.
   
    
   
   Example 1:   
   Input: nums = [1,1,2,1,1], k = 3
   Output: 2
   Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

   Example 2:   
   Input: nums = [2,4,6], k = 1
   Output: 0
   Explanation: There is no odd numbers in the array.

   Example 3:   
   Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
   Output: 16
 */

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return number(nums, k) - number(nums, k-1);
    }

    public int number(int[] nums, int k) {
        int n = nums.length;
        int l = 0 , r = 0;
        int cnt = 0;
        int sum = 0;

        if(k < 0) return 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i]%2 == 0)nums[i] = 0;
            else nums[i] = 1;
        }

        while(r < n){
            sum += nums[r];

            while(sum > k){
                sum -= nums[l];
                l++;
            }

            if(sum <= k){
                cnt += r-l+1;
            }
            r++;
        }
        return cnt;
    }
}
