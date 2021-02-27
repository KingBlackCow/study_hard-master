

import java.util.ArrayList;
import java.util.Scanner;

class xy_1494{
	int y;
	int x;
	xy_1494(int y, int x) {
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
public class _1494_사랑의카운슬러 {
	static final int MAX = 21;
	static int ew;
	static long result;
	static boolean visit[] = new boolean[MAX];
	
	static ArrayList<xy_1494> earthworm = new ArrayList<xy_1494>();
	
	static void init() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			ew = sc.nextInt();
			earthworm.clear();
			for(int e=0;e<ew;e++) {
				int ey=sc.nextInt();
				int ex=sc.nextInt();
				earthworm.add(new xy_1494(ey,ex));
			}
			result = Long.MAX_VALUE;
			solve(0, 0);
			System.out.println("#"+t+" "+result);
		}
		sc.close();
	}
	static void solve(int index, int cnt) {
		if (cnt == ew/2) {
			long x=0,y=0;
			for(int i=0;i<ew;i++) {
				if (visit[i]) {
					y+= earthworm.get(i).getY();
					x+= earthworm.get(i).getX();
				}
				else {
					y-= earthworm.get(i).getY();
					x-= earthworm.get(i).getX();
				}
			}
			result = Math.min(result, x*x+y*y);
			return;
		}
		for(int i=index;i<ew;i++) {
			if (!visit[i]) {
				visit[i] = true;
				solve(i+1, cnt+1);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		init();
	}
}
