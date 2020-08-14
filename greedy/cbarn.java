import java.util.*;

public class cbarn {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] barn = new int[N];

		int min = Integer.MAX_VALUE;
		int start = -1;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			barn[i] = sc.nextInt();

			sum += barn[i] - 1;

			if (sum < min) {
				min = sum;
				start = i;
			}
		}

		start++;

		PriorityQueue<Integer> q = new PriorityQueue<Integer>();

		long totalEnergy = 0;

		for (int i = 0; i < N; i++) {

			int ind = (i + start) % N;

			if (!q.isEmpty()) { // dump a cow

				int n = q.remove();
				totalEnergy += (i - n) * (i - n);

				if (barn[ind] > 0) {
					q.add(i);
				}

			}

			for (int j = 1; j < barn[ind]; j++) { // add cows, if any
				q.add(i);
			}

		//	System.out.println(ind + ": " + q);

		}

		System.out.println(totalEnergy);

	}

}
