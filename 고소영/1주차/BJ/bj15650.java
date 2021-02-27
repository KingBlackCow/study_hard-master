import java.util.Scanner;
public class bj15650 {
	
	public static int[] chosen;
	public static boolean[] visit;
	public static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		chosen = new int[13];
		visit = new boolean[13];
		pick(0, 1);
		
	}
		
		public static void pick(int cnt, int idx) {
			if(cnt == M) {
				for (int i = 0; i < M; i++) {
					System.out.print(chosen[i] + " ");
				}
				System.out.println();
				return;
			}
			
			for (int i = idx; i <= N; i++) {
				if(!visit[i]) {
					chosen[cnt] = i;
					visit[i] = true;
					pick(cnt + 1, i + 1);
					visit[i] = false;
				}
			}
		}
	}
