import java.util.Arrays;
import java.util.Scanner;
public class bj15654 {
	public static int n, m;
	public static int [] chosen, num;
	public static boolean [] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		chosen = new int[m];
		num = new int [n];
		visit = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		
		//배열 오름차순 정렬
		Arrays.sort(num);
		
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
		
		for (int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				chosen[cnt] = num[i];
				pick(cnt + 1);
				visit[i] = false;
			}
		}
		
		
	}
}
