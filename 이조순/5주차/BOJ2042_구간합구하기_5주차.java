

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2042_구간합구하기_5주차 {
    static int n, m, k;
    static long[] ary;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ary = new long[n];
        tree = new long[n * 16];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        init(0, n - 1, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int mode = Integer.parseInt(st.nextToken());
            long first = Long.parseLong(st.nextToken())-1;
            long second = Long.parseLong(st.nextToken());
            if (mode == 1) {
                update(0, n - 1, 1,  first, second-ary[(int) first]);
            } else if (mode == 2) {
                sb.append(sum(0, n - 1, 1, first, second-1) + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static long init(long start, long end, long node) {
        if (start == end) return tree[(int) node] = ary[(int) start];
        long mid = (start + end) / 2;
        return tree[(int) node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    private static long sum(long start, long end, long node, long left, long right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[(int) node];
        long mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    private static void update(long start, long end, long node, long index, long dif) {
        if (index < start || index > end) return;
        tree[(int) node] += dif;
        if (start == end) return;
        int mid = (int) ((start + end) / 2);
        update(start, mid, node * 2, index, dif);
        update(mid + 1, end, node * 2 + 1, index, dif);
    }
}