import java.util.*;

public class rplow2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		int Y = sc.nextInt();
		int I = sc.nextInt();

		p[] points = new p[2 * I];

		for (int i = 0; i < I; i++) {

			points[i] =  new p(sc.nextInt() - 1, sc.nextInt() - 1, i, true);
			points[i+I] = new p(sc.nextInt() - 1, sc.nextInt() - 1, i, false);
		}

		Arrays.sort(points);
		
		boolean[] on = new boolean[I];

		int ans = 0;
 
		for (int i = 0; i < 2 * I; i++) {
			
			
			
			
			
			
		}

		System.out.println(ans);

	}

}

class p implements Comparable<p> {

	int x, y, i; boolean start;

	public p(int a, int b, int c, boolean d) {
		x = a;
		y = b;
		i = c;
		start = d;
	}

	@Override
	public int compareTo(p o) {
		if (x > o.x) {
			return 1;
		} else if (x < o.x) {
			return -1;
		} else {
			return y-o.y;
		}
	}
	
	

}
