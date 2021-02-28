

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int sum = 0;

            for (int i = 1; i <= n; i++) {
                if (i % 2 == 1) {
                    sum += i;
                } else {
                    sum -= i;
                }
            }
            System.out.println("#" + test + " " + sum);
        }
    }
}

