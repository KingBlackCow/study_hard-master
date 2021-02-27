package SSAFY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1959 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            if (n < m) {
                for (int i = 0; i < m - n + 1; i++) {
                    int tmpMax = 0;
                    int bTmp = i;
                    for (int j = 0; j < n; j++) {
                        tmpMax += a[j] * b[bTmp++];

                    }
                    if (tmpMax > max) {
                        max = tmpMax;
                    }
                }
            } else {
                for (int i = 0; i < n - m + 1; i++) {
                    int tmpMax = 0;
                    int aTmp = i;
                    for (int j = 0; j < m; j++) {
                        tmpMax += b[j] * a[aTmp++];

                    }
                    if (tmpMax > max) {
                        max = tmpMax;
                    }
                }
            }
            System.out.println("#" + test + " " + max);
        }
    }
}

