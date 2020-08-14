import java.util.*;

public class lilypad {
	
	
	public static int M, N;
	public static int[][] pond;
	public static int[][] adjacency;


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		pond = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {		
				pond[i][j] = sc.nextInt();
			}
		}
		
		createAdjacency();

	}
	
	public static void createAdjacency() {
		
	}
}
