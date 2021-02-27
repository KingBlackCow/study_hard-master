// 새로운 불면증 치료법
import java.util.Scanner;

public class swea1288 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int cnt = 1;
			int [] arr = new int [10];
			while(true) {
				boolean flag = true;
				int total = N * cnt;
				while(total > 0){
					int tmp = total % 10;
					arr[tmp]++;
					total = total / 10;
				}
				for (int i = 0; i < 10; i++) {
					if(arr[i] == 0) {
						flag = false;
					}
				}
				if(flag) {
					break;
				}
				cnt++;
			}
			System.out.println("#" + tc + " " + cnt * N);
		}
	}
	
}
