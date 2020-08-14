import java.util.*;
import java.io.*;

public class pwrfail {

	public static int N, W;
	public static double M;
	public static pole[] poles;
	public static double[][] adj;
	public static double[] dist;
	public static PriorityQueue<pair> pq;
	public static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		W = sc.nextInt();
		M = sc.nextDouble();
		poles = new pole[N];
		adj = new double[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(adj[i], -1.0);
		}

		dist = new double[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq = new PriorityQueue<pair>();

		for (int i = 0; i < N; i++) {

			poles[i] = new pole(i, sc.nextInt(), sc.nextInt());
		}

		for (int i = 0; i < W; i++) {

			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			adj[a][b] = 0;
			adj[b][a] = 0;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				double dx = Math.abs(poles[i].x - poles[j].x);
				double dy = Math.abs(poles[i].y - poles[j].y);
				double d = Math.hypot(dx, dy);

				if (adj[i][j] == -1 && d <= M) {
					adj[i][j] = d;
				}
			}
		}

		// printa();

		pq.add(new pair(0, 0.0));
		dist[0] = 0;

		while (!pq.isEmpty()) {

			// System.out.println(pq);
			int n = (int) pq.poll().index;

			if (visited[n]) {
				continue;
			}

			// visit all neighbors
			for (int i = 0; i < N; i++) {

				// System.out.println("node " + n + " // i " + i);

				double edgeDist = adj[n][i];

				if (edgeDist != -1.0 && n != i && edgeDist <= M) {

					// add to pq
					pq.add(new pair(i, adj[n][i]));

					// update dist array
					dist[i] = Math.min(dist[i], dist[n] + edgeDist);

				}
			}

			visited[n] = true;

		}

		// System.out.println(Arrays.toString(dist));

		if (dist[N - 1] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {

			System.out.println((int) (dist[N - 1] * 1000));
		}

	}

	public static void printa() {

		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(adj[i]));
		}

	}

}

class pole {

	int index, x, y;

	public pole(int i, int a, int b) {
		index = i;
		x = a;
		y = b;
	}
}


