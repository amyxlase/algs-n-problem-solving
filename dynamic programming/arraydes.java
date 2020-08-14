import java.util.*;

public class arraydes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] dp = new int[n + 2][m + 2];
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int next = sc.nextInt();
			arr[i] = next;
			dp[i][next] = 1;
		}

		for (int i = 1; i <= n; i++) {
			if (arr[i] > 0) {
				//mark the three
			}
		}

	}

}
