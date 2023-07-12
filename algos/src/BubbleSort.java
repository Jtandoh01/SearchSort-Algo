public class BubbleSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        int n = array.length;

        // Iterate over the array from the beginning to the second-to-last element
        for (int i = 0; i < n - 1; i++) {
            // Iterate over the unsorted part of the array from the beginning to n-i-1
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements and swap them if they are in the wrong order
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        // Swap the elements at indices i and j in the array
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
