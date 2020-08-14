import java.util.*;

public class dream {

	public static int N, M;
	public static int[][] grid;
	public static boolean[][] visited;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		grid = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				grid[i][j] = sc.nextInt();
			}
		}

		LinkedList<cell> q = new LinkedList<cell>();
		cell start = new cell(0, 0, grid[0][0], 0);
		if (start.v == 2) {
			start.o = true;
		}
		q.add(start);

		while (!q.isEmpty()) {

			// System.out.println(q);

			cell c = q.poll();

			if (c.x == N - 1 && c.y == M - 1) {

				System.out.println(c.dist);
				System.exit(0);

			}

			if (c.v == 4 && c.di != -1) {
				
				int xnew = c.x + dir[c.di][0];
				int ynew = c.y + dir[c.di][1];

				if (!(xnew >= 0 && xnew < N && ynew >= 0 && ynew < M)) {
					continue;
				}

				int value = grid[xnew][ynew];
				
				if (value == 0 || (value == 3 && !c.o)) {
					continue;
				}
				
				

			} else {

				for (int i = 0; i < 4; i++) {

					int xnew = c.x + dir[i][0];
					int ynew = c.y + dir[i][1];

					if (!(xnew >= 0 && xnew < N && ynew >= 0 && ynew < M)) {
						continue;
					}

					int value = grid[xnew][ynew];
					cell cnew = new cell(xnew, ynew, value, c.dist + 1);

					if (value == 0) {
						continue;
					} else if (value == 2) {
						cnew.o = true;
					} else if (value == 3 && !c.o) {
						continue;
					} else if (value == 4) {
						cnew.o = false;
						cnew.di = i;
					}

					q.add(cnew);

				}
			}

		}

		System.out.println(-1);
		System.exit(0);

	}

}

class cell {

	int x, y, v;
	boolean o;
	int di;
	int dist;

	public cell(int a, int b, int c, int d) {
		x = a;
		y = b;
		v = c;
		dist = d;
	}

	public String toString() {
		return "(" + x + ", " + y + "): " + v;
	}

}
