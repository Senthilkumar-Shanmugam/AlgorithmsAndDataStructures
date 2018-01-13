package com.learn.sort.mergesort;

public class MergeSort {
	public static void main(String[] args) {

		int[] input = { 32, 25, 65, 8, 40, 6, 78, 12 };
		// int[] input = {9,7,8};
		System.out.println("Before");
		display(input);
		sort(input, 0, input.length - 1);
		System.out.println("After");
		display(input);
	}

	private static void display(int[] a) {
		for (int e : a)
			System.out.print(e + " ");
	}

	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	private static void merge(int arr[], int l, int m, int r) {

		System.out.println("Start:" + l + ">>Mid>>" + m + ">>End>>" + r);
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		// Create temp arrays
		int L[] = new int[n1];
		int R[] = new int[n2];

		// Copy data to temp arrays
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		// Merge the temp arrays

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[] if any
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// Copy remaining elements of R[] if any
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	private static void sort(int arr[], int l, int r) {
		System.out.println("start>>" + l + " end>>" + r);
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;
			System.out.println("mid point>>" + m);
			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

}
