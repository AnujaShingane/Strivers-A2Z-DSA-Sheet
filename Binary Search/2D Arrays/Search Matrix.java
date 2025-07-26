// Find the Row:
// Go through each row.
// If the target lies between the first and last element of the row, it might be present in that row.
// Save the row index.
// Binary Search in that Row:
// If a valid row is found, perform binary search in that row to check if the target exists.
// Return Result:
// If binary search finds it → return true.
// Else → return false.



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
