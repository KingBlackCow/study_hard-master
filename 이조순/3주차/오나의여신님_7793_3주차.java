package SSAFYSTUDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class 오나의여신님_7793_3주차 {
    static int n, m;
    static int visit[][];
    static String[][] ary;
    static int goalX;
    static int goalY;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static Queue<Node> devilQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            ary = new String[n][m];
            visit = new int[n][m];
            devilQ = new LinkedList<>();
            int startX = 0, startY = 0;
            for (int j = 0; j < n; j++) {
                String[] str = br.readLine().split("");
                for (int k = 0; k < m; k++) {
                    ary[j][k] = str[k];
                    if (ary[j][k].equals("D")) {
                        goalX = j;
                        goalY = k;
                    } else if (ary[j][k].equals("*")) {
                        visit[j][k] = -1;
                        devilQ.add(new Node(j, k, 0));
                    } else if (ary[j][k].equals("S")) {
                        startX = j;
                        startY = k;
                    }
                }
            }
            int res = bfs(startX, startY);
            if (res != -1) {
                System.out.println("#" + i + " " + res);
            } else {
                System.out.println("#" + i + " " + "GAME OVER");
            }


        }
    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        visit[x][y] = 1;
        while (!q.isEmpty()) {
            int size = devilQ.size();
            for (int t = 0; t < size; t++) {
                if (!devilQ.isEmpty()) {
                    Node tmpDevil = devilQ.poll();
                    for (int i = 0; i < 4; i++) {
                        int r = tmpDevil.x + dx[i];
                        int c = tmpDevil.y + dy[i];

                        if (r >= 0 && r < n && c >= 0 && c < m) {
                            if (visit[r][c] == 0 || visit[r][c] == 1) {
                                if (ary[r][c].equals(".") || ary[r][c].equals("S")) {
                                    visit[r][c] = -1;
                                    devilQ.add(new Node(r, c, 0));
                                }
                            }
                        }
                    }
                }
            }

            int size2 = q.size();
            for (int t = 0; t < size2; t++) {
                if (!q.isEmpty()) {
                    Node tmp = q.poll();
                    if (tmp.x == goalX && tmp.y == goalY) {
                        return tmp.cnt;
                    }
                    for (int i = 0; i < 4; i++) {
                        int r = tmp.x + dx[i];
                        int c = tmp.y + dy[i];

                        if (r >= 0 && r < n && c >= 0 && c < m) {
                            if (visit[r][c] == 0) {
                                if (ary[r][c].equals(".") || ary[r][c].equals("D")) {
                                    visit[r][c] = 1;
                                    q.add(new Node(r, c, tmp.cnt + 1));
                                }
                            }
                        }
                    }
                }
            }

        }
        return -1;
    }

    static class Node {
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}