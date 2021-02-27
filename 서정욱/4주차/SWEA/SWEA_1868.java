import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t;
	static int n,ans;
	static char[][] arr;
	static boolean[][] visit;
	static int[][] count;
	static int X[]= {0,1,0,-1,1,1,-1,-1},Y[]= {1,0,-1,0,1,-1,1,-1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.valueOf(br.readLine());
		//t = 10;

		for(int test_case = 1;test_case<=t;test_case++) {
			n = Integer.valueOf(br.readLine());
			
			ans=0;
			arr = new char[n+2][n+2];
			visit = new boolean[n+2][n+2];
			count = new int[n+2][n+2];
			
			for(int i=1;i<=n;i++) {
				String s = br.readLine();
				for(int j=1;j<=n;j++)
					arr[i][j] = s.charAt(j-1);
			}
			
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					if(arr[i][j]=='.')
						count[i][j] = chk(i,j);
			
			for(int i=1;i<=n;i++) 
				for(int j=1;j<=n;j++)
					if(arr[i][j]=='.' && count[i][j]==0 && !visit[i][j]) {
						ans++;
						solve(i,j);
					}
			
			for(int i=1;i<=n;i++) 
				for(int j=1;j<=n;j++)
					if(arr[i][j]=='.' && !visit[i][j])
						ans++;
						
			
			
			bw.write("#" + String.valueOf(test_case) + " " + String.valueOf(ans) + "\n");
		}

		bw.flush();
		bw.close();
	}
	
	public static void solve(int sx,int sy) {
		Queue<xy> q = new LinkedList<xy>();
		q.add(new xy(sx,sy));
		visit[sx][sy] = true;
		
		while(!q.isEmpty()) {
			xy outdata = q.poll();
			
			if(count[outdata.x][outdata.y]!=0) continue;
			
			for(int i=0;i<8;i++) {
				xy indata = new xy(outdata);
				indata.x += X[i];
				indata.y += Y[i];
				if(indata.x < 1 || indata.y <1 || indata.x>n || indata.y>n || arr[indata.x][indata.y]=='*' || visit[indata.x][indata.y]) continue;
				visit[indata.x][indata.y] = true;
				q.add(indata);
			}
		}
	}
	
	public static int chk(int sx,int sy) {
		int cnt=0;
		int nx,ny;
		for(int i=0;i<8;i++) {
			nx = sx + X[i];
			ny = sy + Y[i];
			if(arr[nx][ny]=='*') cnt++;
		}
		return cnt;
	}
}

class xy{
	int x,y;
	public xy(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public xy(xy x) {
		this.x = x.x;
		this.y = x.y;
	}
}