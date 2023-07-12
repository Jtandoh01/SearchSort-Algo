public class SelectionSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        // Iterate over the array from the beginning
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i; // Assume the current element is the minimum

            // Find the index of the minimum element in the remaining unsorted part of the array
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the current element with the minimum element found
            swap(array, i, minIndex);
        }
    }

    private void swap(int[] array, int i, int j) {
        // Swap the elements at indices i and j in the array
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
