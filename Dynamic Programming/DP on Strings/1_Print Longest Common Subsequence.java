/*
Problem statement
You are given two strings ‘s1’ and ‘s2’.

Return the longest common subsequence of these strings.
If there’s no such string, return an empty string. If there are multiple possible answers, return any such string.

Note:
Longest common subsequence of string ‘s1’ and ‘s2’ is the longest subsequence of ‘s1’ that is also a subsequence of ‘s2’. A ‘subsequence’ of ‘s1’ is a string that can be formed by deleting one or more (possibly zero) characters from ‘s1’.

Example:
Input: ‘s1’  = “abcab”, ‘s2’ = “cbab”

Output: “bab”

Explanation:
“bab” is one valid longest subsequence present in both strings ‘s1’ , ‘s2’.
*/



--> It is whole lcs tabu code then we know len of str going to be dp[n][m] 
    So to print if equal i-- j-- else if > i-- if another > j-- 
    check code


import java.util.*;

public class Solution {
    public static String findLCS(int n, int m, String s1, String s2){
        int[][] dp = new int[n+1][m+1];
        for(int[] arr : dp)Arrays.fill(arr,-1);

        for(int i = 0 ; i <= n ; i++)dp[i][0]=0;
        for(int i = 0 ; i <= m ; i++)dp[0][i]=0;
        
        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    ans = 1+dp[i-1][j-1];
                }else{
                    ans = Math.max(dp[i-1][j],dp[i][j-1]);
                }

                dp[i][j]=ans;
            }
        }

        //to print
        int len = dp[n-1][m-1];
        StringBuilder sb = new StringBuilder();

        int i = n;
        int j = m;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }else j--;
        }

        return sb.reverse().toString();
    }
}
