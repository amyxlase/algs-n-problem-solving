import java.util.*;

public class ceating {

	public static int N, D;
	public static int[] choco;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		D = sc.nextInt();
		choco = new int[N];

		long E = 0;

		for (int i = 0; i < N; i++) {
			int c = sc.nextInt();
			choco[i] = c;
			E += c;

		}

		long ans = 0;
		long l = 0;
		long r = E;
		
		System.out.println(l + " " + r);
		
		int counter = 0;

		while (r >= l) {
			
			
			counter++;

			if (r == l) {
				System.out.println(r);
				System.exit(0);
			}

			long mid = l + (r - l) / 2;

			System.out.println("Mid: " + mid + "----------------------------------------");
			System.out.println(l + " "  + r);

			long min = Integer.MAX_VALUE;
			int index = 0;
			int dayCounter = 0;
			long sum = 0;

			while (dayCounter < D) {

				dayCounter++;
				sum = sum / 2;


				while (sum < mid && index < N) {

					int next = choco[index];
					sum += next;
					index++;

					System.out.println("Eating choco valued: " + next);

				}
				
			System.out.println("Day " + dayCounter + " Sum: " + sum);

				min = Math.min(min,  sum);

			}
			
			if (min >= mid) {
				
				System.out.println("equals");
				
				l = mid;
				r--;
				ans = mid;
				
			}else {
				
				System.out.println("smaller");
				r = mid - 1;
				
			} 

		}

		System.out.println(ans);

	}

}
