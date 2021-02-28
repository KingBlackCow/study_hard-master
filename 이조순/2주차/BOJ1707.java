

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1707 {
    static boolean[] visit;
    static List<Integer>[] list;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            visit = new boolean[n + 1];
            list = new ArrayList[n + 1];
            for (int j = 1; j < n + 1; j++) {
                list[j] = new ArrayList<>();
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                list[first].add(second);
                list[second].add(first);
            }

            if (bfs())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    static boolean bfs(){
        boolean res = true;
        int[] visit = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            if (visit[i] == 0) {
                q.offer(i);
                visit[i] = 1;
                while (!q.isEmpty() && res) {
                    int cnt = q.poll();
                    for (Integer j : list[cnt]) {
                        if (visit[j] == 0) {
                            q.offer(j);
                            visit[j] = visit[cnt] * -1;
                        } else if (visit[j] == visit[cnt]) {
                            res = false;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}