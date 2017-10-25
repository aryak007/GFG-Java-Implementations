import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int arr[][] = new int[m][n];

			System.out.println(g.uniquePaths(arr, m, n));

		}
	}
	int uniquePaths(int arr[][], int m, int n) {


		int i = 0, j = 0;
		for (i = 0; i < m; i++)
			arr[i][0] = 1;
		for (i = 0; i < n; i++)
			arr[0][i] = 1;

		for (i = 1; i < m; i++) {
			for (j = 1; j < n; j++) {
				arr[i][j] = arr[i-1][j]+arr[i][j-1];
			}
		}
		return arr[m-1][n-1];
	}
}

