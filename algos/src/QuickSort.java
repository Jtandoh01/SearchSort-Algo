public class QuickSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        // Call the quickSort method to sort the array
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        // Check if there are more than one element to sort
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, low, high);
            // Recursively sort the sub-arrays before and after the pivot
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        // Choose the last element as the pivot
        int pivot = array[high];
        // Initialize the index of smaller element
        int i = low - 1;

        // Traverse through the array from low to high-1
        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (array[j] < pivot) {
                // Increment the index of smaller element
                i++;
                // Swap the elements at i and j
                swap(array, i, j);
            }
        }

        // Swap the pivot element with the element at (i + 1)
        swap(array, i + 1, high);
        // Return the index of the pivot element
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        // Swap the elements at indices i and j in the array
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
