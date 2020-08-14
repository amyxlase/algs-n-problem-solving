import java.util.*;

public class water {

	public static int N;
	public static int[][] graph;
	public static int[] indegree;
	public static HashSet<Integer> mst;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		graph = new int[N][N];
		int minWellCost = Integer.MAX_VALUE;
		int minWellIndex = -1;

		for (int i = 0; i < N; i++) {
			graph[i][i] = sc.nextInt();

			if (graph[i][i] < minWellCost) {
				minWellCost = graph[i][i];
				minWellIndex = i;
				
				//System.out.println("Using a well");
			}

		}

		int startingWell = minWellIndex;
		mst = new HashSet<Integer>();
		int counter = 0;
		int cost = 0;

		for (int i = 0; i < N; i++) {

			int minPathCost = Integer.MAX_VALUE;
			
			for (int j = 0; j < N; j++) {
				int nxt = sc.nextInt();

				if (i != j) {
					graph[i][j] = nxt;
					minPathCost = Math.min(minPathCost,  nxt);
				}
			}
			
			if (minPathCost > graph[i][i]) {
				if (counter == 0) {
					startingWell = i;
					counter++;
				} else {
					mst.add(i);
					cost += graph[i][i]; 
				}
			}
		}

		indegree = new int[N];
		Arrays.fill(indegree, Integer.MAX_VALUE);

		indegree[startingWell] = graph[startingWell][startingWell];
		
		while (mst.size() < N) {

			int[] min = min();
			int vertex = min[0];
			mst.add(vertex);
			cost += min[1];
  
			//System.out.println(vertex + " " + min[1]);

			//System.out.println(Arrays.toString(indegree));

			for (int i = 0; i < N; i++) {
				if (graph[vertex][i] != 0 && !mst.contains(i)) {
					indegree[i] = Math.min(graph[vertex][i], indegree[i]);
				}
			}

		}

		System.out.println(cost);

	}

	public static void print() {
		for (int i = 0; i < N; i++) {

			System.out.println(Arrays.toString(graph[i]));
		}
	}

	public static int[] min() {

		int minValue = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < N; i++) {
			if (indegree[i] < minValue && !mst.contains(i)) {
				minValue = indegree[i];
				minIndex = i;
			}
		}

		int[] ans = { minIndex, minValue };
		return ans;
	}

}
