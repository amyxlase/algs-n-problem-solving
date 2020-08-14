import java.util.*;

public class fencedin {

	public static int A, B, N, M;
	public static int[] horizontal, vertical;
	public static ArrayList<edge> edges;
	public static int[][] uf;

	public static void main(String[] args) {

		input();
		makeEdges();
		
		int V = (N+1)*(M+1) - 1;
		uf = new int[M+1][N+1];
		int counter = 1;
		int anscounter = 0;
		long ans = 0;
		
		while (anscounter < V) {
			
			edge e = edges.remove(0);
			
		//	System.out.println(Arrays.deepToString(uf));
						
			int n1 = uf[e.co1[0]][e.co1[1]];
			int n2 = uf[e.co2[0]][e.co2[1]];
			
			//System.out.println(n1 + " " + n2);
		
			if (n1 == 0 && n2 == 0) {
			//	System.out.println("both unattached");
				uf[e.co1[0]][e.co1[1]] = counter;
				uf[e.co2[0]][e.co2[1]] = counter;
				counter++;
			} else if (n1 == 0) {
				 uf[e.co1[0]][e.co1[1]] = n2;
			} else if (n2 == 0) {
				uf[e.co2[0]][e.co2[1]] = n1;
			
			} else if (n1 != n2) {
			//	System.out.println("diff");
				for (int i = 0; i < M+1; i++) {
					for (int j = 0; j < N+1; j++) {
						if (uf[i][j] == n2) {
							uf[i][j] = n1;
						}
					}
				}
				
				counter++;
				
			} else {
		//		System.out.println("removed");
				continue;
			}
			
			ans+= e.weight;
			anscounter++;
			
		}
		
		System.out.println(ans);

	}

	public static void input() {
		Scanner sc = new Scanner(System.in);

		A = sc.nextInt(); // horizontal
		B = sc.nextInt(); // border
		N = sc.nextInt(); // verticals
		M = sc.nextInt(); // horizontals

		int[] vco = new int[N + 1];
		int[] hco = new int[M + 1];
		for (int i = 1; i <= N; i++) {
			vco[i] = sc.nextInt();
		}
		for (int i = 1; i <= M; i++) {
			hco[i] = sc.nextInt();
		}

		Arrays.sort(vco);
		Arrays.sort(hco);

		vertical = new int[N + 1];
		horizontal = new int[M + 1];

		int end = A;
		for (int i = N; i >= 0; i--) {
			vertical[i] = end - vco[i];
			end = vco[i];
		}

		end = B;
		for (int i = M; i >= 0; i--) {
			horizontal[i] = end - hco[i];
			end = hco[i];
		}

		//System.out.println(Arrays.toString(horizontal));
		//System.out.println(Arrays.toString(vertical));
	}

	public static void makeEdges() {
		edges = new ArrayList<edge>();

		for (int i = 0; i <= M; i++) {
			for (int j = 1; j <= N; j++) {

				int[] co1 = { i, j - 1 };
				int[] co2 = { i, j };
				int weight = horizontal[i];

				edge e = new edge(co1, co2, weight);

				edges.add(e);
			}
		}

		for (int i = 1; i <= M; i++) {
			for (int j = 0; j <= N; j++) {

				int[] co1 = { i - 1, j };
				int[] co2 = { i, j };
				int weight = vertical[j];

				edge e = new edge(co1, co2, weight);

				edges.add(e);
			}
		}

		edges.sort(new Comparator<edge>() {

			@Override
			public int compare(edge o1, edge o2) {
				return o1.weight - o2.weight;
			}

		});
		
	}

	public static void print() {
		for (int i = 0; i < edges.size(); i++) {
			System.out.println(i + ": " + edges.get(i));
		}
	}

	public static boolean cycles() {
		
		
		
		
		
		
		
		
		
		
		
		return false;
	}
}
/*
class edge {

	int[] co1;
	int[] co2;
	int weight;

	public edge(int[] c1, int[] c2, int w) {
		weight = w;
		co1 = c1;
		co2 = c2;
	}

	public String toString() {
		return Arrays.toString(co1) + " -> " + Arrays.toString(co2) + ": " + weight;
	}

} */
