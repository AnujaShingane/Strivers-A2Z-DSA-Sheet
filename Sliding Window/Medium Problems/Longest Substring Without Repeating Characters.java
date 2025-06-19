/*
   Length of Longest Substring without any Repeating Character
   Problem Statement: Given a String, find the length of longest substring without any repeating character.
   
   Examples:
   
   Example 1:   
   Input: s = ”abcabcbb”   
   Output: 3   
   Explanation: The answer is abc with length of 3.
   
   Example 2:   
   Input: s = ”bbbbb”   
   Output: 1   
   Explanation: The answer is b with length of 1 units.
*/


My Solution -->
   
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0 , r = 0;
        int maxlen = 0;
        int[] index = new int[256];
        Arrays.fill(index,-1);

        while(r < n){
            if(s.charAt(r) != 0 && index[s.charAt(r)] >= l){
                l = index[s.charAt(r)]+1;
            }

            maxlen = Math.max(maxlen,r-l+1);
            index[s.charAt(r)] = r;
            r++;
        }
        return maxlen;
    }
}



// import java.util.Arrays;
import java.util.ArrayList;

public class Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {

       /*
       class Solution {
          public int lengthOfLongestSubstring(String s) {
              int n = s.length();
              int maxLen = 0;
      
              for (int i = 0; i < n; i++) {
                  int[] hash = new int[256]; // ASCII character set
                  int length = 0;
      
                  for (int j = i; j < n; j++) {
                      if (hash[s.charAt(j)] == 1) break;
      
                      hash[s.charAt(j)] = 1;
                      length = j - i + 1;
                      maxLen = Math.max(maxLen, length);
                  }
              }
      
              return maxLen;
          }
      }
       */

        
        // Solution: 02 -> Time Complexity: O(2N) & Space Complexity: O(N).

         my--
            class Solution {
                public int lengthOfLongestSubstring(String s) {
                    int[] hash = new int[256];
                    Arrays.fill(hash, -1);  // initialize all to -1
                    int n = s.length();
                    int left = 0, right = 0, maxLen = 0;
            
                    while (right < n) {
                        if (hash[s.charAt(right)] != -1 && hash[s.charAt(right)] >= left) {       -------- most optimal
                            left = hash[s.charAt(right)] + 1;
                        }
            
                        hash[s.charAt(right)] = right;
                        maxLen = Math.max(maxLen, right - left + 1);
                        right++;
                    }
            
                    return maxLen;
                }
            }




       
        ArrayList<Character> list = new ArrayList<>();
        int r = 0, max = 0;
        while(r < s.length()){
            if(list.contains(s.charAt(r))){
                while(list.contains(s.charAt(r))){
                    list.remove(0);
                }
            }
            list.add(s.charAt(r));
            r++;
            max = Math.max(max, list.size());
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
