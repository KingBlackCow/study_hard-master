import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class xy_1868 {
	int y;
	int x;
	xy_1868(int y, int x) {
		this.y=y;
		this.x=x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
}
public class _1868_파핑파핑_지뢰찾기 {
	static final int MAX = 301;
	static int N;
	static int click;
	
	static int ay[] = {-1,1,0,0,-1,-1,1,1}; 
	static int ax[] = {0,0,-1,1,-1,1,-1,1};
	
	static char map[][] = new char[MAX][MAX];
	static int count[][] = new int[MAX][MAX];
	static boolean visit[][] = new boolean[MAX][MAX];
	static ArrayList<xy_1868> mine = new ArrayList<>();
	
	static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			N = Integer.parseInt(br.readLine());
			mine.clear();
			
			for(int i=0;i<N;i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0;j<N;j++)
					if (map[i][j] == '*')
						mine.add(new xy_1868(i, j));
			}
			click=0;
			mapset();
			search();
			check();
			System.out.println("#"+t+" "+click);
		}
	}
	static void mapset() {
		for(int item[] : count)
			Arrays.fill(item, 0);

		for(boolean item[] : visit)
			Arrays.fill(item, false);
		
		for(xy_1868 item : mine) {
			for(int i=0;i<8;i++) {
				int ny = item.getY()+ay[i];
				int nx = item.getX()+ax[i];
				if (!range(ny, nx) && range_visit(ny, nx)) {
					count[ny][nx]++;
				}
			}
		}
		
	}
	static void search() {
		Queue<xy_1868>q=new LinkedList<>();
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if (count[i][j] == 0 && range_visit(i, j)) {
					q.add(new xy_1868(i, j));
					visit[i][j] = true;
					click++;
					while(!q.isEmpty()) {
						xy_1868 out = q.poll();
						int y = out.getY();
						int x = out.getX();
						for(int k=0;k<8;k++) {
							int ny = y+ay[k];
							int nx = x+ax[k];
							if (!range(ny, nx) && range_visit(ny, nx)) {
								if (count[ny][nx] == 0)
									q.add(new xy_1868(ny, nx));
								visit[ny][nx] = true;
							}
						}
					}
				}
	}
	static void check() {
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if (range_visit(i,j) && count[i][j] != 0) {
					click++;
					visit[i][j] = true;
				}
	}
	static boolean range(int y, int x) {
		return y<0||x<0||y>N-1||x>N-1;
	}
	static boolean range_visit(int y, int x) {
		return !visit[y][x] && map[y][x] == '.';
	}
	static void view() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				System.out.print((visit[i][j] ? 1: 0)+" ");
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
	}
}
