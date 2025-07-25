class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int last = intervals[0][1];

        for(int i = 0 ; i < intervals.length ; i++){
            int[] lastInterval = list.get(list.size()-1);
            int[] current = intervals[i];

            if(lastInterval[1] >= current[0]){
                lastInterval[1] = Math.max(lastInterval[1],current[1]);
            }else{
                list.add(current);
            }
        }

        int[][] res = new int[list.size()][2];
        for(int i = 0 ; i < list.size() ; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
