import java.util.*;

public class cruise {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();

		int[][] ports = new int[N + 1][2];
		int[] seq = new int[M];

		for (int i = 1; i <= N; i++) {
			ports[i][0] = sc.nextInt();
			ports[i][1] = sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			if (sc.next().charAt(0) == 'L') {
				seq[i] = 0;
			} else {
				seq[i] = 1;
			}
		}
				
		int[] seqPorts = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {

			int port = i;
			
			for (int j = 0; j < M; j++) {
				int dir = seq[j];
				port = ports[port][dir];
				
			}

			seqPorts[i] = port;
		}
				
		if (K <= N) {

			int port = 1;

			for (int j = 0; j < K; j++) {
				port = seqPorts[port];
				
			}

			System.out.println(port);
			
		} else {
			
			/*int port = 1;
			
			for (int i = 0; i < N; i++) {
				port = seqPorts[port];
				
			}  */
			
			int[] seqRep = new int[N+1];
			for (int i = 1; i <= N; i++) {
				int currPort = i;
				for (int j = 0; j < 500; j++) {
					currPort = seqPorts[currPort];
				}
				seqRep[i] = currPort;
			}
			
			int currPort = 1;
			long num500 = N / 500;
			for (int i = 0; i < num500; i++) {
				currPort = seqRep[currPort];
			}
			long remNum = M % 500;
			for (int i = 0; i < remNum; i++) {
				currPort = seqPorts[currPort];
			}
			
			System.out.println(currPort);
			

		}
		
	}

}
