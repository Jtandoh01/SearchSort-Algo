public class LinearSearch {
    public int search(String[] array, String target) {
        // Iterate over the array elements from index 0 to length - 1
        for (int i = 0; i < array.length; i++) {
            // Check if the current element is equal to the target
            if (array[i].equals(target)) {
                return i; // Target found at index i
            }
        }
        return -1; // Target not found in the array
    }
}
