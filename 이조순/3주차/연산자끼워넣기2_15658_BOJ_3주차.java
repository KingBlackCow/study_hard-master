package SSAFYSTUDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class 연산자끼워넣기2_15658_BOJ_3주차 {
    static int n;
    static int m;
    static int cnt = 0;
    static int arr[];
    static int ary[];
    static boolean visit[];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());

        ary = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        arr = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(ary[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int x, int cnt) {
        if (cnt >= n) {
            max = Math.max(x, max);
            min = Math.min(x, min);
            return;
        }

        if (arr[0] > 0) {
            arr[0]--;
            dfs(x + ary[cnt], cnt + 1);
            arr[0]++;
        }

        if (arr[1] > 0) {
            arr[1]--;
            dfs(x - ary[cnt], cnt + 1);
            arr[1]++;
        }

        if (arr[2] > 0) {
            arr[2]--;
            dfs(x * ary[cnt], cnt + 1);
            arr[2]++;
        }

        if (arr[3] > 0) {
            arr[3]--;
            dfs(x / ary[cnt], cnt + 1);
            arr[3]++;
        }
    }
}