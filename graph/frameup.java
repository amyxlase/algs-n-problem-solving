import java.util.*;

public class frameup {

	@SuppressWarnings({ "unchecked", "rawtypes" })

	public static HashMap<Character, Integer[]> frames;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int H = sc.nextInt();
		int W = sc.nextInt();

		frames = new HashMap<Character, Integer[]>();
		char[][] grid = new char[H][W];

		for (int i = 0; i < H; i++) {

			String row = sc.next();

			for (int j = 0; j < W; j++) {

				char c = row.charAt(j);
				grid[i][j] = c;

				if (c != '.') {

					if (frames.containsKey(c)) {

						Integer[] arr = frames.get(c);

						arr[0] = Math.min(arr[0], i);
						arr[1] = Math.max(arr[1], i);
						arr[2] = Math.min(arr[2], j);
						arr[3] = Math.max(arr[3], j);

					} else {
						Integer[] arr = { i, i, j, j };
						frames.put(c, arr);
					}

				}

			}
		}
		

		boolean[][] graph = new boolean[26][26];

		Iterator it = frames.entrySet().iterator();
		while (it.hasNext()) {

			Map.Entry mapElement = (Map.Entry) it.next();
			char frame = (char) mapElement.getKey();
			Integer[] sides = (Integer[]) mapElement.getValue();

			

			for (int i = sides[0]; i <= sides[1]; i++) {
				for (int j = sides[2]; j <= sides[3]; j++) {

					if (i == sides[0] || i == sides[1] || j == sides[2] || j == sides[3]) {

						if (grid[i][j] != frame) {
							graph[frame - 'A'][grid[i][j] - 'A'] = true;
						}
					}
				}
			}
		}
		
	//	System.out.println(Arrays.deepToString(graph));
		
		List<String> ans = new ArrayList<>();
		int[] indegree = new int[26];
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				if (graph[i][j]) {
					indegree[j]++;
				}
			}
		}
		
		boolean[] visited = new boolean[26];
		List<Character> charList = new ArrayList<>(frames.keySet());
		char[] temp = new char[charList.size()];
		
		dfs(graph, charList, indegree, visited, temp, ans, 0);
		
		Collections.sort(ans);
		
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
	
	static void dfs(boolean[][] graph, List<Character> charList, int[] indegree,
			boolean[] visited, char[] temp, List<String> ans, int index) {
		
		if (index == temp.length) {
			ans.add(new String(temp));
			return;
		}
		
		for (char c : charList) {
			if (!visited[c-'A'] && indegree[c-'A'] == 0) {
				visited[c-'A'] = true;
				temp[index] = c;
				
				List<Character> adjNodes = new ArrayList<>();
				for (char adjC : charList) {
					if (graph[c-'A'][adjC-'A'] && indegree[adjC-'A'] > 0) {
						adjNodes.add(adjC);
						indegree[adjC-'A']--;
					}
				}
				
				dfs(graph, charList, indegree, visited, temp, ans, index+1);
				
				// reset
				for (char adjC : adjNodes) {
					indegree[adjC-'A']++;
				}
				visited[c-'A'] = false;
			}
		}
	}
	

	public static void printf() {

		Iterator it = frames.entrySet().iterator();

		while (it.hasNext()) {

			Map.Entry mapElement = (Map.Entry) it.next();
			char frame = (char) mapElement.getKey();
			Integer[] sides = (Integer[]) mapElement.getValue();

			System.out.print(frame + ": ");

			for (int i = 0; i < sides.length; i++) {
				System.out.print(sides[i] + ", ");
			}

			System.out.println();
		}

	}

}
