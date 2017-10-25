/*
Given a word and a text, return the count of the occurences of anagrams of the word in the text(For eg: anagrams of word for are for, ofr, rof etc.))

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a text  consisting of only lowercase Latin Letters.
The second line contains a word consisting of only lowercase Latin Letters.

Output:
Print the count of the occurences of anagrams of the word in the text.

Constraints:
1 <= T <= 50
1 <= |word|<= |text| <= 50
here |word| denotes the size of word and |text| denotes the size of text 

Example:
Input:
2
forxxorfxdofr
for
aabaabaa
aaba

Output:
3
4

Explaination:
for, orf and ofr appears in the first test case and hence answer is 3.
*/

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String text = br.readLine();
			String word = br.readLine();
			System.out.println(g.countOccurences(text,word));
		}
	}

	int countOccurences(String text,String word)
	{
		int textLength = text.length();
		int wordLength = word.length();

		if(textLength<wordLength)
			return 0;
		int count = 0;
		char textArray[] = new char[26];
		char wordArray[] = new char[26];
		int i;
		for(i = 0;i<wordLength;i++){
			wordArray[word.charAt(i)-'a']++;
		}

		for(i = 0;i<wordLength;i++)
			textArray[text.charAt(i)-'a']++;

		if(Arrays.equals(textArray,wordArray))
			count++;

		if(textLength==wordLength)
			return count;

		for(i = 0;i<(textLength-wordLength);i++){
			textArray[text.charAt(i)-'a']--;
			textArray[text.charAt(i+wordLength)-'a']++;
			if(Arrays.equals(textArray,wordArray))
				count++;
		}
		return count;
	}
}