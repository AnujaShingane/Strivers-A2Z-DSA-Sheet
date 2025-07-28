class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subsequences(0,list,nums,res);
        return res;
    }

    public void subsequences(int ind , List<Integer> list , int[] nums , List<List<Integer>> res) {
        if(ind >= nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[ind]); // take a element
        subsequences(ind+1,list,nums,res);
        list.remove(list.size()-1); // not take
        subsequences(ind+1,list,nums,res);
    }
}
