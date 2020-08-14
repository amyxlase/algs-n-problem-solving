import java.util.*;

public class crazy {

	public static int N, C;
	public static fence[] fences;
	public static ArrayList<fence> flist;
	public static point[] cows;
	public static ArrayList<ArrayList<fence>> regions;
	public static int[] regionCounter;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		C = sc.nextInt();
		fences = new fence[N];
		cows = new point[C];
		flist = new ArrayList<fence>();

		for (int i = 0; i < N; i++) {
			point a = new point(sc.nextInt(), sc.nextInt());
			point b = new point(sc.nextInt(), sc.nextInt());
			fences[i] = new fence(a, b);
			flist.add(fences[i]);
		}

		for (int i = 0; i < C; i++) {
			cows[i] = new point(sc.nextInt(), sc.nextInt());
		}

		regions = new ArrayList<ArrayList<fence>>();

		while (!flist.isEmpty()) {

			findPoly();
		}

		Collections.sort(regions, new Comparator<ArrayList<fence>>() {

			@Override
			public int compare(ArrayList<fence> o1, ArrayList<fence> o2) {

				boolean in1 = true;
				for (int i = 0; i < o1.size(); i++) { // if every point of o1 is in o2
					fence f = o1.get(i);
					if (!inside(f.p1, o2)) {
						in1 = false;
					}
					if (!inside(f.p2, o2)) {
						in1 = false;
					}
				}

				if (in1) {
					return -1;
				}

				boolean in2 = true;
				for (int i = 0; i < o2.size(); i++) { // if every point of o1 is in o2
					fence f = o2.get(i);
					if (!inside(f.p1, o1)) {
						in2 = false;
					}
					if (!inside(f.p2, o1)) {
						in2 = false;
					}
				}

				if (in2) {
					return 1;
				}

				return 0;

			}

		});

		for (int i = 0; i < regions.size(); i++) {
			System.out.println(regions.get(i));
		}
		
		regionCounter = new int[regions.size() + 1];

		boolean[] hasRegion = new boolean[C];

		for (int i = 0; i < regions.size(); i++) {

			for (int j = 0; j < C; j++) {

				if (!hasRegion[j] && inside(cows[j], regions.get(i))) {

					hasRegion[j] = true;
					regionCounter[i]++;
				}

			}
		}

		
	//	System.out.println(Arrays.toString(hasRegion));
		
		for (int i = 0; i < C; i++) {
			
			if (!hasRegion[i]) {

				regionCounter[regions.size()]++;
			}
		}

		//System.out.println("Region Counter: " + Arrays.toString(regionCounter));

		int max = 0;
		for (int i = 0; i < regions.size() + 1; i++) {
			max = Math.max(max, regionCounter[i]);
		}

		System.out.println(max);

	}

	public static void findPoly() {

		ArrayList<fence> reg = new ArrayList<fence>();

		fence f = flist.remove(0);
		reg.add(f);

		boolean first = true;

		fence g = nextFence(f, f.p1);
		point nextPoint = f.connected(g, f.p1);

		while (g != null // && counter < 25
		) {

			reg.add(g);

			if (flist.contains(g)) {
				flist.remove(g);
			}

			if (!first && f.connected(g, f.p2) != null) {
				break;
			}

			fence oldG = g;
			g = nextFence(g, nextPoint);
			nextPoint = oldG.connected(g, nextPoint);

			first = false;

		}

		regions.add(reg);
		System.out.println(reg.size() + ": " + reg);

	}

	public static fence nextFence(fence f, point p) {

		for (int i = 0; i < N; i++) {

			fence g = fences[i];

			if (f.connected(g, p) != null) {
				return g;
			}

		}

		return null;
	}

	public static boolean inside(point cow, ArrayList<fence> r) {

		int counter = 0;

		for (int i = 0; i < r.size(); i++) {

			fence f = r.get(i);

			if (intersect(cow, f)) {
				counter++;
			}

		}

		return (counter % 2 == 1);

	}

	public static boolean intersect(point cow, fence f) {

		point p = new point(Integer.MAX_VALUE, cow.y + 1);

		return ((ccw(cow, p, f.p1) * ccw(cow, p, f.p2) <= 0) && (ccw(f.p1, f.p2, cow) * ccw(f.p1, f.p2, p) <= 0));
	}

	public static int ccw(point a, point b, point c) {
		long dx1 = b.x - a.x;
		long dy1 = b.y - a.y;
		long dx2 = c.x - a.x;
		long dy2 = c.y - a.y;
		if (dx1 * dy2 > dy1 * dx2) {
			return 1;
		}
		if (dx1 * dy2 < dy1 * dx2) {
			return -1;
		}
		if ((dx1 * dx2 < 0) || (dy1 * dy2 < 0)) {
			return -1;
		}
		if ((dx1 * dx1 + dy1 * dy1) < (dx2 * dx2 + dy2 * dy2)) {
			return 1;
		}
		return 0;
	}

}

class point {

	int x, y;

	public point(int a, int b) {
		x = a;
		y = b;
	}

	public boolean equals(Object o) {
		point other = (point) o;
		return (x == other.x && y == other.y);
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}

class fence {

	point p1, p2;

	public fence(point a, point b) {
		p1 = a;
		p2 = b;
	}

	public boolean equals(Object o) {
		fence other = (fence) o;
		return (p1.equals(other.p1) && p2.equals(other.p2));
	}

	public String toString() {
		return p1 + " to " + p2;
	}

	public point connected(fence f, point p) {

		if (!equals(f)) {

			if (p.equals(f.p1)) {
				return f.p2;
			}

			if (p.equals(f.p2)) {
				return f.p1;
			}

		}

		return null;

	}
}
