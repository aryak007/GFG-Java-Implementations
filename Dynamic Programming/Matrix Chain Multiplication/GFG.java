import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(g.MatrixChainOrder(arr, n));

		}
	}

	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	static int MatrixChainOrder(int arr[], int n) {
		int temp[][] = new int[n][n];
		int brackets[][] = new int[n][n];
		int q = 0;
		for (int l = 2; l < n; l++) {
			for (int i = 0; i < n - l; i++) {
				int j = i + l;
				temp[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					q = temp[i][k] + temp[k][j] + arr[i] * arr[k] * arr[j];
					if (q < temp[i][j]) {
						temp[i][j] = q;
						brackets[i][j] = k;
					}
				}
			}
		}
		for(int i =0;i<n;i++){
			for(int j = 0;j<n;j++){
				System.out.print(brackets[i][j]+" ");
			}
			System.out.println();
		}
		return temp[0][n - 1];
	}
}

