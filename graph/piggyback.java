import java.util.*;

public class piggyback {

	public static int B, E, P, N, M;
	public static int[][] adj;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		B = sc.nextInt();
		E = sc.nextInt();
		P = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();

		adj = new int[N][N];

		for (int i = 0; i < M; i++) {

			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			adj[a][b] = 1;
			adj[b][a] = 1;

		}

		int[] besDist = bfs(0);
		int[] elsDist = bfs(1);
		int[] toEnd = bfs(N - 1);

		//System.out.println(Arrays.toString((besDist)));
		//System.out.println(Arrays.toString((elsDist)));
		//System.out.println(Arrays.toString((toEnd)));

		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {

			int energy = besDist[i] * B + elsDist[i] * E + toEnd[i] * P;

			ans = Math.min(ans, energy);
		}

		System.out.println(ans);

	}

	public static int[] bfs(int start) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(start);

		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		boolean[] visited = new boolean[N];

		while (!list.isEmpty()) {

			System.out.println(list);

			int n = (int) list.poll();

			if (visited[n]) {
				continue;
			}

			for (int i = 0; i < N; i++) {

				if (adj[n][i] > 0 && n != i) {

					list.add(i);

					dist[i] = Math.min(dist[i], dist[n] + 1);

				}
			}

			visited[n] = true;
			
		}

		return dist;
	}


}
