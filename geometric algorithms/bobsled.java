import java.util.*;

public class bobsled {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int N = sc.nextInt();

		loc[] course = new loc[N + 1];
		course[0] = new loc(0, 1);
		for (int i = 1; i < N + 1; i++) {
			course[i] = new loc(sc.nextInt(), sc.nextInt());
		}

		int max = 0;
		
		for (int i = 0; i < N; i++) {
			
			loc c1 = course[i];
			loc c2 = course[i + 1];

			c2.speed = Math.min(c2.speed, c1.speed + (c2.x - c1.x));
		}
		
		System.out.println(Arrays.toString(course));
		
		//pelase?
		
	/*	for (int i = N; i > 0; i--) {

			loc c1 = course[i];
			loc c2 = course[i - 1];

			c2.speed = Math.min(c2.speed, c1.speed - (c1.x - c2.x));

		}
		
		System.out.println(Arrays.toString(course)); */


		for (int i = 0; i < N; i++) {

			loc c1 = course[i];
			loc c2 = course[i + 1];

			if (c2.speed > c1.speed) {
				c1 = course[i+1];
				c2 = course[i];
			}

			int maxInRange = c1.speed + (c2.x - c1.x - (c2.speed - c1.speed)) / 2;
			max = Math.max(maxInRange, max);

			System.out.println(maxInRange);

		}

		int last = course[N].speed + (L - course[N].x);

		System.out.println(Math.max(max, last));

		System.out.println(last);

	}

}

class loc implements Comparable<loc> {

	int x, speed;

	public loc(int a, int b) {
		x = a;
		speed = b;
	}

	@Override
	public int compareTo(loc o) {
		return x - o.x;
	}
	
	public String toString() {
		return x + ": " + speed;
	}

}
