

import java.io.*;
import java.util.*;

public class NM5 {
    static int m, n;
    static int ary[] = new int[9];
    static boolean visit[] = new boolean[9];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList nList;
    static void dfs(int cnt) throws IOException {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                bw.write(ary[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            ary[cnt] = (int) nList.get(i-1);
            dfs(cnt + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nList =new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nList);
        dfs(0);
        br.close();
        bw.close();
    }

}