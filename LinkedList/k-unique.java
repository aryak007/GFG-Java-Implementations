import java.io.*;
import java.util.*;

boolean isValid(int count[],int k){
	int val = 0;
    for (int i=0; i<count.length; i++)
        if (count[i] > 0)
            val++;
 
    // Return true if k is greater than or equal to val
    return (k >= val);
}


void findUnique(String s, int k){
	int u = 0;
	int n = s.length();

	int count[] = new int[26];

	for(int i=0;i<n;i++){
		if(count[(int)(s.charAt(i))-(int('a'))] == 0)
			u++;
		count[(int)(s.charAt(i))-(int('a'))]++;
	}

	if(u<k)
		return;

	int start = 0;
	int end = 0;

	int window = 0;
	int start_window = 0;

	count = {0};
	count[(int)(s.charAt(0))-(int('a'))]++;

	for(int i=0;i<n;i++){
		count[(int)(s.charAt(i))-(int('a'))]++;
		end++;

		while(!isValid(count,k)){
			count[str.charAt(start)-(int('a'))]--;
			start++;
		}

		if(end+1>start)
		{
			window = end - start +1;
			start_window= start;
		}
	}
}
