import java.util.*;

public class gpsduel {

	public static int N, M;
	public static ArrayList[] P, Q, beeps;
	public static int[] Pshortest, Qshortest;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		P = new ArrayList[N];
		Q = new ArrayList[N];
		beeps = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			P[i] = new ArrayList<Integer>();
			Q[i] = new ArrayList<Integer>();
			beeps[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
			int d = sc.nextInt();

			P[b].add(new edge(a, c));
			Q[b].add(new edge(a, d));
		}

		 System.out.println(Arrays.deepToString(P));
		 System.out.println(Arrays.deepToString(Q));

		Pshortest = dijkstra(P, false);
		Qshortest = dijkstra(Q, false);

		System.out.println(Arrays.toString(Pshortest));
		 System.out.println(Arrays.toString(Qshortest));

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < P[i].size(); j++) {
				//conscruct beeps
			}
		}

		// System.out.println(Arrays.deepToString(beeps));

		int[] ans = dijkstra(beeps, true);
		// System.out.println(Arrays.toString(ans));

		System.out.println(ans[N - 1]);
	}

	public static int[] dijkstra(ArrayList[] arr, boolean ans) {

		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);

		int start = N - 1;

		if (ans) {
			start = 0;
		}

		dist[start] = 0;

		boolean[] visited = new boolean[N];

		PriorityQueue<edge> pq = new PriorityQueue<edge>();
		pq.add((edge) P[start].get(0));

		while (!pq.isEmpty()) {

			 System.out.println("Queue: " + pq);
			edge e = (edge) pq.poll();

			if (visited[e.to]) {
				continue;
			}

			for (int i = 0; i < P[e.to].size(); i++) {
				
				edge f = (edge) P[e.to].get(i);


				if ((e.weight > 0) || (ans && e.weight >= 0)) {

					pq.add(f);

					dist[f.to] = Math.min(dist[f.to], dist[e.to] + e.weight);

				}

			}

			visited[e.to] = true;

		}

		return dist;
	}

}

//test

class edge implements Comparable<edge> {

	int to, weight;

	public edge(int t, int w) {
		to = t;
		weight = w;
	}

	@Override
	public int compareTo(edge o) {
		return (int) (weight - o.weight);
	}

	public String toString() {
		return to + " " + weight;
	}

}
