import java.util.*;

public class ccski {

	public static int M, N;
	public static int[][] grid;
	public static int[][] wp;
	public static boolean[][] visited;
	public static int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	public static int firstX = -1;
	public static int firstY = -1;
	public static int iwpcounter = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		grid = new int[M][N];
		wp = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				wp[i][j] = sc.nextInt();

				if (wp[i][j] == 1) {
					firstX = i;
					firstY = j;
				}

			}
		}

		int dmin = 0, dmax = 1000000000;

		while (dmin < dmax) {

			int d = (dmin + dmax) / 2;
			visited = new boolean[M][N];
			floodfill(d);

			if (reached()) {
				// System.out.println("works!");
				dmax = d;
			} else {

				// System.out.println("doenst work");
				dmin = d + 1;
			}
		}

		System.out.println(dmin);

	}

	public static void floodfill(int n) {

		LinkedList<int[]> q = new LinkedList<int[]>();

		int[] firstco = { firstX, firstY };
		q.offer(firstco);

		while (!q.isEmpty()) {

			int x = ((int[]) q.peek())[0];
			int y = ((int[]) q.poll())[1];
			
			for (int i = 0; i < 4; i++) {

				int xnew = x + dir[i][0];
				int ynew = y + dir[i][1];

				if (xnew < 0 || ynew < 0 || xnew >= M || ynew >= N) {
					continue;
				}

				if (!visited[xnew][ynew]) {
					if (Math.abs(grid[x][y] - grid[xnew][ynew]) <= n) {
						int[] coo = { xnew, ynew };
						q.add(coo);
						visited[xnew][ynew] = true;

					}
				}

			}
		}
	}

	public static boolean reached() {
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				if (wp[i][j] == 1 && !visited[i][j])
					return false;
		
		return true;
	}

}