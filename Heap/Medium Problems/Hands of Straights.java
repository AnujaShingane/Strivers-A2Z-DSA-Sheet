/*
   846. Hand of Straights
   Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
   
   Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.
   
    
   
   Example 1:
   
   Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
   Output: true
   Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
   Example 2:
   
   Input: hand = [1,2,3,4,5], groupSize = 4
   Output: false
   Explanation: Alice's hand can not be rearranged into groups of 4.

 */
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        if(hand.length%groupSize != 0){
            return false;
        }

        for(int i = 0 ; i < hand.length ; i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }

        pq.addAll(map.keySet());

        while(!pq.isEmpty()){
            int min = pq.peek();
            for(int i = 0 ; i < groupSize ; i++){
                if(map.containsKey(min)){
                    map.put(min,map.get(min)-1);
                    if(map.get(min) == 0){
                        map.remove(min);
                        pq.remove(min);
                    }
                }else{
                    return false;
                }
                min++;
            }
        }
        return true;
    }
}



⏱️ Time Complexity
Let n = hand.length, k = groupSize, and m = number of unique cards.

🔹 1. map.put(...) in loop → O(n)
🔹 2. pq.addAll(map.keySet()) → O(m * log m)
Since pq is a min-heap, adding all m keys takes O(m log m)
   
For each group:
We do map.get/put → O(1)
We do pq.remove(min) → O(m) in worst case (since PriorityQueue.remove(Object o) is O(n) internally, not O(log n)).
So this loop takes O(n * m) in worst case.

                                        Total TC :    O(n + m log m + n * m)
                                           
Resource	Complexity
Time	O(n * m) (worst due to pq.remove())
Space	O(m)
