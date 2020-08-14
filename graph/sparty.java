import java.util.*;

public class sparty {

	public static int N, M, X;
	public static int[][] adj;
	public static int[] toTime;
	public static int[] fromTime;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt() - 1;

		adj = new int[N][N];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			adj[a][b] = sc.nextInt();
		}

		toTime = dijkstra();
		transpose();
		fromTime = dijkstra();

		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {

			ans = Math.max(ans, toTime[i] + fromTime[i]);
		}

		System.out.println(ans);

	}

	public static int[] dijkstra() {

		PriorityQueue<pair> pq = new PriorityQueue<pair>();
		pq.add(new pair(X, 0));

		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;

		boolean[] visited = new boolean[N];

		while (!pq.isEmpty()) {

			int n = (int) pq.poll().index;

			if (visited[n]) {
				continue;
			}

			for (int i = 0; i < N; i++) {

				int edgeDist = adj[n][i];

				if (edgeDist > 0 && n != i) {

					pq.add(new pair(i, edgeDist));

					if (dist[i] > dist[n] + edgeDist) {
						dist[i] = dist[n] + edgeDist;
					}

				}
			}

			visited[n] = true;

		}

		return dist;

	}

	public static void transpose() {
		int[][] transposed = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				transposed[i][j] = adj[j][i];
			}
		}
		adj = transposed;
	}

}
