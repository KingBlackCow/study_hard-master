package SSAFYSTUDY;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2234_성곽_5주차 {

    static int[][] ary;
    static int max;
    static int room;
    static int n, m;
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        room = 0;
        max = 0;
        visit = new boolean[n][m];
        ary = new int[n][m];

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (!visit[i][j]) {
                    max=Math.max(bfs(i,j),max);
                    ++room;
                }
            }
        }

        System.out.println(room);
        System.out.println(max);


        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                visit = new boolean[n][m];
                for (int k = 1; k <= 8; k *= 2) {
                    if ((ary[i][j] & k) != 0) {
                        ary[i][j] -= k;
                        max = Math.max(bfs(i, j), max);
                        ary[i][j] += k;
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visit[x][y] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int bit = (int) Math.pow(2, i);
                if ((ary[tmp.x][tmp.y] & bit) == 0) {
                    int r = tmp.x + dx[i];
                    int c = tmp.y + dy[i];
                    if (r >= n || r < 0 || c >= m || c < 0 ) continue;
                    if(!visit[r][c]){
                        cnt++;
                        visit[r][c] = true;
                        q.offer(new Point(r, c));
                    }
                }
            }

        }
        return cnt;
    }
}