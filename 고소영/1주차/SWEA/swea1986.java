// 지그재그 숫자
import java.util.Scanner;
public class swea1986 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if(i % 2 == 0) {// 짝수라면
				ans -= i;
				}
				else if(i % 2 != 0) {
					ans += i;
				}	
			}
			System.out.println("#" + tc + " " + ans);	
	}
	
	}
}
