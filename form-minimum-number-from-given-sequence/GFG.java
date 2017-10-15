import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    GFG g = new GFG();
	    while(t-->0){
	    	String str = br.readLine();
	    	g.printMinimumNumberSequence(str);
	    }
	}
	public void printMinimumNumberSequence(String str){
		Deque<Integer> dequeue = new LinkedList<Integer>();
		String res = "";
		for(int i =0;i<=str.length();i++){
			dequeue.addFirst(i+1);
			if(i==str.length()||str.charAt(i)=='I'){
				while(!dequeue.isEmpty()){
					res = res+dequeue.removeFirst();
				}
			}
		}
		System.out.println(res);
	}
}