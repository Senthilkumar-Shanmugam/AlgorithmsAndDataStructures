package com.learn.sort.quicksort;

/**
 * my UNDERSTANDING: 
 * Quicksort starts with partitioning as the first step as opposed to mergesort where merge 
 * is called as the last step after recursive divide.
 * 
 * Last Element as pivot:{ei < p < en).. at each invocation
 *    places the pivot in its rightful position by the following logic 
 * 
 *  iterate through the array.. start pIndex as beginning of the array
 *   compare a(j) <= pivot if yes swap it with element larger than pivot.
 *   this way larger element moves frd.less elements comes left.
 *   Finally pivot is swapped with pIndex.. at the end the invariant is maintained
 *   
 *   then problem(unsorted array is divided into sub problems) and solved 
 * 
 *   
 * @author seshshan
 *
 */
public class QuickSort
{
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int arr[], int low, int high)
    {
    	System.out.println("Low>>"+low+" High>>"+high);
    	printArray(arr);
        int pivot = arr[high]; 
        System.out.println("pivot:"+pivot);
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
     int partitionFirstAsPivot(int arr[],int low,int high){
    	 System.out.println("Start:"+low+" End:"+high);
    	 printArray(arr);
    	 int pivot=arr[low];
    	 int pIndex=low+1;
    	 
    	 for(int i=low+1;i<=high;i++){
    		 if(arr[i]<pivot){
    			 int tmp = arr[pIndex];
    			 arr[pIndex] = arr[i];
    			 arr[i] = tmp;
    			 pIndex++;
    		 }
    	 }
    	 arr[low]=arr[pIndex-1];
    	 arr[pIndex-1]=pivot;
    	 return pIndex-1;
     }
 
     int partitionLastAsPivot(int []arr,int low,int high){
    	 System.out.println("Start:"+low+" End:"+high);
    	 printArray(arr);
    	 int pivot = arr[high];
    	 int pIndex = low;
    	 System.out.println("Pivot:"+pivot);
    	 
    	 for(int i=low;i<high;i++){
    		 if(arr[i]<=pivot){
    			 int tmp = arr[i];
    			 arr[i] = arr[pIndex];
    			 arr[pIndex] = tmp;
    			 pIndex++;
    		 }
    	 }
    	 //swap the big element with pivot
		 arr[high]=arr[pIndex];
		 arr[pIndex]=pivot;
		 return pIndex;
     }
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {
    	
    	System.out.println("Recursive : start"+low+" End:"+high);
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
        	
            //int pi = partition(arr, low, high);
        	//int pi=partitionLastAsPivot(arr, low, high);
        	int pi=partitionFirstAsPivot(arr, low, high);
             System.out.println(" Partition index:"+pi);
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
 
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
 
    // Driver program
    public static void main(String args[])
    {
        int arr[] = //{10,80,30,90,40,50,70};
        		{32,25,65,8,40,78,12,6};
        int n = arr.length;
 
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);
 
        System.out.println("sorted array");
        printArray(arr);
    }
}
