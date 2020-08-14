import java.util.*;

public class poker {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] cards = new int[N+2];		
		for (int i = 1; i <= N; i++) {
			cards[i] = sc.nextInt();
		}
		
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			
			if (cards[i] > cards[i-1]) {
				sum += cards[i] - cards[i-1];
			}
			
			if (cards[i] > cards[i+1]) {
				sum += cards[i] - cards[i+1];
			}
			
		}
		
		
		System.out.println(sum/2);
		
		
	}

}
