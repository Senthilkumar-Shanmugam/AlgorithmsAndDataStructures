package com.learn.sort.selectionsort;

public class SelectionSort {

	public static void main(String[] args) {
     //   int [] input = {62,25,12,22,11};
		int [] input = {7,4,5,2};
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
	
	
	private static void sort(int[] a){
		
		for(int i=0;i<a.length-1;i++){
			int minp = i;
			for(int j=i+1;j<a.length;j++){
			  if(a[minp]>a[j])
				  minp=j;
			}
			  //swap,select minimum to the brining at each pass
			  int tmp = a[minp];
			  a[minp] = a[i];
			  a[i]=tmp;
			}
		}
	}


