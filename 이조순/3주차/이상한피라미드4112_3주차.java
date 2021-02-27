package SSAFYSTUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 이상한피라미드4112_3주차 {
    static int n, m;
    static int min;
    static boolean visit[];
    static List[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList[10001];
        listMake();
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            visit = new boolean[10001];
            min = Integer.MAX_VALUE;
            bfs();
            System.out.println("#" + i + " " + min);
        }
    }

    private static void listMake() {
        for (int i = 1; i <= 10000; i++) {
            list[i] = new ArrayList<Integer>();
        }
        int level = 1;
        for (int i = 1; i <= 10000; i++) {
            for (int j = i; j < i + level; j++) {
                if (j <= 10000) {
                    if (j == i) {
                        if (j + level <= 10000) list[j].add(j + level);
                        if (j + level + 1 <= 10000) list[j].add(j + level + 1);
                        if (i != 1) {
                            if (j - level + 1 <= 10000) list[j].add(j - level + 1);
                            if (j + 1 <= 10000) list[j].add(j + 1);
                        }
                    } else if (j == i + level - 1) {
                        if (j - level <= 10000) list[j].add(j - level);
                        if (j - 1 <= 10000) list[j].add(j - 1);
                        if (j + level <= 10000) list[j].add(j + level);
                        if (j + 1 + level <= 10000) list[j].add(j + level + 1);

                    } else {
                        if (j - level + 1 <= 10000) list[j].add(j - level + 1);
                        if (j - level <= 10000) list[j].add(j - level);
                        if (j - 1 <= 10000) list[j].add(j - 1);

                        if (j + level <= 10000) list[j].add(j + level);
                        if (j + 1 + level <= 10000) list[j].add(j + level + 1);
                        if (j + 1 <= 10000) list[j].add(j + 1);

                    }
                }
            }
            i = i + level - 1;
            level++;
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 0));
        visit[n] = true;
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.x == m) {
                min = tmp.cnt;
                return;
            }
            for (Object i : list[tmp.x]) {
                int tmpI = (int) i;
                if (!visit[tmpI]) {
                    q.add(new Node(tmpI, tmp.cnt + 1));
                    visit[tmpI] = true;
                }
            }

        }

    }

    static class Node {
        int x;
        int cnt;

        Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

}
