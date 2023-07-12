import java.util.Arrays;

public class RadixSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        // Find the maximum element in the array
        int max = getMax(array);
        
        // Perform counting sort for each digit position (exp)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
    }

    private int getMax(int[] array) {
        // Find and return the maximum element in the array
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private void countSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Count the frequency of each digit at the current digit position (exp)
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Calculate the cumulative count of digits
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array using the count array and input array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the sorted output back to the input array
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }
}
