import java.util.Arrays;
import java.util.Scanner;

public class _1288_새로운_불면증_치료법 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean sheep[] = new boolean[10];
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			Arrays.fill(sheep, false);
			int temp = sc.nextInt();
			int cnt = 1, view=0;
			while (true) {
				if (view == 10) break;
				String sleep = ""+(temp * cnt++);
				for (int i = 0; i < sleep.length(); i++) {
					if (!sheep[sleep.charAt(i) - '0']) {
						view++;
						sheep[sleep.charAt(i) - '0'] = true;
					}
				}
			}
			System.out.println("#"+t+" "+(temp*(cnt-1)));
		}
	}

}
