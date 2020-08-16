import java.util.*;

public class split {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		integer[][] coords = new integer[N][2];

		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;

		TreeSet<integer> leftX = new TreeSet<integer>();
		TreeSet<integer> rightX = new TreeSet<integer>();
		TreeSet<integer> leftY = new TreeSet<integer>();
		TreeSet<integer> rightY = new TreeSet<integer>();

		TreeSet<integer> upX = new TreeSet<integer>();
		TreeSet<integer> downX = new TreeSet<integer>();
		TreeSet<integer> upY = new TreeSet<integer>();
		TreeSet<integer> downY = new TreeSet<integer>();

		for (int i = 0; i < N; i++) {
			coords[i][0] = new integer(sc.nextInt(), i);
			coords[i][1] = new integer(sc.nextInt(), i);

			maxX = Math.max(maxX, coords[i][0].n);
			maxY = Math.max(maxY, coords[i][1].n);
			minX = Math.min(minX, coords[i][0].n);
			minY = Math.min(minY, coords[i][1].n);

			rightX.add(coords[i][0]);
			rightY.add(coords[i][1]);

			downX.add(coords[i][0]);
			downY.add(coords[i][1]);

		}

		long orgArea = (maxX - minX) * (maxY - minY);
		long minArea = orgArea;

		// vertical sweep line

		Arrays.sort(coords, new Comparator<integer[]>() {

			@Override
			public int compare(integer[] o1, integer[] o2) {
				return o1[0].n - o2[0].n;
			}

		});
		
	//	System.out.println(Arrays.deepToString(coords));

		for (int i = 0; i < N - 1; i++) {

			leftX.add(coords[i][0]);
			leftY.add(coords[i][1]);

			rightX.remove(coords[i][0]);
			rightY.remove(coords[i][1]);

			/*System.out.println(leftX);
			System.out.println(leftY);
			System.out.println(rightX);
			System.out.println(rightY); */

			long leftArea = (leftX.last().n - leftX.first().n) * (leftY.last().n - leftY.first().n);
			long rightArea = (rightX.last().n - rightX.first().n) * (rightY.last().n - rightY.first().n);
			minArea = Math.min(minArea, Math.abs(leftArea + rightArea));
		}

		// System.out.println(minArea);

		// horizontal sweep line

		Arrays.sort(coords, new Comparator<integer[]>() {

			@Override
			public int compare(integer[] o1, integer[] o2) {
				return o1[1].n - o2[1].n;
			}

		});

		for (int i = 0; i < N - 1; i++) {

			upX.add(coords[i][0]);
			upY.add(coords[i][1]);

			downX.remove(coords[i][0]);
			downY.remove(coords[i][1]);

			long upArea = (upX.last().n - upX.first().n) * (upY.last().n - upY.first().n);
			long downArea = (downX.last().n - downX.first().n) * (downY.last().n - downY.first().n);
			minArea = Math.min(minArea, Math.abs(upArea + downArea));
		}
		// System.out.println(minArea);

		System.out.println(orgArea - minArea);

	}

}

class integer implements Comparable<integer>{

	int n, i;

	public integer(int a, int b) {
		n = a;
		i = b;
	}

	public boolean equals(Object o) {

		integer other = (integer) o;

		return (n == other.n) && (i == other.i);

	}

	@Override
	public int compareTo(integer o) {
		
		if (n == o.n) {
			return i - o.i;
		}
		
		return n - o.n;
	}
	
	public String toString() {
		return n + ": " + i;
	}
}
