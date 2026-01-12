/*
    Q. Partition Equal Subset Sum (DP- 15)
    Practice : https://leetcode.com/problems/partition-equal-subset-sum/description/

    Given an integer numsay nums, return true if you can partition the numsay into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

    Example 1:
    
    Input: nums = [1,5,11,5]
    Output: true
    Explanation: The numsay can be partitioned as [1, 5, 5] and [11].
    Example 2:
    
    Input: nums = [1,2,3,5]
    Output: false
    Explanation: The numsay cannot be partitioned into equal sum subsets.
*/

Recursive ->

boolean f(int i, int target, int[] arr){
    if(target == 0) return true;
    if(i == 0) return arr[0] == target;

    boolean notTake = f(i-1, target, arr);
    boolean take = false;
    if(arr[i] <= target)
        take = f(i-1, target - arr[i], arr);

    return take || notTake;
}


Memoization -> 

    Boolean[][] dp;

boolean f(int i, int target, int[] arr){
    if(target == 0) return true;
    if(i == 0) return arr[0] == target;

    if(dp[i][target] != null) return dp[i][target];

    boolean notTake = f(i-1, target, arr);
    boolean take = false;
    if(arr[i] <= target)
        take = f(i-1, target - arr[i], arr);

    return dp[i][target] = take || notTake;
}


Tabulation ->

boolean[][] dp = new boolean[n][k+1];

for(int i=0;i<n;i++) dp[i][0] = true;
if(arr[0] <= k) dp[0][arr[0]] = true;

for(int i=1;i<n;i++){
    for(int t=1;t<=k;t++){
        boolean notTake = dp[i-1][t];
        boolean take = (arr[i]<=t)? dp[i-1][t-arr[i]] : false;
        dp[i][t] = take || notTake;
    }
}
return dp[n-1][k];

    
Space Optimization ->

boolean[] prev = new boolean[k+1];
prev[0] = true;
if(arr[0] <= k) prev[arr[0]] = true;

for(int i=1;i<n;i++){
    boolean[] cur = new boolean[k+1];
    cur[0] = true;
    for(int t=1;t<=k;t++){
        boolean notTake = prev[t];
        boolean take = (arr[i]<=t)? prev[t-arr[i]] : false;
        cur[t] = take || notTake;
    }
    prev = cur;
}
return prev[k];

