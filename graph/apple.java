import java.util.*;

public class apple {
	
	public static int C,  P, PB, PA1, PA2;
	public static int[][] adj;
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		C = sc.nextInt();
		P = sc.nextInt();
		PB = sc.nextInt() - 1;
		PA1 = sc.nextInt() - 1;
		PA2 = sc.nextInt() - 1;
		
		adj = new int[P][P];
		
		for (int i = 0; i < C; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
		
			adj[a][b] = c;
			adj[b][a] = c;
		}
		
		int ba1 = d1(PB, PA1);
		int a1a2 = d1(PA1, PA2);
		
		int ba2 = d1(PB, PA2);
		int a2a1 = d1(PA2, PA1);
		
		System.out.println(ba1+a1a2 + " " + ba2+a2a1);
		
	}
	
	public static int d1(int start, int end, int other) {
		
		boolean hit = false;
		
		int[] dist = new int[P];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		boolean[] visited = new boolean[P];

		PriorityQueue<pair> pq = new PriorityQueue<pair>();
		pq.add(new pair(start, 0));

		while (!pq.isEmpty()) {

			int n = (int) pq.poll().index;

			if (visited[n]) {
				continue;
			}

			for (int i = 0; i < P; i++) {

				int edgeDist = adj[n][i];

				if (edgeDist > 0 && n != i) {

					pq.add(new pair(i, edgeDist));

					dist[i] = Math.min(dist[i], dist[n] + edgeDist);

				}
			}

			visited[n] = true;

		}

		return dist[end];
	}
	
}/*

class pair implements Comparable<pair> {

	int index;
	int distance;

	public pair(int i, int d) {
		index = i;
		distance = d;
	}

	@Override
	public int compareTo(pair o) {
		return (int) (distance - o.distance);
	}

	public String toString() {
		return index + " " + distance;
	}
 
}*/
