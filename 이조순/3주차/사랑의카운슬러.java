package SSAFYSTUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class 사랑의카운슬러 {

    static int n;
    static Node ary[];
    static boolean[] visit;
    static long ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            ary = new Node[n];
            visit = new boolean[n];
            ans = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                String[] str=br.readLine().split(" ");
                ary[i] = new Node(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
            }
            dfs(0,0);
            System.out.printf("#%d %d\n",tc,ans);
        }
    }

    private static void dfs(int x,int now) {
        if (x == n / 2) {
            long a = 0;
            long b = 0;
            for (int i = 0; i < n; i++) {
                if (visit[i]) {
                    a += ary[i].x;
                    b += ary[i].y;
                } else {
                    a -= ary[i].x;
                    b -= ary[i].y;
                }
            }
            ans = Math.min(a * a + b * b, ans);
            return;
        }

        for (int i = now; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(x+1,i+1);
                visit[i] = false;
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