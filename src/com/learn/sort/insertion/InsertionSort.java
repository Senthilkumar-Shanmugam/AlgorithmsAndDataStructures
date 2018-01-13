package com.learn.sort.insertion;

public class InsertionSort {

	public static void main(String[] args) {
           int [] input = {62,25,12,22,11};
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
	
	private static void sort(int []a){
		
		for(int i=0;i<a.length;i++){
			int tmp = a[i];
			int j=i;
			
			while(j>0 &&  tmp < a[ j -1])
			{
				a[j]=a[j-1];
				j--;
			}
			a[j]=tmp;
			
		}
	}

}
