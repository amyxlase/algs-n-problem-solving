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
		
	//	System.out.println(Arrays.toString(pastures));
				
		// X SLIDER

		TreeSet<coord> ypend = new TreeSet<coord>(new Comparator<coord>() {

			@Override
			public int compare(coord o1, coord o2) {
				return o1.y - o2.y;
			}

		});

		ypend.add(pastures[0]);

		int l = 0;
		int r = 1;
		boolean found = false;
		int ans = 0;

		while (l < N) {
			
			// adjust ypend accordingly
			while (r < N && pastures[r].x < pastures[l].x + K) {
				ypend.add(pastures[r]);
				r++;
			}
			
			//System.out.println("Bounds: " + l + " " + r);
			//System.out.println(pastures[l] + " YPending: " + ypend);

			coord p = pastures[l];

			coord leftNeighbor = ypend.lower(pastures[l]);
			while (leftNeighbor != null && leftNeighbor.y > p.y - K) {
				

				if (found) {

					System.out.println(-1);
					System.exit(0);

				}

				found = true;

				int x = K - (Math.abs(leftNeighbor.x - p.x));
				int y = K - (Math.abs(leftNeighbor.y - p.y));

				ans = x * y;			

				p = leftNeighbor;
				leftNeighbor = ypend.lower(p);

			}

			p = pastures[l];

			coord rightNeighbor = ypend.higher(pastures[l]);
			while (rightNeighbor != null && rightNeighbor.y < p.y + K) {
				

				if (found) {

					System.out.println(-1);
					System.exit(0);

				}

				found = true;

				int x = K - (Math.abs(rightNeighbor.x - p.x));
				int y = K - (Math.abs(rightNeighbor.y - p.y));

				ans = x * y;		

				p = rightNeighbor;
				rightNeighbor = ypend.higher(p);
			}

			ypend.remove(pastures[l]);
			l++;

		}

		System.out.println(ans);

	}

}

class coord implements Comparable<coord> {

	int x, y, step;
	boolean visited;

	public coord(int a, int b) {
		x = a;
		y = b;
		step = 0;
		visited = false;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public boolean equals(Object o) {

		coord other = (coord) o;
		return ((x == other.x) && (y == other.y));

	}

	@Override
	public int compareTo(coord o) {
		return x - o.x;
	}
}
