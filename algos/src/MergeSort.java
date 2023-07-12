public class MergeSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        // Create a temporary array with the same length as the input array
        int[] temp = new int[array.length];

        // Call the mergeSort method to sort the array recursively
        mergeSort(array, temp, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int[] temp, int left, int right) {
        // Base case: if left < right, there are elements to sort
        if (left < right) {
            // Find the middle index to divide the array into two halves
            int mid = (left + right) / 2;

            // Recursively sort the two halves of the array
            mergeSort(array, temp, left, mid);
            mergeSort(array, temp, mid + 1, right);

            // Merge the sorted halves
            merge(array, temp, left, mid, right);
        }
    }

    private void merge(int[] array, int[] temp, int left, int mid, int right) {
        // Copy the elements from the original array to the temporary array
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }

        int i = left;   // Pointer for the left half of the array
        int j = mid + 1;    // Pointer for the right half of the array
        int k = left;   // Pointer for the merged array

        // Compare the elements from the left and right halves and merge them in sorted order
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements from the left half, if any
        while (i <= mid) {
            array[k] = temp[i];
            i++;
            k++;
        }
    }
}
