import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class xy_7793 {
	int y;
	int x;

	xy_7793(int y, int x) {
		this.y = y;
		this.x = x;
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

class move extends xy_7793 {
	int cnt;

	move(int y, int x, int cnt) {
		super(y, x);
		this.cnt = cnt;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}

public class _7793_오_나의_여신님 {
	static final int MAX = 51;
	static int H, W;
	static int ay[] = { -1, 1, 0, 0 };
	static int ax[] = { 0, 0, -1, 1 };

	static char map[][];
	static boolean visit_play[][] = new boolean[MAX][MAX];
	static boolean visit_devil[][] = new boolean[MAX][MAX];

	static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] temp = br.readLine().split(" ");
			H = Integer.parseInt(temp[0]);
			W = Integer.parseInt(temp[1]);
			map = new char[H][W];
			
			xy_7793 player = null;
			xy_7793 devil = null;
			Queue<xy_7793> d = new LinkedList<xy_7793>();
			Queue<move> p = new LinkedList<move>();
			
			for (boolean[] item : visit_play)
				Arrays.fill(item, false);
			for (boolean[] item : visit_devil)
				Arrays.fill(item, false);
			
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					//여신이 D인줄 알아서 틀린문제
					if (map[i][j] == 'S') {
						player = new xy_7793(i, j);
						p.add(new move(player.getY(), player.getX(), 0));
						visit_play[player.getY()][player.getX()] = true;
					}
					if (map[i][j] == '*') {
						devil = new xy_7793(i, j);
						d.add(new xy_7793(devil.getY(), devil.getX()));
						visit_devil[devil.getY()][devil.getX()] = true;
					}
				}
			}
			int result = solve(d, p);
			System.out.print("#" + t + " ");
			if (result == -1)
				System.out.println("GAME OVER");
			else
				System.out.println(result);
		}
	}

	static int solve(Queue<xy_7793> d, Queue<move> p) {
		while (!p.isEmpty()) {
//			view();
			int devilSize = d.size();
			int playerSize = p.size();
			
			if (playerSize==0) break;
			
			while (devilSize-- > 0) {
				xy_7793 out = d.poll();
				int y = out.getY();
				int x = out.getX();
				for (int i = 0; i < 4; i++) {
					int ny = y + ay[i];
					int nx = x + ax[i];
					if (!range(ny, nx)) {
						if (!visit_devil[ny][nx] && map[ny][nx] != 'D') {
							visit_devil[ny][nx] = true;
//						map[ny][nx] = '*';
							d.add(new xy_7793(ny, nx));
						}
					}
				}
			}
			while (playerSize-- > 0) {
				move out = p.poll();
				int y = out.getY();
				int x = out.getX();
				int cnt = out.getCnt();
				if (map[y][x] == 'D') {
					return cnt;
				}
				for (int i = 0; i < 4; i++) {
					int ny = y + ay[i];
					int nx = x + ax[i];
					if (!range(ny, nx)) {
						if (!visit_play[ny][nx] && !visit_devil[ny][nx]) {
							visit_play[ny][nx] = true;
//						map[ny][nx] = 'D';
							p.add(new move(ny, nx, cnt + 1));
						}
					}
				}
			}
		}
		return -1;
	}

	static boolean range(int y, int x) {
		return y < 0 || x < 0 || y > H - 1 || x > W - 1 || map[y][x] == 'X';
	}

	static void view() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		init();
	}
}
