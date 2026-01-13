/*
    Q. Longest Palindromic Subsequence | (DP-28)

    Practice : https://leetcode.com/problems/longest-common-subsequence/description/

    Given a string s, find the longest palindromic subsequence's length in s.

    A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
    
    Example 1:
    
    Input: s = "bbbab"
    Output: 4
    Explanation: One possible longest palindromic subsequence is "bbbb".
    Example 2:
    
    Input: s = "cbbd"
    Output: 2
    Explanation: One possible longest palindromic subsequence is "bb".
*/

// import java.util.Arrays;
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }


        return func(0,n-1,s,dp);
    }


    public int func(int i, int j,String s,int[][] dp) {
        if(i==j)return 1;
        if(i>j)return 0;


        if(dp[i][j]!=-1)return dp[i][j];
       
        int ans = 0;
        if(s.charAt(i)==s.charAt(j)){
            ans = 2+func(i+1,j-1,s,dp);
        }else{
            ans = Math.max(func(i+1,j,s,dp),func(i,j-1,s,dp));
        }
       
        return dp[i][j] = ans;
    }
}






//tabulation


class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            dp[i][i]=1;
        }

        for(int i = n-1 ; i >= 0  ; i--){
            for(int j = i+1 ; j < n ; j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = 2+dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
       
        return dp[0][n-1];
    }
}

