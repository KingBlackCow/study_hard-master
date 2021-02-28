
import java.io.*;
import java.util.*;

public class NM3 {
    static int m, n;
    static int list[] = new int[9];
    static boolean visit[] = new boolean[9];

    static void dfs(int cnt) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                bw.write(String.valueOf(list[i])+" ");
            }

            bw.newLine();
            bw.flush();
            return;
        }

        for (int i = 1; i <= n; i++) {
            list[cnt] = i;
            dfs(cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(0);
    }

}