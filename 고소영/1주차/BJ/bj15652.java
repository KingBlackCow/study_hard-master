import java.util.Scanner;
public class bj15652 {
	public static int n,m;
	public static int chosen[];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		chosen = new int [m];
		
		pick(0, 1);
	}
	
	public static void pick(int cnt, int idx) {
		if(cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(chosen[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = idx; i <= n; i++) {
			chosen[cnt] = i;
			pick(cnt + 1, i);
		}
	}
}
