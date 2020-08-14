
import java.util.*;

public class ttravel {

	@SuppressWarnings("unchecked")

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		ArrayList<Integer> current = new ArrayList<Integer>();
		entry[] entries = new entry[N + 1];
		entries[0] = new entry(0, (ArrayList<Integer>) current.clone());
		
		for (int i = 1; i < N + 1; i++) {

				String[] line = sc.nextLine().split(" ");

				if (line[0].equals("s")) {

					current.remove(current.size() - 1);

				} else {

					int K = Integer.parseInt(line[1]);

					if (line[0].equals("a")) {
						current.add(K);
					}

					if (line[0].equals("t")) {
						
						
						current = (ArrayList<Integer>) entries[K - 1].cows.clone();
					}

				}
				
				entries[i] = new entry(i, (ArrayList<Integer>) current.clone());


				if (entries[i].cows.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(entries[i].cows.get(current.size() - 1));
				}
			
		}
		
		//System.out.println(Arrays.toString(entries));


	}

}

class entry {

	int num;
	ArrayList<Integer> cows;

	public entry(int n, ArrayList<Integer> c) {
		num = n;
		cows = c;
	}
	
	public String toString() {
		return "Query " + num + ": " + cows + "\n";
	}

}
