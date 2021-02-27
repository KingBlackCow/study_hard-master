package 이분탐색;
import java.util.Scanner;

public class _1790_수_이어쓰기_2 {
	static int N, K;
	static long calc(int mid) {
		//N까지 수를 이어쓸 때 그 길이
		long ret = 0;
		/*index : 자리 첫 수
		 *len 	: 길이
		 */
		for(int index=1, len=1; index<=mid;index*=10, len++) {
			long idx = index*10-1;
			if (idx >= mid)
				ret += (long)((mid-index+1)*len);
			else
				ret += (long)((idx-index+1)*len);	//현재 수까지의길이
		}
		return ret;
	}
	static void solve() {
		int left=0, right=N;
		int ret =0;
		while(left<=right) {
			int mid = (left+right)/2;
			long result = calc(mid);
			if (result < K)
				left = mid+1;
			else {
				ret = mid;
				right = mid-1;
			}
		}
		String temp = ret+"";
		long tp = calc(ret);
		System.out.println(temp.charAt(temp.length()-((int)tp-K)-1));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		if (calc(N) < K) {
			System.out.println(-1);
			return;
		}
		solve();
	}
}
