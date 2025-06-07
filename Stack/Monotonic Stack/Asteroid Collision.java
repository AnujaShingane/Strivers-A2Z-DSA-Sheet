/*
    We are given an array asteroids of integers representing asteroids in a row.
    For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.    
    Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
    
    Example 1:
    
    Input: asteroids = [5,10,-5]
    Output: [5,10]
    Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

    Example 2:    
    Input: asteroids = [8,-8]
    Output: []
    Explanation: The 8 and -8 collide exploding each other.

    Example 3:    
    Input: asteroids = [10,2,-5]
    Output: [10]
    Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            int val = asteroids[i];
            if(val > 0){
                st.push(val);
            }else{
                while(!st.isEmpty() && st.peek() > 0 && Math.abs(val) > st.peek()){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() > 0 && Math.abs(val) == st.peek()){
                    st.pop();
                }else if(st.isEmpty() || st.peek() < 0){
                    st.push(val);
                }
            }
        }

        int[] ans = new int[st.size()];
        for(int i = st.size() -1 ; i >= 0 ; i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}
