package SSAFYSTUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10163_색종이_6주차 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] ary = new int[101][101];
        int n = Integer.parseInt(br.readLine());
        int[] res = new int[n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = 100 - Integer.parseInt(st.nextToken());
            int garo = Integer.parseInt(st.nextToken());
            int sero = Integer.parseInt(st.nextToken());

            for (int j = x - sero + 1; j <= x; j++) {
                for (int k = y; k <= y + garo - 1; k++) {
                    ary[j][k] = i;
                }
            }
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (ary[i][j] != 0) {
                    res[ary[i][j]]++;
                }
            }
        }
        for (int i = 1; i < n + 1; i++)
            System.out.println(res[i]);
    }
}