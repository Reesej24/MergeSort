import java.util.Scanner;

public class MergeSortLab {
    private static int comparisons;

    public static void merge(int[] numbers, int i, int j, int k) {
        int mergedSize = k - i + 1;     // Size of merged partition
        int [] mergedNumbers  = new int [mergedSize]; // Temporary array for merged numbers
        int mergePos;                   // Position to insert merged number
        int leftPos;                    // Position of elements in left partition
        int rightPos;                   // Position of elements in right partition

        mergePos = 0;
        leftPos = i;                    // Initialize left partition position
        rightPos = j + 1;               // Initialize left partition position

        // Add smallest element from left or right partition to merged numbers
        while (leftPos <= j && rightPos <= k) {
            // This is where the comparisons are made
            comparisons++;
            if (numbers[leftPos] < numbers[rightPos]) {
                mergedNumbers[mergePos] = numbers[leftPos];
                ++leftPos;
            }
            else {
                mergedNumbers[mergePos] = numbers[rightPos];
                ++rightPos;6+3
            }
            ++mergePos;
        }

        // If left partition is not empty, add remaining elements to merged numbers
        while (leftPos <= j) {
            mergedNumbers[mergePos] = numbers[leftPos];
            ++leftPos;
            ++mergePos;
        }

        // If right partition is not empty, add remaining elements to merged numbers
        while (rightPos <= k) {
            mergedNumbers[mergePos] = numbers[rightPos];
            ++rightPos;
            ++mergePos;
        }

        // Copy merge number back to numbers
        for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
            numbers[i + mergePos] = mergedNumbers[mergePos];
        }
    }

    public static void mergeSort(int [] numbers, int i, int k) {
        int j;

        if (i < k) {
            j = (i + k) / 2;        // Find midpoint in the partition

            // Recursively sort left and right partitions
            mergeSort(numbers, i, j);
            mergeSort(numbers, j + 1, k);

            // Merge left and right partition in sorted order
            merge(numbers, i, j, k);
        }
    }

    public static void main(String [] args) {
        int [] numbers;
        int size;
        int i;

        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        size = scnr.nextInt();
        System.out.println("Enter integer elements of array: ");
        numbers = new int[size];
        for (i = 0; i < size; ++i) {
            numbers[i] = scnr.nextInt();
        }

        System.out.println();

        System.out.print("UNSORTED: ");
        for (i = 0; i < numbers.length; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // Initial call to merge sort with index
        mergeSort(numbers, 0, numbers.length - 1);

        System.out.println();

        System.out.print("SORTED: ");
        for (i = 0; i < numbers.length; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        System.out.println("Comparisons: " + comparisons);
    }
}
