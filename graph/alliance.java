import java.util.*;

public class alliance {

	public static int N, M;
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;
	public static int edges = 0, nodes = 1;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new ArrayList[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {

			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;

			if (x > y) {
				int temp = x;
				x = y;
				y = temp;
			}

			graph[x].add(y);

		}

		//print();

		long ans = 1;
		int nxt = more();

		while (nxt >= 0) {

			int component = dfs(nxt);
			ans *= component;
			ans %= 1000000007;
			nxt = more();
			edges = 0; nodes = 1;

			//System.out.println(component);
		}

		System.out.println(ans);
	}

	public static int dfs(int root) {
		
		

		//System.out.println(root + " " + edges + " " + nodes);

		visited[root] = true;
		edges += graph[root].size();

		for (int i = 0; i < graph[root].size(); i++) {

			int nxtNode = graph[root].get(i);

			if (!visited[nxtNode]) {
				nodes++;
			} else {
				continue;
			}

			dfs(nxtNode);
		}

		if (nodes == edges) {
			

			return 2;
		}

		if (nodes - 1 == edges) {
			
			return nodes % 1000000007;
		}

		return 1;
	}

	public static int more() {

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {

				if (graph[i].size() == 0) {
					visited[i] = true;
				} else {
					return i;
				}

			}
		}

		return -1;

	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(i + ": " + graph[i]);
		}
	}

}
