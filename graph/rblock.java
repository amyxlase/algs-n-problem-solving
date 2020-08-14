import java.util.*;

public class rblock {

	public static int N;
	public static int M;
	public static int[][] adj;
	public static int[] prev;

	public static void main(String[] args) {

		// input

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		adj = new int[N][N];
		prev = new int[N];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;

			adj[a][b] = sc.nextInt();
			adj[b][a] = adj[a][b];
		}
		

		int org = findPath();
		
		//System.out.println(Arrays.toString(prev));

		// find maximum shortest path

		int node = N - 1;
		int ans = -1;
		int counter = 0;

		while (node != 0 //&& counter < 5
				) {
			
			//System.out.println(node + " " + prev[node]);
			
			adj[node][prev[node]] *= 2;
			adj[prev[node]][node] *= 2;
	
			ans = Math.max(ans, dijkstra());
			
			adj[node][prev[node]] /= 2;
			adj[prev[node]][node] /= 2;
			
			node = prev[node];
			
			counter++;

		}

		System.out.println(ans - org);
	}

	public static int findPath() {

		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;


		boolean[] visited = new boolean[N];

		PriorityQueue<pair> pq = new PriorityQueue<pair>();
		pq.add(new pair(0, 0));

		while (!pq.isEmpty()) {
			

			int n = (int) pq.poll().index;

			if (visited[n]) {
				continue;
			}

			for (int i = 0; i < N; i++) {

				int edgeDist = adj[n][i];

				if (edgeDist > 0 && n!=i) {

					// add to pq
					pq.add(new pair(i, edgeDist));

					if (dist[n] + edgeDist < dist[i]) {
						prev[i] = n;
						dist[i] = dist[n] + edgeDist;
					}
				}
			}

			visited[n] = true;

		}
		
		//System.out.println(Arrays.toString(dist));
		return dist[N - 1];
	}

	public static int dijkstra() {

		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;

		boolean[] visited = new boolean[N];

		PriorityQueue<pair> pq = new PriorityQueue<pair>();
		pq.add(new pair(0, 0));

		while (!pq.isEmpty()) {

			// System.out.println(pq);
			int n = (int) pq.poll().index;

			if (visited[n]) {
				continue;
			}

			for (int i = 0; i < N; i++) {

				int edgeDist = adj[n][i];

				if (edgeDist > 0 && n != i) {

					pq.add(new pair(i, edgeDist));

					dist[i] = Math.min(dist[i], dist[n] + edgeDist);

				}
			}

			visited[n] = true;

		}

		return dist[N - 1];
	}

}
