/*
Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given sequence.

Note: No two strings are the second most repeated, there will be always a single string.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting number of strings in a sequence and the second line contains N space separated strings.

Output:
For each test case, in a new line print the second most repeated string.

Constraints:
1<=T<=100
3<=N<=103
1<=|String length|<=100

Example:
Input:
2
6
aaa bbb ccc bbb aaa  aaa
6
geeks for geeks for geeks aaa

Output:
bbb
for
*/
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException{
        GFG g = new GFG();
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            String[] strArray = new String[n];
            //String input = br.readLine().trim();
            //input = input+" ";
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0;i<n;i++){
                strArray[i] = st.nextToken().trim();
            }
            g.secondMostRepeatedString(strArray,n);
            
        }
    }

    public void secondMostRepeatedString(String strArray[],int n){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<n;i++){

            if(map.containsKey(strArray[i])){
                //System.out.println(strArray[i]);
                map.put(strArray[i].trim(),map.get(strArray[i])+1);
            }
            else{
                 map.put(strArray[i].trim(),1);
            }
        }
        String largestKey = "";
        int largestValue = Integer.MIN_VALUE;
        int secondLargestValue = -1;
        String secondLargestKey = "";
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                //System.out.println(entry.getKey()+ " "+entry.getValue());
                if(entry.getValue()>largestValue)
                {
                    largestValue = entry.getValue();
                    largestKey = entry.getKey();
                }
        }
        map.put(largestKey,Integer.MIN_VALUE);

        for(Map Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue()>secondLargestValue)
            {
                secondLargestKey = entry.getKey();
                secondLargestValue = entry.getValue();
            }
        }
        System.out.println(secondLargestKey);
        
    }

}
