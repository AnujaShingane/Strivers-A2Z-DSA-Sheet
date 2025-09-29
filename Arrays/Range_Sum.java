class NumArray {
    private int[] prefix;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefix = new int[nums.length];
        if(n>0){
            for(int i = 0 ; i < n ; i++){
                if(i==0) prefix[i] = nums[i];
                else prefix[i] = prefix[i-1] + nums[i];
            }
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0)return prefix[right];
        else return prefix[right]-prefix[left-1];
    }
}