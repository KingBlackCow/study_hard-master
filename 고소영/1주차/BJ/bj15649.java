import java.util.Scanner;
public class bj15649 {
	public static int n, m;
	public static int [] chosen;
	public static boolean [] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		visit = new boolean[13]; 
		chosen = new int [13];
				
		n = sc.nextInt();
		m = sc.nextInt();
		pick(0);
	}
	
		public static void pick(int cnt) {
			if(cnt == m) {
				for (int i = 0; i < m; i++) {
					System.out.print(chosen[i] + " ");
				}
				System.out.println();
			}
			for (int i = 1; i <= n; i++) {
				if(!visit[i]) {
					visit[i] = true;
					chosen[cnt] = i;
					pick(cnt + 1);
					visit[i] = false;
				}
			}
	}
}
