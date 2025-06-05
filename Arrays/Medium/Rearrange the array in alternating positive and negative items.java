Brute:-

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            if(nums[i] >= 0){
                pos.add(nums[i]);
            }else{
                neg.add(nums[i]);
            }
        }

        for(int i = 0 ; i < n/2 ; i++){
            res[2*i] = pos.get(i);
            res[2*i+1] = neg.get(i);
        }

        return res;
    }
}


Time Complexity:
O(n) --> for the loop that separates positive and negative numbers.
O(n/2)  -->  to fill the result array.
Total: O(n)

🧠 Space Complexity:
O(n)  -->  for the result array
O(n)  -->  for the pos list
O(n)   --> for the neg list
Total: O(3n) = O(n) extra space





Optimal :-

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] dummy = new int[n];
        int pos = 0;
        int neg = 1;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] >= 0){
                dummy[pos] = nums[i];
                pos = pos+2;
            }else{
                dummy[neg] = nums[i];
                neg = neg+2;
            }
        }
        return dummy;
    }
}



Time Complexity:
Single pass through the array → O(n)

Space Complexity:
Only one int[] result array of size n → O(n)
No extra lists used






🏁 Summary Table:
Approach	       Time Complexity	Space Complexity	Extra Lists Used
Brute Force        	O(n)	          O(3n) → O(n)	      Yes (2 lists)
Optimal           	O(n)	           O(n)	               No





import java.util.Arrays;

public class Rearrange_Array_Elements_by_Sign_Positive_Negative {
    public static int[] rearrangeArray(int[] nums) {
        /*
         * Brute Force Solution: Time Complexity: O(N) & Space complexity: O(N)
         * int[] ans = new int[nums.length];
           int k = 0;
           for(int i = 0; i < nums.length; i++){
               if(nums[i] > 0){
                   ans[k] = nums[i];
                   k+=2;
               }
           }
           int m = 1;
           for(int i = 0; i < nums.length; i++){
               if(nums[i] < 0){
                   ans[m] = nums[i];
                   m+=2;
               }
           }
           return ans;
        */

        // Solution 2: Using one loop: Time Complexity: O(N) & Space complexity: O(N)
        int[] ans = new int[nums.length];
        int k = 0;
        int j = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                ans[k] = nums[i];
                k+=2;
            }
            else{
                ans[j] = nums[i];
                j+=2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        int[] ans = rearrangeArray(nums);
        System.out.println(Arrays.toString(ans));
    }
}
