import java.util.*;

@SuppressWarnings({ "rawtypes", "unchecked" })

public class chocmilk {

	public static int N;
	public static ArrayList[] leaving;
	public static ArrayList[] coming;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		leaving = new ArrayList[N + 1];
		coming = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			leaving[i] = new ArrayList<Integer>();
			coming[i] = new ArrayList<Integer>();

		}

		for (int i = 0; i < N - 1; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			leaving[from].add(to);
			coming[to].add(from);

		}
		
		//printl();
		//printc();

		
		//find first tank
		int tank = 0;
		for (int i = 1; i <= N; i++) {
			if (leaving[i].isEmpty()) {
				tank = i;
				break;
			}
		}
		
	//	System.out.println("Machine: " + machine);
		
		//last node to have 1 leaving
		int node1 = tank;
		while (coming[node1].size() == 1) {
			node1 = (int) coming[node1].get(0);
		}
		

		
		
		// find first milk machine
		int machine = 0;
		for (int i = 1; i <= N; i++) {
			if (coming[i].isEmpty()) {
				machine = i;
				break;
			}
		}
		
	//	System.out.println("Machine: " + machine);
		
		//last node to have 1 leaving
		int node2 = machine;
		while (leaving[node2].size() == 1) {
			node2 = (int) leaving[node2].get(0);
		}

		for (int i = node1; i <=node2; i++) {
			if (!coming[i].isEmpty()) {
				System.out.println(i);
			}
		}
		
		
	}

	public static void printl() {
		System.out.println("Leaving");
		for (int i = 0; i < N; i++) {			
			System.out.println(i + ": " + leaving[i]);
		}
	}
	
	public static void printc() {
		System.out.println("Coming");
		for (int i = 0; i < N; i++) {
			System.out.println(i + ": " + coming[i]);
		}
	}

}
