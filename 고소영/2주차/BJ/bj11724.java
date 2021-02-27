import java.util.*;
public class bj11724 {
	public static int[][] adj_mat = new int[1001][1001];
	public static boolean[] visit = new boolean[1001];
	public static int n, m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int i = 0; i < m; i++) {
			int start, end;
			start = sc.nextInt();
			end = sc.nextInt();
			adj_mat[start][end] = 1;
			adj_mat[end][start] = 1;
		}
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if(!visit[i]) {
				cnt++;
				visit[i] = true;
				dfs(i);
			}
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int v) {
		for (int i = 1; i <= n; i++) {
			if(adj_mat[v][i] == 1 & !visit[i]) {
				visit[i] = true;
				dfs(i);
			}
		}
	}
}
