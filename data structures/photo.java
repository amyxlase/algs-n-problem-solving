
import java.util.*;

public class photo {
	
	public static void main(String [] args) {
		
		
		Scanner sc = new Scanner(System.in);		
		
		int N = sc.nextInt();
		Integer[] photo = new Integer[N];
		HashMap<Integer, Integer> keys = new HashMap<Integer, Integer>();
		int[][] master = new int[N][5];
		
		for (int j = 0; j < N; j++) {
			int key = sc.nextInt();
			keys.put(key, j);
			photo[j] = key;
			master[j][0] = j; 
		}	
		
		
		for (int i = 1; i < 5; i++) {		
			for (int j = 0; j < N; j++) {
				int key = sc.nextInt();
				int arrIndex = keys.get(key);
				master[arrIndex][i] = j;
				

			}	
		}
				//System.out.println(Arrays.deepToString(master));

		Arrays.sort(photo, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
							
				
				int before = 0, after = 0;
				
				int o1arrIndex = keys.get(o1);
				int o2arrIndex = keys.get(o2);
				
				
				for (int i = 0; i < 5; i++) {
					if (master[o1arrIndex][i] < master[o2arrIndex][i]) {
						before++;
					} else {
						after++;
					}
				}
				
				
				return after - before;
				
				
			}
		});
		
		for (int i = 0; i < N; i++) {
			System.out.println(photo[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
