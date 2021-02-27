import java.util.Scanner;

public class _1986_지그재그_숫자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int temp = sc.nextInt();
			if (temp % 2 == 0) {
				System.out.println("#"+t+" "+((temp/2)*-1));
			}
			else {
				System.out.println("#"+t+" "+((temp/2)*-1+temp));
			}
		}
	}

}
