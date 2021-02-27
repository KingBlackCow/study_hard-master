// 수도요금 경쟁
import java.util.Scanner;
public class swea1284 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();
		
		for (int  tc = 1; tc <= T; tc++) {
			int P = sc.nextInt(); //a사 리터당 요금
			int Q = sc.nextInt(); //b사 기본 요금
			int R = sc.nextInt(); // b사 추가 요금 기준 리터
			int S = sc.nextInt(); // b사 리터 당 추가 요금
			int W = sc.nextInt(); // 사용한 양
			
			int ans = 0;
			int aPaid = P * W;
			int bPaid = W - R > 0 ? (Q + (W - R) * S) : Q; 
			if(aPaid > bPaid) {
				ans = bPaid;
			}
			else {
				ans = aPaid;
			}
			System.out.println("#" + tc + " " + ans);
	}
	}
}
