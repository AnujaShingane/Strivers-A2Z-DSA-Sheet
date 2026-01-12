/*
    Q. Count Partitions with Given Difference (DP – 18)
    Practice : https://practice.geeksforgeeks.org/problems/partitions-with-given-difference/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=partitions-with-given-difference

    Given an array arr, partition it into two subsets(possibly empty) such that their union is the original array. Let the sum of the element of these two subsets be S1 and S2. 

    Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and the difference S1 and S2 is equal to d. since the answer may be large return it modulo 109 + 7.
    
    Example 1:
    
    Input:
    n = 4, d = 3
    arr[] =  { 5, 2, 6, 4}
    Output:
    1
    Explanation:
    There is only one possible partition of this array. Partition : {6, 4}, {5, 2}. The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.
    Example 2:
    
    Input:
    n = 4, d = 0 arr[] = {1, 1, 1, 1} Output: 6 
*/

// import java.util.Arrays;


Problem                                                     Convert to
    
Count Subsets with Sum K	                ---->         target = K
Target Sum	                                ---->         target = (totalSum + target) / 2
Count Partitions with Given Difference      ---->         target = (totalSum − diff) / 2
