import java.util.*;

public class crowded {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int D = sc.nextInt();

		cow[] cows = new cow[N];
		for (int i = 0; i < N; i++) {
			cows[i] = new cow(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(cows);
		
		TreeSet<cow> range = new TreeSet<cow>(new Comparator<cow>() {

			@Override
			public int compare(cow o1, cow o2) {
				return o1.h - o2.h;
			}
			
		});

		int l = 0;
		int r = 1;
		
		range.add(cows[0]);

		while (l < N) {

			// add to treeset
			while (r < N && cows[r].x <= cows[l].x + D) {
				range.add(cows[r]);
				r++;
			}
			
	//		System.out.println("Cow: " + cows[l] + " with range " + range);
			
			if (range.size() > 0 && range.last().h >= 2 * cows[l].h) {
				cows[l].right = true;
			}
			
			range.remove(cows[l]);
			l++;

		}
		
		range = new TreeSet<cow>(new Comparator<cow>() {

			@Override
			public int compare(cow o1, cow o2) {
				return o1.h - o2.h;
			}
			
		});
		range.add(cows[N-1]);
		
		r = N - 1;
		l = N - 2;

		while (r >= 0) {

			// add to treeset
			while (l >= 0 && cows[l].x >= cows[r].x - D) {
				range.add(cows[l]);
				l--;
			}
			
//			System.out.println("Cow: " + cows[r] + " with range " + range);

			if (range.size() > 0 && range.last().h >= 2 * cows[r].h) {
				cows[r].left = true;
			}
			
			range.remove(cows[r]);
			r--;

		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (cows[i].left && cows[i].right) {
				ans++;
			}
		}
		
		System.out.println(ans);

	}

}

class cow implements Comparable<cow> {
	int x, h;
	boolean left, right;

	public cow(int a, int b) {
		x = a;
		h = b;
	}

	public String toString() {
		return "(" + x + ", " + h + ")";
	}

	public boolean equals(Object o) {

		cow other = (cow) o;
		return ((x == other.x) && (h == other.h));
	}

	@Override
	public int compareTo(cow o) {
		return x - o.x;
	}
}
