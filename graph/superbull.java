import java.util.*;

public class superbull {

	public static int N;
	public static int[] teams;
	public static HashSet<Integer> mst;
	public static int[] indegree;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		teams = new int[N];

		for (int i = 0; i < N; i++) {
			teams[i] = sc.nextInt();
		}

		mst = new HashSet<Integer>();
		long score = 0;
		indegree = new int[N];

		while (mst.size() < N) {

			int[] ans = max();
			mst.add(ans[0]);
			score += ans[1];
			
			//System.out.println(ans[1]);

			for (int i = 0; i < N; i++) {

				int n = teams[ans[0]] ^ teams[i];

				indegree[i] = Math.max(indegree[i], n);
			}

			//System.out.println(mst);
		}

		System.out.println(score);

	}

	public static int[] max() {

		int index = -1;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {

			if (max < indegree[i] && !mst.contains(i)) {
				max = indegree[i];
				index = i;
			}

		}

		int ans[] = { index, max };
		return ans;
	}
}
