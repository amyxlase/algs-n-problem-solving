import java.util.*;

public class bookshop {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int[][] books = new int[n][2];
		int[] dp = new int[sum+1];
		
		
		for (int i = 0; i < n; i++) { 
			books[i][0] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			books[i][1] = sc.nextInt();
		}
		
		dp[0] = 1;
		
		int interimSum = 0;
		for (int book = 0; book < n; book++) {	
			interimSum += books[book][0];
			
			for (int i = sum; i >= 0; i--) {
				
				if (i < interimSum && dp[i] > 0 && i + books[book][0] <= sum) {
					
					if (i == 0) {
						dp[i] = 0;
					}
					
					//System.out.println(books[book][0] + "  " + i);
					dp[i + books[book][0]] = Math.max(dp[i + books[book][0]], dp[i] + books[book][1]);
					
					if (i == 0) {
						dp[i] = 1;
					}
					
				}
				
			}	
			
			//System.out.println(Arrays.toString(dp));

			
			/*if (books[book][0] <= sum) {
				
				dp[books[book][0]] = Math.max(dp[books[book][0]], books[book][1]);
				
				
			} */
		}
		
		int ans = 0;
		for (int i = 1; i <= sum; i++) {
			ans = Math.max(ans, dp[i]);
		}		
		
		System.out.println(ans);
		
	}

}
