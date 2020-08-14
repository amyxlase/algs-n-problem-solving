import java.util.*;

public class expense {

	public static int N, M;
	public static int[] months;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		months = new int[N];

		int sigma = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			months[i] = sc.nextInt();
			sigma += months[i];
			max = Math.max(max, months[i]);
		}

		int ans = max;
		int l = max;
		int r = sigma;

		while (r >= l) {
			
			if (r == l) {
				System.out.println(r);
				System.exit(0);
			}
			
			int mid = l + (r - l) / 2;

			// System.out.println("Mid: " + mid);

			int index = 0;
			int groupCounter = 1;
			int sum = 0;

			while (index < N) {

				int next = months[index];

				if (sum + next <= mid) {

					sum += next;
					index++;

				} else {

					groupCounter++;
					sum = 0;

					//System.out.println("new group: " + groupCounter);

				}

			}

			if (groupCounter < M) {

				// System.out.println("less than M");

				r = mid - 1;

			} else if (groupCounter > M) {

				 //System.out.println("greater than M" + r);

				l = mid + 1;

			} else {

				ans = mid;
				r = mid;
			}

		}

		System.out.println(ans);
	}

}
