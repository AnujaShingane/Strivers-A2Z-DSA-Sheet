/*
   295. Find Median from Data Stream
   The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
   
   For example, for arr = [2,3,4], the median is 3.
   For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
   Implement the MedianFinder class:
   
   MedianFinder() initializes the MedianFinder object.
   void addNum(int num) adds the integer num from the data stream to the data structure.
   double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
    
   
   Example 1:
   
   Input
   ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
   [[], [1], [2], [], [3], []]
   Output
   [null, null, null, 1.5, null, 2.0]
   
   Explanation
   MedianFinder medianFinder = new MedianFinder();
   medianFinder.addNum(1);    // arr = [1]
   medianFinder.addNum(2);    // arr = [1, 2]
   medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
   medianFinder.addNum(3);    // arr[1, 2, 3]
   medianFinder.findMedian(); // return 2.0
*/
class MedianFinder {
    PriorityQueue<Integer> left ;
    PriorityQueue<Integer> right ;
    
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size() == right.size()){ //coming oddth ele
            right.add(num);
            left.add(right.remove());
        }else{ // eventh ele coming
            left.add(num);
            right.add(left.remove());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()){
            return (left.peek() + right.peek())*1.0/2 ;
        }else{
            return left.peek() * 1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
public class Find_Median_from_Data_Stream {
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
    }
}
