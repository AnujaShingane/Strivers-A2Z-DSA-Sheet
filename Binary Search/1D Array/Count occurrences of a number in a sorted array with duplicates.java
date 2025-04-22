/*
 * Count Occurrences in Sorted Array
   Problem Statement: You are given a sorted array containing N integers and a number X, you have to find the occurrences of X in the given array.
   
   Examples:
   
   Example 1:
   Input: N = 7,  X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
   Output: 4
   Explanation: 3 is occurring 4 times in 
   the given array so it is our answer.
   
   Example 2:
   Input: N = 8,  X = 2 , array[] = {1, 1, 2, 2, 2, 2, 2, 3}
   Output: 5
   Explanation: 2 is occurring 5 times in the given array so it is our answer.
*/

class Solution {
    public int firstOcc(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = -1;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(arr[mid] == target){
                ans = mid;
                high = mid -1;
            }else if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }

    public int lastOcc(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = -1;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(arr[mid] == target){
                ans = mid;
                low = mid + 1;
            }else if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }

    int countFreq(int[] arr, int target) {
        int first = firstOcc(arr,target);
        if(first == -1){
            return 0;
        }
        int last = lastOcc(arr,target);
        return last-first+1;
    }
}

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;
        System.out.println(countOccurence(arr, target));
    }
}
