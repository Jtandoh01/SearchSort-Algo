public class InsertionSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        // Iterate over the array from the second element (index 1) to the last element
        for (int i = 1; i < array.length; i++) {
            int j = i - 1; // Set the initial position of the element to be inserted
            int key = array[i]; // Store the value of the current element to be inserted

            // Compare the current element with the elements before it and shift them to the right
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]; // Shift the element to the right
                j--;
            }

            array[j + 1] = key; // Insert the current element into its correct position
        }
    }
}
