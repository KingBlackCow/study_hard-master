// 초심자의 회문검사
import java.util.Scanner;

public class swea1989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			
			char[] arr = str.toCharArray();
			char[] arr2 = str.toCharArray();
			
			int length = str.length();
			int ans = 1;
			for (int i = 0; i < length / 2; i++) {
				if(arr[i] != arr2[length - i - 1])
					ans = 0;
			}
			System.out.println("#" + tc + " " + ans);
			
	}
	}
}
