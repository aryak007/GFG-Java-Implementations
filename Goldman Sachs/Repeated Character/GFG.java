/*
Given a string - "str", find the repeated character present first in the string.

Example : 
Input  :  geeksforgeeks
Output :  g
          (mind that it will be g, not e.)

Input : 
The first line of input contains an integer T denoting the Test cases. Then T test cases follow. 
Second line contains the string - "str"

Output : 
repeated character present first in the string, if present
otherwise print "-1"


Input : 
3
hello
fg
geeksforgeeks

Output : 
l
-1
g

** For More Input/Output Examples Use 'Expected Output' option **

*/
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException{
        GFG g = new GFG();
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String input = br.readLine();
            g.findFirstRepeatedChar(input);
            
        }
    }

    public void findFirstRepeatedChar(String str){
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        boolean flag = false;
        int indexFirstSoFar = -1;
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){

                if(indexFirstSoFar>map.get(str.charAt(i)) || indexFirstSoFar==-1)
                    indexFirstSoFar = map.get(str.charAt(i));
            }
            else{
                map.put(str.charAt(i),i);
            }
        }
        if(indexFirstSoFar!=-1)
            System.out.println(str.charAt(indexFirstSoFar));
        else
            System.out.println(indexFirstSoFar);
        
    }

}
