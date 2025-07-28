class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subsequences(0, list, 0, candidates, target, res);
        return res;
    }

    public void subsequences(int ind, List<Integer> list, int sum, int[] candidates, int target, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (ind >= candidates.length || sum > target) {
            return;
        }

        // Include: stay at same index
        list.add(candidates[ind]);
        subsequences(ind, list, sum + candidates[ind], candidates, target, res);
        list.remove(list.size() - 1);

        // Exclude: move to next index
        subsequences(ind + 1, list, sum, candidates, target, res);
    }
}
