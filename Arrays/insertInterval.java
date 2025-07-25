class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newArr = new int[intervals.length+1][2];
        if(intervals.length == 0 || intervals[0].length == 0){
            newArr[0] = newInterval;
            return newArr;
        }
        int ind = intervals.length;

        for(int i = 0 ; i < intervals.length ; i++){
            if(intervals[i][0] > newInterval[0]){
                ind = i;
                break;
            }
        }

        for(int i = 0 ; i < ind ; i++){
            newArr[i] = intervals[i];
        }
        newArr[ind] = newInterval;
        for(int i = ind ; i < intervals.length ; i++){
            newArr[i+1] = intervals[i];
        }

        return merge(newArr);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for(int i = 1 ; i < intervals.length ; i++){
            int[] arr = list.get(list.size()-1);

            if(arr[1] >= intervals[i][0]){
                arr[1] = Math.max(arr[1],intervals[i][1]);
            }else{
                list.add(intervals[i]);
            }
        }

        int[][] res = new int[list.size()][2];
        for(int i = 0 ; i < list.size() ; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
