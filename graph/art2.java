import java.util.*;

public class art2 {

	public static int N;
	public static int[] painting;
	public static int[][] intervals;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		painting = new int[N];
		intervals = new int[N + 1][2];

		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(intervals[i], -1);
		}

		for (int i = 0; i < N; i++) {
			int color = sc.nextInt();
			painting[i] = color;

			if (intervals[color][0] == -1) {
				intervals[color][0] = i;
			}
		}

		for (int i = N - 1; i >= 0; i--) {
			int color = painting[i];

			if (intervals[color][1] == -1) {
				intervals[color][1] = i;
			}
		}

		System.out.println(Arrays.toString(painting));
		System.out.println(Arrays.deepToString(intervals));

	
		Stack<Integer> s = new Stack<Integer>();

		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			

			int color = painting[i];

			if (i == intervals[color][0]) {
				s.add(color);
			}
			System.out.println("Stack: " + s);

			if (i == intervals[color][1]) {

				if (s.peek() != color) {
					
					
					System.out.println(-1);
					System.exit(0);
				
				} else {

					ans = Math.max(s.size(), ans);
					s.pop();
				}
			}

		}

		System.out.println(ans);

	}

}
