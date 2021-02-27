import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t;
	static int n,m;
	static int[][] arr,sum;
	static int[][][][] dp;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.valueOf(br.readLine());
		//t = 10;

		for(int test_case = 1;test_case<=t;test_case++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.valueOf(st.nextToken());
			m = Integer.valueOf(st.nextToken());
			
			arr = new int[n][m];
			sum = new int[n+1][m+1];
			dp = new int[n+1][m+1][n+1][m+1];
			
			for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.valueOf(st.nextToken());
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] + arr[i][j] - sum[i][j];
                }
            }
            
			bw.write("#" + String.valueOf(test_case) + " " + solve(1,1,n,m) + "\n");
		}

		bw.flush();
		bw.close();
	}
	
	public static int solve(int x,int y,int ex,int ey) {
		if(x==ex && y == ey) return 0;
		
		int ret = dp[x][y][ex][ey];
		if(ret>0) return ret;
		
		ret = Integer.MAX_VALUE;
		
		int now_sum = sum[ex][ey] - sum[ex][y-1] - sum[x-1][ey] + sum[x-1][y-1];
		for(int i=x;i<ex;i++) ret = Math.min(ret, now_sum + solve(x,y,i,ey) + solve(i+1,y,ex,ey));
		for(int i=y;i<ey;i++) ret = Math.min(ret, now_sum + solve(x,y,ex,i) + solve(x,i+1,ex,ey));
		
		return dp[x][y][ex][ey] = ret;
	}
}