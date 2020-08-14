
import java.util.*;

public class moneysums {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] coins = new int[n];

		int sum = 0;
		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
			sum += coins[i];
		}

		boolean[] dp = new boolean[sum + 1];

		dp[0] = true;

		for (int j = 0; j < n; j++) {
			for (int i = sum; i >= 0; i--) {
				if (dp[i] && i + coins[j] <= sum) {
					dp[i + coins[j]] = true;
				}
			}
		}

		int ans = 0;
		String print = "";
		for (int i = 1; i <= sum; i++) {
			if (dp[i]) {
				ans++;
				print = print + " " + i;
			}
		}

		System.out.println(ans);
		System.out.println(print.substring(1));
	}

}
