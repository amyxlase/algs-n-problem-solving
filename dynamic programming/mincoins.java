import java.util.*;

public class mincoins {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int sum = sc.nextInt();
		int[] values = new int[n];

		int[] dp = new int[sum + 1];

		for (int i = 0; i < n; i++) {
			values[i] = sc.nextInt();

			if (values[i] <= sum) {
				dp[values[i]] = 1;
			}
		}

		dp[0] = 1;

		for (int i = 1; i <= sum; i++) {

			for (int j = 0; j < n; j++) {

				if (i - values[j] >= 0) {

					if (dp[i] == 0) {
						dp[i] = dp[i - values[j]] + 1;
					} else {
						dp[i] = Math.min(dp[i], dp[i - values[j]] + 1);
					}
				}

			}

		}
		
		if (dp[sum] == 0) {
			dp[sum] = -1;
		}

		System.out.println(dp[sum]);
	}

}
