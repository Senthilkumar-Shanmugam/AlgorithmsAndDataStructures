package com.learn.sort.quicksort;

import java.util.Random;

public class QuickSortRandomPivot {

	public static void main(String[] args) {
		int arr[] = // {10,80,30,90,40,50,70};
				{ 32, 25, 65, 8, 40, 78, 12, 6 };
		int n = arr.length;

		sort(arr, 0, n - 1);

		System.out.println("sorted array");
		printArray(arr);

	}

	static int partition(int arr[], int low, int high) {
		int i = low, j = high;
		int tmp;
		Random rnd = new Random();
		int random = low + rnd.nextInt(high - low);
		System.out.println("random num>>" + random);
		// swap random to the beiniing

		tmp = arr[random];
		arr[random] = arr[low];
		arr[low] = tmp;
		printArray(arr);
		return partitionHoare(arr, low, high);
	}

	static int partitionHoare(int[] arr, int low, int high) {
		System.out.println("paritionHoare>> Low:" + low + " High>>" + high);
		printArray(arr);
		int pivot = arr[high];
		int i = low;
		int j = high;
		int tmp;

		while (true) {
			
			//find the leftmost greater than equal to pivot
			while (arr[i] < pivot)
				i++;
			//find the rightmost less than or equal to pivot
			while (arr[j] > pivot)
				j--;
              
			//if two pointers met
			if(i>=j)
				return j;
			
			 tmp=arr[j];
			 arr[j]=arr[i];
			 arr[i]=tmp;
			
		}
	}

	static void sort(int arr[], int low, int high) {
		if (low < high) {
			int pIndex = partitionHoare(arr, low, high);
			System.out.println("Partition Index:" + pIndex);
			printArray(arr);
			sort(arr, low, pIndex - 1);
			sort(arr, pIndex + 1, high);
		}

	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
