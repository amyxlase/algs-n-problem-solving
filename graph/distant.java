import java.util.*;

public class distant {

	public static int N, A, B;
	public static int[][] grass;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		
		grass = new int[N][N];

		for (int i = 0; i < N; i++) {

			char[] line = sc.next().toCharArray();

			for (int j = 0; j < N; j++) {

				if (line[j] == ')') {
					grass[i][j] = 0;
				} else {
					grass[i][j] = 1;
				}

			}

		}
		
		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				max = Math.max(max, maxTime(i, j));
			}
		}

		System.out.println(max);

	}

	public static int maxTime(int x, int y) {

		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[x][y] = 0;

		boolean[][] visited = new boolean[N][N];

		PriorityQueue<node> pq = new PriorityQueue<node>();
		pq.add(new node(x, y, 0));

		while (!pq.isEmpty()) {
			
			//System.out.println("PriorityQueue: " + pq);
			
		
			node n = pq.poll();
			
			if (visited[n.x][n.y]) {
				continue;
			}


			for (int i = 0; i < 4; i++) {
				

				int xnew = n.x + dir[i][0];
				int ynew = n.y + dir[i][1];
				
				//System.out.println("From: (" + n.x + ", " + n.y + ") To: (" + xnew + ", " + ynew + ")");

				if (xnew >= 0 && xnew < N && ynew >= 0 && ynew < N) {

					int d = A;

					if (grass[n.x][n.y] != grass[xnew][ynew]) {
						
						//System.out.println("Different!");
						
						d = B;
					}

					
					
					//System.out.println("Comparing: " + dist[xnew][ynew] + " and " + (dist[n.x][n.y] + d));

					dist[xnew][ynew] = Math.min(dist[xnew][ynew], dist[n.x][n.y] + d);
					
					pq.add(new node(xnew, ynew, dist[xnew][ynew]));

					
				}

			}
			
			visited[n.x][n.y] = true;
			
		//	System.out.println("Distance Array: " + Arrays.deepToString(dist));

		}


		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, dist[i][j]);
			}
		}
		return max;

	}
}

class node implements Comparable<node> {

	int x, y, dist;

	public node(int a, int b, int d) {
		x = a;
		y = b;
		dist = d;

	}

	@Override
	public int compareTo(node o) {
		return dist - o.dist;
	}

	public String toString() {
		return "(" + x + ", " + y + "): " + dist;
	}

}
