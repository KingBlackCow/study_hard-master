import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class xy_4112 {
	int value;
	int cnt;
	xy_4112(int value, int cnt) {
		this.value=value;
		this.cnt=cnt;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
public class _4112_이상한_피라미드_탐험 {
	static final int MAX = 10001;
	static ArrayList<Integer> ary[] = new ArrayList[MAX];
	static boolean ary_load[][] = new boolean[MAX][MAX];
	static boolean visit[] = new boolean[MAX];
	
	static void init() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for(int i=1;i<MAX;i++)
			ary[i] = new ArrayList<Integer>();
		load_set();
		
		for(int t=1;t<=tc;t++) {
			int fs = sc.nextInt();
			int se = sc.nextInt();
			
//			for(int i=1;i<MAX;i++) {
//				System.out.print(i+": ");
//				for(Integer item : ary[i]) {
//					System.out.print(item+" ");
//				}
//				System.out.println();
//			}
			System.out.print("#"+t+" ");
			solve(fs, se);
		}
	}
	
	static void load_set() {
		for(boolean item[] : ary_load)
			Arrays.fill(item, false);
		
		//왼쪽 끝이면 index-floor+1 (우측상단)
		//오른쪽 끝이면 index-floor (좌측상단)
		//중간에 껴잇다면 index-floor+1, index-floor (우측,좌측상단)
		int now = 1;
		for(int floor=1;;floor++) {
			int index=0;
//			System.out.println("floor:"+floor);
			for(index=now; index<now+floor;index++) {
				if (index > MAX-1) break;
				//좌측끝이 아니라면
				if (index != now) {	
					//좌측상단 길내주기, 바로왼쪽 길내주기
					add_load(index, index-floor);
					add_load(index, index-1);
				}
				//우측끝이 아니라면
				if (index != now+floor-1) {	
					//우측상단 길내주기, 바로오른쪽 길내주기
					add_load(index, index-floor+1);
					if (index != MAX-1)
					add_load(index, index+1);
				}
//				System.out.print(index+" ");
			}
//			System.out.println();
			if (index > MAX-1) break;
			now = index;
		}
	}
	static void add_load(int start, int end) {
		if (!ary_load[start][end]) {
			ary_load[start][end] = true;
			ary[start].add(end);
		}
		if (!ary_load[end][start]) {
			ary_load[end][start] = true;
			ary[end].add(start);
		}
	}
	static void solve(int fs, int se) {
		Arrays.fill(visit, false);
		Queue<xy_4112>q = new LinkedList<xy_4112>();
		q.add(new xy_4112(fs, 0));
		visit[fs] = true;
		while(!q.isEmpty()) {
			xy_4112 out = q.poll();
			if (out.getValue() == se) {
				System.out.println(out.getCnt());
				return;
			}
			for(int i=0;i<ary[out.getValue()].size();i++) {
				int next = ary[out.getValue()].get(i);
				if (!visit[next]) {
					visit[next]=true;
					q.add(new xy_4112(next, out.getCnt()+1));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
	}
}
