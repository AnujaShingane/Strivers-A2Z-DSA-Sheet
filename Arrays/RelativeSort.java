//if arr.length <= 1000-->
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        int[] res = new int[arr1.length];

        for(int num : arr1){
            freq[num]++;
        }

        int ind = 0;
        for(int i = 0 ; i < arr2.length ; i++){
            while(freq[arr2[i]] != 0){
                res[ind++] = arr2[i];
                freq[arr2[i]]--;
            }
        }

        for(int i = 0 ; i < freq.length ; i++){
            while(freq[i] != 0){
                res[ind++] = i;
                freq[i]--;
            }
        }
        return res;
    }
}

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < arr1.length ; i++){
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }
        for(int i = 0 ; i < arr2.length ; i++){
            int freq = map.get(arr2[i]);
            while(freq != 0){
                list.add(arr2[i]);
                freq--;
            }
            map.remove(arr2[i]);
        }

        Set<Integer> keys = map.keySet();
        List<Integer> sorted = new ArrayList<>();
        for(int key : keys){
            sorted.add(key);
        }
        Collections.sort(sorted);
        for(int i = 0 ; i < sorted.size() ; i++){
            int freq = map.get(sorted.get(i));
            while(freq != 0){
                list.add(sorted.get(i));
                freq--;
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
