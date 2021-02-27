// 간단한 소인수분해

import java.util.Scanner;

public class swea1945 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
		
			int N = sc.nextInt();
			int [] num = {2, 3, 5, 7, 11};
			int [] res = new int [5];
			
			for (int i = 0; i < 5; i++ ) {
				int cnt = 0;
				
				while(N % num[i] == 0) {
					cnt++;
					N = N / num[i];
				}
				res[i] = cnt;
			}
			
			System.out.print("#" + tc + " " );
			for (int i = 0; i < 5; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
		
	}
}
