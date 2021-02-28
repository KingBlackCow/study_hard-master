
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class BOJ2667 {
    static boolean[][] visit;
    static int[][] ary;
    static int res;
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ary = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                ary[i][j] = Integer.parseInt(str[j]);
            }
        }
        visit = new boolean[n][n];
        res = 0;
        int turn = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && ary[i][j] == 1) {
                    turn++;
                    list.add(bfs(i, j));
                }

            }
        }
        System.out.println(turn);
        Collections.sort(list);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    private static int bfs(int k, int t) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(k, t));
        visit[k][t] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int r = tmp.x + dx[i];
                int c = tmp.y + dy[i];
                if (r >= 0 && r < n && c >= 0 && c < n) {
                    if (!visit[r][c] && ary[r][c] == 1) {
                        visit[r][c] = true;
                        q.add(new Node(r, c));
                    }
                }
            }
        }
        return cnt;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}