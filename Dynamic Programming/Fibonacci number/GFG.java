/*

*/

import java.io.*;
import java.util.*;

class GFG{
	public static void main(String args[]) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int mat[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		GFG gfg = new GFG();
		System.out.println(gfg.printFibonacciTabulation(40));
		int fib[] = new int[41];
		System.out.println(gfg.printFibonacciMemoization(fib,40));
	}

	int printFibonacciTabulation(int n){

		int fib[] = new int[n+1];
		fib[0]=0;
		fib[1]=1;
		for(int i=2;i<n+1;i++){
			fib[i] = fib[i-1]+fib[i-2];
		}
		return fib[n];
	}

	int printFibonacciMemoization(int fib[],int n){
		if(n<=1)
			fib[n] = n;
		else{
			fib[n] = printFibonacciMemoization(fib,n-1)+printFibonacciMemoization(fib,n-2);
		}
		return fib[n];
	}

	
}