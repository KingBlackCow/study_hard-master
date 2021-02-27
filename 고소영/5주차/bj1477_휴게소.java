import java.util.Arrays;
import java.util.Scanner;

// 휴계소
// https://ghdic.github.io/ps/boj-1477/
public class bj1477_휴게소 {
	static int N, M, L, low, high;
	static int place[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		
		place = new int [N + 2];
		
		for (int i = 1; i <= N; i++) {
			place[i] = sc.nextInt();
		}
		place[0] = 0;
		place[N + 1] = L;
		Arrays.sort(place);
		
		for (int i = 1; i <= N + 1; i++) {
			high = Math.max(high, place[i] - place[i - 1]);
		}
		
		while(low <= high) {
			int cnt = 0;
			int mid = (low + high) / 2;
			
			for (int i = 1; i <= N + 1; i++) {
				if(place[i] - place[i - 1] > mid)
					cnt +=(place[i] - place[i - 1] - 1) / mid;
			}
			
			if(cnt > M)
				low = mid + 1;
			else
				high = mid - 1;
		}
		System.out.println(low);
	}
}
