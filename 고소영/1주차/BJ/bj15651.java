import java.util.Scanner;
public class bj15651{
	public static int n, m;
	public static int [] chosen;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		chosen = new int[m];
		
		pick(0);
		System.out.println(sb);
	}
	
	public static void pick(int cnt) {
		if(cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(chosen[i] + " ");
			}
			sb.append('\n');
			return;
		}
	
		for (int i = 1; i <= n; i++) {
			chosen[cnt] = i;
			pick(cnt + 1);
		}
	}
}
