package SSAFYSTUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA1868_파핑파핑지뢰찾기_4주차 {

    static int[][] arr;
    static boolean[][] visit;
    static int n;
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            String[][] ary = new String[n][n];
            arr = new int[n][n];
            visit = new boolean[n][n];
            int res = 0;

            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split("");
                for (int j = 0; j < n; j++) {
                    ary[i][j] = str[j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ary[i][j].equals("*")) {
                        arr[i][j] = -1;
                        visit[i][j] = true;
                        continue;
                    }
                    int cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int r = i + dx[k];
                        int c = j + dy[k];
                        if (r >= 0 && c >= 0 && r < n && c < n) {
                            if (ary[r][c].equals("*")) cnt++;
                        }
                    }
                    arr[i][j] = cnt;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0 && !visit[i][j]) {
                        res++;
                        bfs(i, j);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) res++;
                }
            }
            System.out.println("#" + tc + " " + res);
        }
    }

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;
        while (!q.isEmpty()) {
            Node tmp = q.poll();

            for (int i = 0; i < 8; i++) {
                int r = tmp.x + dx[i];
                int c = tmp.y + dy[i];

                if (r >= 0 && c >= 0 && r < n && c < n) {
                    if (!visit[r][c] && arr[r][c] > 0) {
                        visit[r][c] = true;
                    } else if (!visit[r][c] && arr[r][c] == 0) {
                        visit[r][c] = true;
                        q.add(new Node(r, c));
                    }
                }
            }
        }
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