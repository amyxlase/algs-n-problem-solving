import java.util.*;

public class gridpaths {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[][] grid = new int[n][n];
		long[][] dp = new long[n][n];

		for (int i = 0; i < n; i++) {

			String line = sc.nextLine();
			String[] chr = line.split("");

			for (int j = 0; j < n; j++) {
				if (chr[j].equals("*")) {
					grid[i][j] = 1;
				}
			}
		}

		if (grid[0][0] != 1) {
			dp[0][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (grid[i][j] == 0) {

					if (i - 1 >= 0) {
						dp[i][j] += dp[i - 1][j];
					}

					if (j - 1 >= 0) {
						dp[i][j] += dp[i][j - 1];
					}

				}

				dp[i][j] = (long) (dp[i][j] % (Math.pow(10, 9) + 7));

			}
		}

		// System.out.println(Arrays.deepToString(dp));

		System.out.println(dp[n - 1][n - 1]);

	}

}
