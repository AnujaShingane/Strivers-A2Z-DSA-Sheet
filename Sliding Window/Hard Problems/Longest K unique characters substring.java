/*
   Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.

   Example 1:
   
   Input:
   S = "aabacbebebe", K = 3
   Output: 7
   Explanation: "cbebebe" is the longest 
   substring with K distinct characters.
   
   Example 2:
   
   Input: 
   S = "aaaa", K = 2
   Output: -1
   Explanation: There's no substring with K
   distinct characters.
 */

// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        int l = 0, r = 0;
        int maxlen = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        
        while(r < n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            
            if(map.size() > k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            
            if(map.size() == k){
                maxlen = Math.max(maxlen, r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}
