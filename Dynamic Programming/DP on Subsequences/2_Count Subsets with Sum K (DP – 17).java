/*
    Q. Count Subsets with Sum K (DP – 17)
    Practice : https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=perfect-sum-problem

    Given an array arr[] of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

    Note: Answer can be very large, so, output answer modulo 109+7
    
    Example 1:
    
    Input: N = 6, arr[] = {2, 3, 5, 6, 8, 10}
           sum = 10
    Output: 3
    Explanation: {2, 3, 5}, {2, 8}, {10}
    Example 2:
    Input: N = 5, arr[] = {1, 2, 3, 4, 5}
           sum = 10
    Output: 3
    Explanation: {1, 2, 3, 4}, {1, 4, 5}, 
                 {2, 3, 5}
*/

// import java.util.Arrays;


Problem                                                     Convert to
    
Count Subsets with Sum K	                ---->         target = K
Target Sum	                                ---->         target = (totalSum + target) / 2
Count Partitions with Given Difference      ---->         target = (totalSum − diff) / 2


Recursion ->

int f(int i, int target, int[] arr){
    if(i == 0){
        if(target == 0 && arr[0] == 0) return 2; // take or not take zero
        if(target == 0 || target == arr[0]) return 1;
        return 0;
    }

    int notTake = f(i-1, target, arr);
    int take = 0;
    if(arr[i] <= target)
        take = f(i-1, target - arr[i], arr);

    return take + notTake;
}



Memoization -> 

 Integer[][] dp;

int f(int i, int target, int[] arr){
    if(i == 0){
        if(target == 0 && arr[0] == 0) return 2;
        if(target == 0 || target == arr[0]) return 1;
        return 0;
    }

    if(dp[i][target] != null) return dp[i][target];

    int notTake = f(i-1, target, arr);
    int take = 0;
    if(arr[i] <= target)
        take = f(i-1, target - arr[i], arr);

    return dp[i][target] = take + notTake;
}


Tabulation ->

int[][] dp = new int[n][target+1];

if(arr[0] == 0) dp[0][0] = 2;
else dp[0][0] = 1;

if(arr[0] != 0 && arr[0] <= target)
    dp[0][arr[0]] = 1;

for(int i=1;i<n;i++){
    for(int t=0;t<=target;t++){
        int notTake = dp[i-1][t];
        int take = 0;
        if(arr[i] <= t)
            take = dp[i-1][t - arr[i]];
        dp[i][t] = take + notTake;
    }
}
return dp[n-1][target];


    
Space Optimization ->

int[] prev = new int[target+1];

if(arr[0] == 0) prev[0] = 2;
else prev[0] = 1;

if(arr[0] != 0 && arr[0] <= target)
    prev[arr[0]] = 1;

for(int i=1;i<n;i++){
    int[] cur = new int[target+1];
    for(int t=0;t<=target;t++){
        int notTake = prev[t];
        int take = 0;
        if(arr[i] <= t)
            take = prev[t - arr[i]];
        cur[t] = take + notTake;
    }
    prev = cur;
}
return prev[target];
