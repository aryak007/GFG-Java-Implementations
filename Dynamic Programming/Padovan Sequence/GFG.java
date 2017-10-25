
import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			System.out.println(g.printPadovan(n));

		}
	}

	int printPadovan(int n) {

		int padovan[] = new int[n + 1];
		padovan[0] = padovan[1] = padovan[2] = 1;
		for (int i = 3; i < n + 1; i++) {
			padovan[i] = (padovan[i - 2] + padovan[i - 3]) % 1000000007;
		}
		return padovan[n];
	}
}