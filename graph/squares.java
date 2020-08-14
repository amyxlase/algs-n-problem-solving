import java.util.*;

public class squares {

	public static void main(String[] args) {

		// INPUT

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		coord[] pastures = new coord[N];

		for (int i = 0; i < N; i++) {
			pastures[i] = new coord(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(pastures);

		// X SLIDER

		PriorityQueue<Integer> yco = new PriorityQueue<Integer>();

		int l = 0;
		int r = 0;

		// find r
		while (pastures[r].y <= pastures[l].y + K) {
			r++;
		}
		r--;

		// fill ys
		for (int i = l; i < r; i++) {
			yco.add(pastures[i].y);
		}

		// slide through x
		
		while (r < N) {
			
			coord p = pastures[l];

			for (int i = p.y - K; i <= p.y + K; i++) {
				if (yco.contains(i)) {
					
				}
			}
		}

	}

}
