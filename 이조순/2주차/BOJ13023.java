
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class BOJ13023 {
    static int n;
    static int m;
    static int res;
    static ArrayList<List<Integer>> list;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>(n);
        res = 0;
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list.get(first).add(second);
            list.get(second).add(first);
        }

        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            visit[i] = true;
            DFS(i, 0);
            if (res == 1) break;
            visit[i] = false;
        }
        System.out.println(res);
    }

    private static void DFS(int n, int cnt) {
        if (cnt == 4) {
            res = 1;
            return;
        }

        for (Integer i : list.get(n)) {
            if (!visit[i]) {
                visit[i] = true;
                DFS(i, cnt + 1);
                visit[i] = false;
            }
        }
    }
}