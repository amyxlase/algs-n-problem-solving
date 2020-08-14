import java.util.*;

public class flow {

	public static int N;
	public static int[][] graph;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		graph = new int[52][52];

		for (int i = 0; i < N; i++) {

			char x = sc.next().charAt(0);
			char y = sc.next().charAt(0);
			
			int a = 0; int b = 0;
			
			
			if (Character.isLowerCase(x)) {
				a = x - 'a'+ 26;
			} else {
				a = x - 'A';
			}
			
			if (Character.isLowerCase(y)) {
				b = y - 'a'+ 26;
			} else {
				b = y - 'A';
			}
			
			int weight = sc.nextInt();
			
		//	System.out.println(a + " " + b + " " + weight);

			graph[a][b] += weight;
			graph[b][a] += weight;

		}

		int counter = 0;

		while (!done()) {

			//print();

			compress();

			counter++;
		}

		System.out.println(graph[0][25]);

	}

	public static boolean done() {

		for (int i = 0; i < 52; i++) {
			for (int j = 0; j < 52; j++) {

				if ((i == 0 && j == 25) || (i == 25 && j == 0)) {
					continue;
				}

				if (graph[i][j] > 0) {
					return false;
				}
			}
		}

		return true;

	}

	public static void compress() {

		for (int i = 0; i < 52; i++) {

			ArrayList<Integer> neighbors = new ArrayList<Integer>();

			for (int j = 0; j < 52; j++) {

				if (graph[i][j] > 0) {
					neighbors.add(j);
				}

			}

		//	System.out.println("ROW " + i);
			//print();

			if (neighbors.size() == 1 && i != 0 && i != 25) {

				graph[i][neighbors.get(0)] = 0;
				graph[neighbors.get(0)][i] = 0;

			}

			if (neighbors.size() == 2 && i != 0 && i != 25) {

				int a = neighbors.get(0);
				int b = neighbors.get(1);
				int c = Math.min(graph[i][a], graph[i][b]);

				graph[a][b] += c;
				graph[b][a] += c;
				graph[i][a] = 0;
				graph[i][b] = 0;
				graph[a][i] = 0;
				graph[b][i] = 0;

			}
		}

	}

	public static void print() {

		System.out.print(0 + " | ");
		for (int j = 0; j < 52; j++) {
			System.out.print(j + " | ");
		}

		System.out.println();

		for (int i = 0; i < graph.length; i++) {

			System.out.print(i + " | ");
			for (int j = 0; j < graph[i].length; j++) {
				System.out.print(graph[i][j] + " | ");
			}

			System.out.println();

		}

		System.out.println("---");

	}

}
