package SSAFYSTUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 격자판의숫자이어붙이기2819_3주차 {
    static String[][] ary;
    static Set<String> set;
    static boolean visit[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            ary = new String[4][4];
            StringTokenizer st;
            set = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    ary[i][j] = st.nextToken();
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j,ary[i][j]);
                }
            }
            System.out.println("#" + tc + " " + set.size());

        }
    }


    private static void dfs(int a, int b, String str) {
        if(str.length()==7){
            set.add(str);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int r=a+dx[k];
            int c=b+dy[k];
            if (r >= 0 && r < 4 && c >= 0 && c < 4) {
                dfs(r,c, str+ary[r][c]);
            }
        }
    }


}