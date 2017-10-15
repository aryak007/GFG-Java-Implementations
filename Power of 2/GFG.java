/*
Given two strings S1 and S2 as input, the task is to merge them alternatively.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two strings S1 and S2.

Output:
For each test case, print the merged string in new line.

Constraints:
1<=T<=100
1<=|strings length|<=104

Example:
Input:
2
Hello Bye
abc def

Output:
HBeylelo
adbecf
*/
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException{
        GFG g = new GFG();        
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            g.printMergedString(st.nextToken(),st.nextToken());
        }

    }
    void printMergedString(String str1,String str2){
        int i =0,j=0;
        String res = "";
        while(i<str1.length() && j<str2.length()){
            res = res+str1.charAt(i);
            res = res+str2.charAt(j);
            i++;
            j++;
        }
        if(i<str1.length()){
            while(i<str1.length()){
                res = res+str1.charAt(i);
                i++;
            }
        }
        if(j<str2.length()){
            while(j<str2.length()){
                res = res+str2.charAt(i);
                j++;
            }
        }
        System.out.println(res);
    }

}
