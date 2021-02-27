import java.util.Scanner;

public class _1945_간단한_소인수분해 {

	static int result[] = new int [5];
	static int Div[] = { 2,3,5,7,11 };
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			int temp = sc.nextInt();
			solve(temp);
			System.out.print("#"+i+" ");
			for (int k = 0; k < 5; k++) {
				System.out.print(result[k]+" ");
			}
			System.out.println();
		}
	}
	public static void solve(int item) {
		for (int i = 0; i < 5; i++) {
			int cnt = 0;
			while (item % Div[i] == 0) {
				if (item == 0) break;
				item /= Div[i];
				cnt++;
			}
			result[i] = cnt;
		}
	}
}
