class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = -1;

        for(int i = 0 ; i < rows ; i++){
            if(matrix[i][0] <= target && target <= matrix[i][columns -1]){
                row = i;
            }
        }
        if(row == -1){
            return false;
        }
        return binarySearch(matrix[row],target);
    }

    public boolean binarySearch(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low+high)/2;

            if(arr[mid] == target){
                return true;
            }else if(arr[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
    }
}
