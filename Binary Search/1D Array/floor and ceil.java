class FloorCeilFinder {

    public static int[] findFloorAndCeil(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1, ceil = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                floor = arr[mid];
                ceil = arr[mid];
                break;  // Exact match found
            } else if (arr[mid] < target) {
                floor = arr[mid];  // Potential floor
                low = mid + 1;
            } else {
                ceil = arr[mid];   // Potential ceil
                high = mid - 1;
            }
        }

        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 7};
        int target = 4;

        int[] result = findFloorAndCeil(arr, target);
        System.out.println("Floor of " + target + " = " + result[0]);
        System.out.println("Ceil of " + target + " = " + result[1]);
    }
}
