package SSAFYSTUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11497_통나무건너뛰기_6주차 {
    static int n;
    static int[] ary;
    static List<Integer> list;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            n = Integer.parseInt(br.readLine());
            ary = new int[n];
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);
            int order=0;
            int reverse=1;
            for (int i = 0; i < list.size(); i++) {
                if (i % 2 == 0) {
                    ary[order++] = list.get(i);
                } else {
                    ary[n-reverse++] = list.get(i);
                }
            }

            min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n - 1; i++) {
                max = Math.max(Math.abs(ary[i + 1] - ary[i]), max);
            }
            max = Math.max(Math.abs(ary[0] - ary[n - 1]), max);
            System.out.println(max);
        }
    }
}



