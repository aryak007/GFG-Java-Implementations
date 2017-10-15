/*

Print matrix in diagonal pattern
Given a matrix of n*n size, the task is to print its elements in diagonally pattern.

Input : mat[3][3] = {{1, 2, 3},
                    {4, 5, 6},
	            {7, 8, 9}}
Output : 1 2 4 7 5 3 6 8 9.
Explanation: We start from 1 
Then from upward to downward diagonally i.e. 2 and 4
Then from downward to upward diagonally i.e 7,5,3 
Then from up to down diagonally i.e  6, 8 
Then down to up i.e. end at 9.

*/

import java.io.*;
import java.util.*;

class GFG{
	public static void main(String args[]) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int mat[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int mat[][] = {{1,  2,  3,  10},
	              {4,  5,  6,  11},
	              {7,  8,  9,  12},
	              {13, 14, 15, 16}};
		GFG g = new GFG();
		g.printDiagonalArray(mat,4);
	}

	public void printDiagonalArray(int mat[][],int n){

		LinkedList<Integer> list = new LinkedList<Integer>();
		int row =0,col=0,line=0;
		for(row = 0;row<n;row++){
			col = 0;
			line = row;
			while(line>=0 && col<n)
			{
				list.add(mat[line][col]);
				line--;
				col++;
			}	
		}
		for(col = 1;col<n;col++){
			line = col;
			row=n-1;
			while(line<n && row>=0){
				list.add(mat[row][line]);
				line++;
				row--;
			}
		}
		Iterator<Integer> i = list.listIterator();
		while(i.hasNext()){
			System.out.print(i.next()+" ");
		}

	}
}