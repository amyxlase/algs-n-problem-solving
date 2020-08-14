import java.util.Arrays;
import java.util.Scanner;


//need to optimize; o(n^3) not gonna work
 
public class coincombo2 {
	
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int[] values = new int[n];
		long[][] dp = new long[sum + 1][n];
 
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
			values[i] = sc.nextInt();
			
		}
		
		
		for (int i = 1; i <= sum; i++) {
			
			for (int j = 0; j < n; j++) {
				
				if (i - values[j] > 0) {
					
					
					for (int k = 0; k <= j; k++) {
						dp[i][j] += dp[i-values[j]][k];
					}
					
				}
				
				if (i - values[j] == 0) {
					dp[i][j] = 1;
				}
				
				dp[i][j] = (long) (dp[i][j] % (Math.pow(10, 9) + 7));
				
			}
		
			
		}
		
		for (int i = 0; i < n - 1; i++) {
			dp[sum][n-1] += dp[sum][i];
		}
		
		//print(dp);
		
		System.out.println(dp[sum][n - 1]);
	
	}
	
	public static void print(long[][] a) {
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
 
}