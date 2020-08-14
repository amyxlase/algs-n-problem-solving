import java.util.*;

public class skyline {

	public static int N, W;
	public static int[][] moves;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		W = sc.nextInt();
		moves = new int[N][2];
		for (int i = 0; i < N; i++) {
			moves[i][0] = sc.nextInt();
			moves[i][1] = sc.nextInt();
		}

		Stack<Integer> buildings = new Stack<Integer>();
		int prev = moves[0][1];
		if (prev != 0) {
			buildings.add(prev);
		}
		int ans = 0;

		for (int i = 1; i < N; i++) {

			//System.out.println(buildings);

			int y = moves[i][1];

			if (y > prev) {
				buildings.add(y);
			}

			if (y < prev) {

				if (buildings.pop() != 0) {
					ans++;
				}

				while (!buildings.isEmpty() && y < buildings.peek()) {
					
					int b = buildings.pop();
					if (b != 0) {
						
						//System.out.println("Popping " + b);
						ans++;
					}
				}

				if ((!buildings.isEmpty() && y > buildings.peek()) || buildings.isEmpty()) {
					buildings.add(y);
				}

			}

			prev = y;
		}
		
		int interim = buildings.size();
		
		if (buildings.contains(0)) {
			interim--;
		}

		System.out.println(ans + interim);

	}

}
