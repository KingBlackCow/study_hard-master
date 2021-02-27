import java.util.Scanner;
public class swea1217 {
	public static int n,m, res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int k = sc.nextInt();
			
			 n = sc.nextInt();
			 m = sc.nextInt();
			
			 Recursion(n, n, 1);
			 System.out.println("#" + tc + " " + res);
		}
	}
	
	public static void Recursion(int n, int now ,int cnt) {
		if(cnt == m) {
			res = now;
			return;
		}
		Recursion( n, now * n , cnt + 1);
	}
}
