package com.learn.sort.insertion;

class InsertionSort1 {

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
		for(int i=0;i<a.length;i++) {
			int j=i;
			int tmp = a[j];
			 
			while(j>0 && tmp<a[j-1]){// move current j to the right
				a[j]=a[j-1];
				j--;
			}	
			a[j]=tmp;	
			System.out.println("\n after pass");
			 display(a);
		  }
		 }
	}


