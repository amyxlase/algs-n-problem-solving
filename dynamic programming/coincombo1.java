import java.util.Arrays;
import java.util.Scanner;
 
public class coincombo1 {
	
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int[] values = new int[n];
		
		for (int i = 0; i < n; i++) {
			values[i] = sc.nextInt();
		}
 
		long[] dp = new long[sum + 1];
		
		dp[0] = 1;
 
		for (int i = 1; i <= sum; i++) {
			
			for (int j = 0; j < n; j++) {
				
				if (i - values[j] >= 0) {
 
					
					dp[i] += dp[i - values[j]];
					
					
				}
			
			}
			
			dp[i] = (long) (dp[i] % (Math.pow(10, 9) + 7));
			
		}
		
 
		
		System.out.println(dp[sum]);
		
		
	}
}