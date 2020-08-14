import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class flowerpot {
	
	public static void main(String [] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new FileWriter("help.out"));

		int N = sc.nextInt();
		int D = sc.nextInt();
		int[][] raindrops = new int[N][2];
		for (int i = 0; i < N; i++) {
			raindrops[i][0] = sc.nextInt();
			raindrops[i][1] = sc.nextInt();
		}
		
		int minDif = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				
				out.print(i + " " + j + " ");
				out.print(Math.abs(raindrops[i][1] - raindrops[j][1]));
				out.println(" " + Math.abs(raindrops[i][0] - raindrops[j][0]));
				
				if (Math.abs(raindrops[i][1] - raindrops[j][1]) >= D) {
					minDif = Math.min(minDif, Math.abs(raindrops[i][0] - raindrops[j][0]));
				}
			}
		}

		
		if (minDif == Integer.MAX_VALUE) {
			minDif = -1;
		}
		
		System.out.println(minDif);
		

		
	}

}


