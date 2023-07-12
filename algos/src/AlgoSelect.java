import java.util.Arrays;
import java.util.Scanner;

public class AlgoSelect{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Algorithm Selection Program!");
        System.out.println("Please choose an algorithm:");
        System.out.println("1. Searching");
        System.out.println("2. Sorting");

        int algorithmChoice;
        do {
            System.out.print("Enter your choice (1 or 2): ");
            algorithmChoice = scanner.nextInt();
        } while (algorithmChoice != 1 && algorithmChoice != 2);

        if (algorithmChoice == 1) {
            System.out.println("You have chosen the Searching algorithm.");
            System.out.println("Please select a searching algorithm:");
            System.out.println("1. Binary Search");
            System.out.println("2. Linear Search");

            int searchAlgorithmChoice;
            do {
                System.out.print("Enter your choice (1 or 2): ");
                searchAlgorithmChoice = scanner.nextInt();
            } while (searchAlgorithmChoice != 1 && searchAlgorithmChoice != 2);

            if (searchAlgorithmChoice == 1) {
                System.out.println("You have chosen Binary Search.");
                System.out.println("Please enter an array of integers to be sorted before searching (separated by spaces):");
                scanner.nextLine(); // Consume the newline character
                String[] elements = scanner.nextLine().trim().split("\\s+");
                int[] array = new int[elements.length];
                for (int i = 0; i < elements.length; i++) {
                    try {
                        array[i] = Integer.parseInt(elements[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter numbers only.");
                        scanner.close();
                        return;
                    }
                }

                // Sort the array before performing the binary search
                Arrays.sort(array);

                System.out.print("Enter the number to search for: ");
                int target = scanner.nextInt();

                // Perform binary search
                BinarySearch binarySearch = new BinarySearch();
                int result = binarySearch.search(array, target);

                if (result == -1) {
                    System.out.println("The number " + target + " is not found in the array.");
                } else {
                    System.out.println("The number " + target + " is found at index " + result + " in the array.");
                }
            } else {
                System.out.println("You have chosen Linear Search.");
                System.out.println("Please enter an array of elements to be searched (separated by spaces):");
                scanner.nextLine(); // Consume the newline character
                String[] array = scanner.nextLine().trim().split("\\s+");

                System.out.print("Enter the string to search for: ");
                String target = scanner.nextLine();

                // Perform linear search
                LinearSearch linearSearch = new LinearSearch();
                int result = linearSearch.search(array, target);

                if (result == -1) {
                    System.out.println("The string \"" + target + "\" is not found in the array.");
                } else {
                    System.out.println("The string \"" + target + "\" is found at index " + result + " in the array.");
                }
            }
        } else {
            System.out.println("You have chosen the Sorting algorithm.");
            System.out.println("Please select a sorting algorithm:");
            System.out.println("1. Quick Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Selection Sort");
            System.out.println("4. Bubble Sort");
            System.out.println("5. Radix Sort");
            System.out.println("6. Merge Sort");

            int sortingAlgorithmChoice;
            do {
                System.out.print("Enter your choice (1-6): ");
                sortingAlgorithmChoice = scanner.nextInt();
            } while (sortingAlgorithmChoice < 1 || sortingAlgorithmChoice > 6);

            System.out.println("You have chosen Sorting Algorithm: " + sortingAlgorithmChoice);
            System.out.println("Please enter an array of numbers to be sorted (separated by spaces):");
            scanner.nextLine(); // Consume the newline character
            String[] elements = scanner.nextLine().trim().split("\\s+");
            int[] array = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                try {
                    array[i] = Integer.parseInt(elements[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter numbers only.");
                    scanner.close();
                    return;
                }
            }

            // Handle arrays with more than 15 numbers
            if (array.length > 15) {
                System.out.println("Please enter '0' to signal the end of the array:");
                int input;
                do {
                    input = scanner.nextInt();
                } while (input != 0);
            }

            System.out.println("Original array: " + Arrays.toString(array));

            // Perform sorting based on the chosen algorithm
            SortingAlgorithm sortingAlgorithm;
            switch (sortingAlgorithmChoice) {
                case 1:
                    // Quick Sort
                    sortingAlgorithm = new QuickSort();
                    sortingAlgorithm.sort(array);
                    break;
                case 2:
                    // Insertion Sort
                    sortingAlgorithm = new InsertionSort();
                    sortingAlgorithm.sort(array);
                    break;
                case 3:
                    // Selection Sort
                    sortingAlgorithm = new SelectionSort();
                    sortingAlgorithm.sort(array);
                    break;
                case 4:
                    // Bubble Sort
                    sortingAlgorithm = new BubbleSort();
                    sortingAlgorithm.sort(array);
                    break;
                case 5:
                    // Radix Sort
                    sortingAlgorithm = new RadixSort();
                    sortingAlgorithm.sort(array);
                    break;
                case 6:
                    // Merge Sort
                    sortingAlgorithm = new MergeSort();
                    sortingAlgorithm.sort(array);
                    break;
            }

            System.out.println("Sorted array: " + Arrays.toString(array));
        }

        scanner.close();
    }
}
