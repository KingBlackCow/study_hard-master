
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.StringTokenizer;


public class BOJ8972_미친아두이노_4주차 {
    static int n, m;
    static String[][] ary;
    static boolean[][] visit;
    static int arr[];
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int Hx, Hy, Ex, Ey;
    static int res;
    static Queue<Node> q;
    static Node node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n][m];
        q = new LinkedList<>();
        ary = new String[n][m];
        node = new Node(0, 0);
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                ary[i][j] = str[j];
                if (ary[i][j].equals("R")) {
                    q.add(new Node(i, j));

                }
                if (ary[i][j].equals("I")) {
                    node.x = i;
                    node.y = j;
                }
            }
        }
        String order = br.readLine();
        int turn = 0;
        for (int i = 0; i < order.length(); i++) {
            turn++;
            ary[node.x][node.y] = ".";
            if (order.charAt(i) == '1') {
                node.x += 1;
                node.y -= 1;
            } else if (order.charAt(i) == '2') {
                node.x += 1;
            } else if (order.charAt(i) == '3') {
                node.x += 1;
                node.y += 1;
            } else if (order.charAt(i) == '4') {
                node.y -= 1;
            } else if (order.charAt(i) == '6') {
                node.y += 1;
            } else if (order.charAt(i) == '7') {
                node.x -= 1;
                node.y -= 1;
            } else if (order.charAt(i) == '8') {
                node.x -= 1;
            } else if (order.charAt(i) == '9') {
                node.x -= 1;
                node.y += 1;
            }

            if (ary[node.x][node.y].equals("R")) {
                System.out.println("kraj " + turn);
                System.exit(0);
            }
            visit[node.x][node.y] = true;
            ary[node.x][node.y] = "I";
            boolean res = bfs();
            if (!res) {
                System.out.println("kraj " + turn);
                System.exit(0);
            }
            visit = new boolean[n][m];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ary[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean bfs() {
        int qSize = q.size();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < qSize; i++) {
            Node tmp = q.poll();
            visit[tmp.x][tmp.y] = false;
            int r = tmp.x;
            int c = tmp.y;
            if (tmp.x > node.x) {
                r--;
            } else if (tmp.x < node.x) {
                r++;
            }
            if (tmp.y > node.y) {
                c--;
            } else if (tmp.y < node.y) {
                c++;
            }
            if (!visit[r][c]) {
                list.add(new Node(r, c));
                visit[r][c] = true;
                ary[tmp.x][tmp.y] = ".";

            } else {
                if (node.x == r && node.y == c) return false;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).x == r && list.get(j).y == c) {
                        list.remove(j);
                    }
                }
                ary[tmp.x][tmp.y] = ".";
            }
        }
        for (Node nodeTmp : list) {
            q.add(nodeTmp);
            ary[nodeTmp.x][nodeTmp.y] = "R";
        }

        return true;
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