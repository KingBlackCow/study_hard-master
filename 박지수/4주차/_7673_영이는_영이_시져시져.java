import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://programmers.co.kr/learn/courses/30/lessons/42898 : programmers dp 등굣길
//https://yabmoons.tistory.com/537 : 얍문스토리 2/5소인수분해

public class _7673_영이는_영이_시져시져 {
	static final int MAX = 1010;
	static int N;
	static int map[][] = new int[MAX][MAX];
	static int _2[][] = new int[MAX][MAX];
	static int _5[][] = new int[MAX][MAX];
	
	static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			N = Integer.parseInt(br.readLine());
			
			for(int i=1;i<=N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1;j<=N;j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			mapset();
			System.out.print("#"+t+" ");
			solve();
		}
	}
	static void mapset() {
		for(int i=1;i<=N;i++)
			for(int j=1;j<=N;j++) {
				if (map[i][j] == 0) {
					_2[i][j] = 987654231;
					_5[i][j] = 987654321;
					continue;
				}
				int v2 = 0;
				int v5 = 0;
				int temp = map[i][j];
				while(temp%5==0) {
					temp/=5;
					v5++;
				}
				while(temp%2==0) {
					temp/=2;
					v2++;
				}
				_2[i][j] = v2;
				_5[i][j] = v5;
			}
	}
	static void solve() {
		for(int i=1;i<=N;i++)
			for(int j=1;j<=N;j++) {
				if (map[i][j] == 0) continue;
				if (i==1 && j==1) continue;
				if (i==1) {
					_2[i][j] = _2[i][j] + _2[i][j-1];
					_5[i][j] = _5[i][j] + _5[i][j-1];
					continue;
				}
				if (j==1) {
					_2[i][j] = _2[i][j] + _2[i-1][j];
					_5[i][j] = _5[i][j] + _5[i-1][j];
					continue;
				}
				
				int l2 = _2[i][j]+_2[i][j-1];
				int l5 = _5[i][j]+_5[i][j-1];
				int u2 = _2[i][j]+_2[i-1][j];
				int u5 = _5[i][j]+_5[i-1][j];
				int left = Math.min(l2, l5);
				int up = Math.min(u2, u5);
				if (left < up) {
					_2[i][j] = l2;
					_5[i][j] = l5;
				}
				else {
					_2[i][j] = u2;
					_5[i][j] = u5;
				}
			}
		System.out.println(Math.min(_2[N][N], _5[N][N]));
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
	}
}
