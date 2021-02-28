
import java.io.*;
import java.util.*;

public class NM4 {
    static int m, n;
    static int ary[] = new int[9];
    static boolean visit[] = new boolean[9];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void dfs(int cnt) throws IOException {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                bw.write(ary[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (cnt == 0 || ary[cnt - 1] <= i) {
                ary[cnt] = i;
                dfs(cnt + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(0);
        br.close();
        bw.close();
    }

}