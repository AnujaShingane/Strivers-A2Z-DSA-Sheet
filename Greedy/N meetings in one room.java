class Pair{
    int first;
    int second;
    
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.second - b.second
        );
        
        ArrayList<Pair> list = new ArrayList<>();
        
        for(int i = 0 ; i < start.length ; i++){
            pq.add(new Pair(start[i], end[i]));
        }
        
        while(!pq.isEmpty()){
            Pair entry = pq.poll();
            if(list.isEmpty()){
                list.add(entry);
            }
            if(entry.first > list.get(list.size()-1).second){
                list.add(entry);
            }
        }
        return list.size();
    }
}
