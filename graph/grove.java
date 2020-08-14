import java.util.*;

public class grove {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();
		int[][] grid = new int[R][C];
		int[][] dir = { { -1, -1 }, { -1, 0 }, { 0, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 }, { 0, 1 }, { 1, 0 } };

		int[] extremes = new int[4]; // up down left right
		extremes[0] = Integer.MAX_VALUE;
		extremes[2] = Integer.MAX_VALUE;

		Integer[] start = new Integer[7];
		start[0] = 0;
		start[1] = 0;
		start[2] = 0;
		start[3] = 0;

		for (int i = 0; i < R; i++) {

			char[] line = sc.next().toCharArray();

			for (int j = 0; j < C; j++) {

				if (line[j] == '.') { // 0=empty
					grid[i][j] = 0;
				} else if (line[j] == 'X') { // 1=tree
					grid[i][j] = 1;

					extremes[0] = Math.min(extremes[0], i);
					extremes[1] = Math.max(extremes[1], i);
					extremes[2] = Math.min(extremes[2], j);
					extremes[3] = Math.max(extremes[3], j);

				} else { // 2=start
					grid[i][j] = 2;
					start[4] = i;
					start[5] = j;
					start[6] = 0;
				}
			}

		}

		if (start[4] < extremes[0]) {
			start[0] = 1;
		}
		if (start[4] > extremes[1]) {
			start[1] = 1;
		}
		if (start[5] < extremes[2]) {
			start[2] = 1;
		}
		if (start[5] > extremes[3]) {
			start[3] = 1;
		}

		boolean[][] visited = new boolean[R][C];

		LinkedList<Integer[]> list = new LinkedList<Integer[]>();
		list.add(start);

		int counter = 0;

		while (!list.isEmpty()) {

			// print((LinkedList<Integer[]>) list.clone());

			Integer[] node = list.removeFirst();

			System.out.println("Node: " + Arrays.toString(node));

			if (node[4] == start[4] && node[5] == start[5]) {
				
				System.out.println("Returned to Home");

				if (node[0] == 1 && node[1] == 1 && node[2] == 1 & node[3] == 1) {
					System.out.println(node[6]);
					System.exit(0);
				}
			}

			if (visited[node[4]][node[5]]) {
				continue;
			}

			visited[node[4]][node[5]] = true;

			for (int i = 0; i < 8; i++) {

				int xnew = node[4] + dir[i][0];
				int ynew = node[5] + dir[i][1];

				if (xnew < 0 || xnew >= R || ynew < 0 || ynew >= C || grid[xnew][ynew] == 1) {
					continue;
				}

				int u = node[0], d = node[1], l = node[2], r = node[3];

				if (xnew < extremes[0]) {
					u = 1;
				}
				if (xnew > extremes[1]) {
					d = 1;
				}
				if (ynew < extremes[2]) {
					l = 1;
				}
				if (ynew > extremes[3]) {
					r = 1;
				}

				Integer[] n = { u, d, l, r, xnew, ynew, node[6] + 1 };
				list.add(n);

			}

			counter++;
		}

	}

	public static void print(LinkedList<Integer[]> list) {

		System.out.print("List: ");

		Iterator it = list.iterator();

		while (it.hasNext()) {
			Integer[] n = (Integer[]) it.next();

			System.out.print(Arrays.toString(n) + ", ");
		}

		System.out.println();
		System.out.println("-----------");

	}

}
