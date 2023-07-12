public class BinarySearch {
    public int search(int[] array, int target) {
        int left = 0; // Left boundary index
        int right = array.length - 1; // Right boundary index

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            if (array[mid] == target) {
                return mid; // Target found at the middle index
            } else if (array[mid] < target) {
                left = mid + 1; // Target is in the right half of the array
            } else {
                right = mid - 1; // Target is in the left half of the array
            }
        }

        return -1; // Target not found in the array
    }
}
