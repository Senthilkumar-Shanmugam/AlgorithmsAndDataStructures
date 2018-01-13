package com.learn.sorting.bubblesort;

public class BubbleSort {
	public static void main(String[] args) {
	     int [] input = {62,25,12,22,11};
			//int [] input = {7,4,5,2};
	        System.out.println("Before");
	        display(input);
	        sort(input);
	        System.out.println("After");
	        display(input);
		}
		
		private static void display(int []a){
			for( int e : a)
				System.out.print(e+" ");
		}
		
		
		private static void sort( int A[ ]) {
		    int temp;
		    int n=A.length;
		    for(int k = 0; k< n-1; k++) {
		        // (n-k-1) is for ignoring comparisons of elements which have already been compared in earlier iterations

		        for(int i = 0; i < n-k-1; i++) {
		            if(A[ i ] > A[ i+1] ) {
		                // here swapping of positions is being done.
		                temp = A[ i ];
		                A[ i ] = A[ i+1 ];
		                A[ i + 1] = temp;
		            }
		        }
		    }
		}		}
		

