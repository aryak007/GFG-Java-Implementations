import java.util.*;
import java.io.*;

class Test {
	public static void main (String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Test g = new Test();
		String str = br.readLine();
		StringBuilder sb = new StringBuilder(str);
		System.out.println(g.findStringOptimised(sb,k));
	}
	String findString(StringBuilder str,int k){
		StringBuilder x = new StringBuilder();
		while(str.length()>0){
			char smallest = str.charAt(0);
			int pos = 0;
			for(int i = 1;i<k && i<str.length();i++){
					if (str.charAt(i) < smallest) {
	                	smallest = str.charAt(i);
	                	pos = i;
	            }
			}
			x.append(smallest);

	        str.deleteCharAt(pos);
		}
		return x.toString();
	}
	String findStringOptimised(StringBuilder str,int k){
		//StringBuilder x = new StringBuilder();
		int startPos = 1;
		while(startPos<=str.length()){
			char smallest = str.charAt(startPos-1);
			int pos = startPos-1;
			for(int i = startPos;i<(k+startPos-1) && i<str.length();i++){
					if (str.charAt(i) < smallest) {
	                	smallest = str.charAt(i);
	                	pos = i;
	            }
			}
			// System.out.println(startPos);
			// System.out.println(smallest+" small" +" pos"+pos);
			char ch = str.charAt(startPos-1);
			str.setCharAt(startPos-1,smallest);
			str.setCharAt(pos,ch);
			//System.out.println(str.toString());
			startPos++;
			//x.append(smallest);

	        //str.deleteCharAt(pos);
		}
		return str.toString();
	}
}
