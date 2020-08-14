import java.util.*;

public class test {
	
	public static void main(String [] args) {
		
		bro[] cats = new bro[10];
		
		for (int i = 0; i < 10; i++) {
			cats[i] = new bro(i + 25);
		}
		
		bro[] birds = cats.clone();
		
		cats[5].x = 69;

		
		System.out.println(Arrays.toString(birds));
		
		
		
	}
	
	

} class bro {
	
	
	int x;
	
	public bro(int i) {
		x = i;
	}
	
	@SuppressWarnings("deprecation")
	public String toString() {
		return new Integer(x).toString();
	}
	
}
