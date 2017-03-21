import java.util.*;

public class BinarySearch {

    public static int binSearch(int[] arr, int n) {
	int lo = 0;
	int hi = arr.length - 1;
	int mid;
	while (lo <= hi) {
	    mid = lo + (hi - lo) / 2;
	    if (arr[mid] == n) return mid;
	    if (arr[mid] < n) lo = mid + 1;
	    else hi = mid;
	}
	return -1;
    }

    public static void test(int[] arr, int n) {
	int idx = binSearch(arr, n);
	if (idx >= 0) System.out.println("Value " + n +
					 " found at index " + idx +
					 " of " + Arrays.toString(arr));
	else System.out.println("Value " + n + " not found in " +
				Arrays.toString(arr));
    }

    public static void main (String[] args) {
	int[] arr1 = {0, 1 , 2, 3, 4, 5, 6, 7, 8};
	int[] arr2 = {0, 5, 10, 15, 20};
	int[] arr3 = {};

	test(arr1, 0);
	test(arr1, 4);
	test(arr1, 5);
	test(arr1, 8);
	test(arr1, 9);
	test(arr2, 0);
	test(arr2, 5);
	test(arr2, 10);
	test(arr2, 15);
	test(arr2, 20);
	test(arr3, 0);
    }

}
