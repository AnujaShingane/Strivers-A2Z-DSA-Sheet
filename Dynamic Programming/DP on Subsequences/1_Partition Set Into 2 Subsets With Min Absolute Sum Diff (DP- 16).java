/*
    Q. Partition Set Into 2 Subsets With Min Absolute Sum Diff (DP- 16)
    Practice : https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-sum-partition3317

    Given an array arr of size n containing non-negative integers, 
	the task is to divide it into two sets S1 and S2 such that the absolute difference 
	between their sums is minimum and find the minimum difference


    Example 1:
    
    Input: N = 4, arr[] = {1, 6, 11, 5} 
    Output: 1
    Explanation: 
    Subset1 = {1, 5, 6}, sum of Subset1 = 12 
    Subset2 = {11}, sum of Subset2 = 11   
    Example 2:
    Input: N = 2, arr[] = {1, 4}
    Output: 3
    Explanation: 
    Subset1 = {1}, sum of Subset1 = 1
    Subset2 = {4}, sum of Subset2 = 4
*/


S1 + S2 = totalSum
diff = |S2 - S1|
S1 is subset sum
S2 = totalSum - S1
diff = |totalSum - 2*S1|
We want minimum diff


Memoization ->
class Solution {

    public int minDifference(int arr[]) {

        int n = arr.length;

        int totalSum = 0;
        for (int x : arr)
            totalSum += x;

        int[][] dp = new int[n][totalSum + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int ans = Integer.MAX_VALUE;

        for (int s1 = 0; s1 <= totalSum; s1++) {

            if (func(n - 1, s1, arr, dp)) {
                ans = Math.min(ans, Math.abs(totalSum - 2 * s1));
            }

        }

        return ans;
    }

    boolean func(int ind, int target, int[] arr, int[][] dp) {

        if (target == 0)
            return true;

        if (ind == 0)
            return arr[0] == target;

        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;

        boolean notTake = func(ind - 1, target, arr, dp);

        boolean take = false;
        if (arr[ind] <= target)
            take = func(ind - 1, target - arr[ind], arr, dp);

        dp[ind][target] = (take || notTake) ? 1 : 0;

        return take || notTake;
    }
}

	
Tabulation ->

boolean[][] dp = new boolean[n][sum+1];

for(int i=0;i<n;i++) dp[i][0] = true;
dp[0][arr[0]] = true;

for(int i=1;i<n;i++){
    for(int t=1;t<=sum;t++){
        boolean notTake = dp[i-1][t];
        boolean take = (arr[i]<=t)? dp[i-1][t-arr[i]]:false;
        dp[i][t] = take || notTake;
    }
}

int min = Integer.MAX_VALUE;
for(int s1=0; s1<=sum/2; s1++){
    if(dp[n-1][s1]){
        int s2 = sum - s1;
        min = Math.min(min, Math.abs(s2 - s1));
    }
}
return min;






public class Partition_Set_Into_2_Subsets_With_Min_Absolute_Sum_Diff {
    /* 
        // tabulation (Visualizaiton -> https://www.youtube.com/watch?v=GS_OqZb2CWc)
        public static int minDifference(int[] nums, int n) { 
	        int totalSum = 0;
	        for(int i = 0; i < n; i++) totalSum += nums[i];
	        boolean[][] dp = new boolean[n][totalSum + 1];
            for(int i = 0; i < n; i++){
                dp[i][0] = true;
            }
            if(nums[0] <= totalSum){
                dp[0][nums[0]] = true;
            }
            
            for(int idx = 1; idx < n; idx++){
                for(int target = 1; target <= totalSum; target++){
                    // take
                    boolean take = false;
                    if(nums[idx] <= target) take = dp[idx - 1][target - nums[idx]];
                        
                    // not-take
                    boolean notTake = dp[idx - 1][target];
                    
                    dp[idx][target] = take || notTake;
                }
            }
            int min = Integer.MAX_VALUE;
            for(int s1 = 0; s1 <= totalSum/2; s1++){
                if(dp[n - 1][s1] == true){
                    min = Math.min(min, Math.abs(s1 - (totalSum - s1)));
                }
            }
            return min;
	    } 
    */
    
    // space optimization
    public static int minDifference(int nums[], int n) { 
	    int totalSum = 0;
	    for(int i = 0; i < n; i++) totalSum += nums[i];
	    
	    boolean[] prev = new boolean[totalSum + 1];
        boolean[] curr = new boolean[totalSum + 1];
        
        prev[0] = curr[0] = true;
        
        if(nums[0]<= totalSum){
            prev[nums[0]] = true;
        }
        
        for(int idx = 1; idx < n; idx++){
            for(int target = 1; target <= totalSum/2; target++){
                // take
                boolean take = false;
                if(nums[idx] <= target) take = prev[target - nums[idx]];
                    
                // not-take
                boolean notTake = prev[target];
                
                curr[target] = take || notTake;
            }
            prev = curr.clone();
        }
        
        int min = Integer.MAX_VALUE;
        for(int s1 = 0; s1 <= totalSum/2; s1++){
            if(prev[s1] == true){
                min = Math.min(min, Math.abs(s1 - (totalSum - s1)));
            }
        }
        return min;
	} 
    public static void main(String[] args) {
        int N = 4;
        int[] nums = {1, 6, 11, 5};
        System.out.println(minDifference(nums, N));
    }
}
