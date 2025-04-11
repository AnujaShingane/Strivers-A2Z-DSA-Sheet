/*
   Q. Kth Smallest Element in an Array
   
   Given an array arr[] and an integer K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

   Example 1:
   
   Input:
   N = 6
   arr[] = 7 10 4 3 20 15
   K = 3
   Output : 7
   Explanation :
   3rd smallest element in the given array is 7.
   Example 2:
   
   Input:
   N = 5
   arr[] = 7 10 4 20 15
   K = 4
   Output : 15
   Explanation :
   4th smallest element in the given array is 15.
*/
Min-Heap: O(N log N) time, O(N) space – push all, pop k-1 → simple but less efficient;
Max-Heap of size K: O(N log K) time, O(K) space – keep only K smallest → optimal when K ≪ N.

   
class Solution {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0 ; i < arr.length ; i++){
            pq.add(arr[i]);
            if(pq.size() > k){
                pq.remove();
            }
        }
        return pq.peek();
    }
}

import java.util.PriorityQueue;

public class Kth_smallest_element_in_the_Array {
    public static int kthSmallest(int[] arr, int k) 
    { 
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
        }
        for(int i = 0; i < k - 1; i++){
            pq.poll();
        }
        return pq.poll();
    } 
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(kthSmallest(arr, k));
    }
}
