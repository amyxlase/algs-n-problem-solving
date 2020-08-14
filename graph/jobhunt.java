
import java.util.*;

public class jobhunt {

	public static int D, P, C, F, S;
	public static int[][] paths;
	public static int[][] flights;
	public static int[] dist;
	public static int[] distCopy;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		D = sc.nextInt();
		P = sc.nextInt();
		C = sc.nextInt();
		F = sc.nextInt();
		S = sc.nextInt() - 1;

		paths = new int[P][2];
		flights = new int[F][3];

		for (int i = 0; i < P; i++) {
			paths[i][0] = sc.nextInt() - 1;
			paths[i][1] = sc.nextInt() - 1;
		}

		for (int i = 0; i < F; i++) {
			flights[i][0] = sc.nextInt() - 1;
			flights[i][1] = sc.nextInt() - 1;
			flights[i][2] = sc.nextInt() * -1;
		}
		
		dist = new int[C];
		dist[S] = D;

		for (int i = 0; i < C - 1; i++) {

			for (int j = 0; j < P; j++) {
				int start = paths[j][0];
				int end = paths[j][1];
				
				//System.out.println("Path: " + j + ": " + start + " " + end);
				//System.out.println("Comparing " + dist[end] + " " +  (dist[start] + D));

				dist[end] = Math.max(dist[end], dist[start] + D);
			}

			for (int j = 0; j < F; j++) {
				int start = flights[j][0];
				int end = flights[j][1];
				int cost = flights[j][2];
				
				//System.out.println(j + ": " + start + " " + end + " " + cost);


				dist[end] = Math.max(dist[end], dist[start] + cost + D);
			}
			
			//System.out.println(Arrays.toString(dist));
		}
		
	//	System.out.println("---");

		for (int i = 0; i < C - 1; i++) {
			
		//	System.out.println(Arrays.toString(dist));


			for (int j = 0; j < P; j++) {
				int start = paths[j][0];
				int end = paths[j][1];
				
				if (dist[start] + D > dist[end]) {
										
					System.out.println(-1);
					System.exit(0);
				}

			}

			for (int j = 0; j < F; j++) {
				int start = flights[j][0];
				int end = flights[j][1];
				int cost = flights[j][2];

				if (dist[start] + cost > dist[end]) {
					
					System.out.println(j);

					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		
		int max = 0;	
		for (int i = 0; i < C; i++) {
			max = Math.max(max,  dist[i]);
		}		
		System.out.println(max);

	}

}
