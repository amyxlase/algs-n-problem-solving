import java.util.*;

public class wall {

	public static int H, F;
	public static coord[] footholds;
	public static ArrayList<coord> start;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		H = sc.nextInt();
		F = sc.nextInt();
		footholds = new coord[F];
		ArrayList<coord> start = new ArrayList<coord>();

		for (int i = 0; i < F; i++) {
			footholds[i] = new coord(sc.nextInt(), sc.nextInt());

			if (footholds[i].y <= 1000) {
				start.add(footholds[i]);
			}

		}

		Arrays.sort(footholds, new Comparator<coord>() {

			@Override
			public int compare(coord o1, coord o2) {
				return o1.x - o2.x;
			}

		});

		// System.out.println(Arrays.toString(footholds));
		// System.out.println(start);

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < start.size(); i++) {

			int b = bfs(start.get(i));

			if (b != -1) {
				ans = Math.min(ans, b);
			}
		}

		System.out.println(ans);

	}

	public static int bfs(coord c) {

		boolean[] visited = new boolean[F];

		LinkedList<coord> list = new LinkedList<coord>();
		c.step = 1;
		list.add(c);

		while (!list.isEmpty()) {

			// System.out.println(list);

			coord co = list.remove();

			if (co.visited) {
				continue;
			}
			co.visited = true;

			if (co.y + 1000 >= H) {
				return co.step;
			}

			int s = binarySearch(co.x - 1000);
			int e = binarySearch(co.x + 1000);

			// System.out.println(s);
			// System.out.println(e);

			for (int i = s; i <= e; i++) {

				int a = Math.abs(co.x - footholds[i].x);
				int b = Math.abs(co.y - footholds[i].y);

				if (Math.hypot(a, b) <= 1000 && !footholds[i].visited && !list.contains(footholds[i])) {

					footholds[i].step = co.step + 1;
					list.add(footholds[i]);
				}
			}

		}

		return -1;

	}

	// check that indices work out here
	public static int binarySearch(int target) {

		int l = 0;
		int r = F - 1;

		while (l < r) {

			int m = l + (r - l) / 2;

			if (footholds[m].x > target) {
				r = m - 1;
			}

			if (footholds[m].x < target) {
				l = m + 1;
			}

			if (footholds[m].x == target) {
				r = m;
			}

		}

		return l;

	}

}
