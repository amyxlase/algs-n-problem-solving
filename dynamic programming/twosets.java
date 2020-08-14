import java.util.*;

public class twosets {
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		
		if (sum % 2 == 1) {
			System.out.println(0);
			System.exit(0);
		}		
		sum /= 2;

		long[] dp = new long[sum + 1];
		dp[0] = 1;

		for (int j = 1; j <= n; j++) {
			for (int i = sum; i >= 0; i--) {
				if (dp[i] > 0 && i + j <= sum) {
					dp[i + j]++;
					dp[i+j] = (long) (dp[i+j] % (Math.pow(10, 9) + 7));
				}
			}
		}
		
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[sum]);
	}

}
