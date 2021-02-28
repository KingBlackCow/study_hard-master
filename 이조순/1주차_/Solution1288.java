

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1288 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            //StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int cnt = 1;
            boolean arr[]=new boolean[11];
            boolean check = false;
            while (!check) {
                int tmp = n * cnt++;
                int tmp2;
                do {
                    tmp2 = tmp % 10;
                    tmp /= 10;
                    arr[tmp2] = true;

                } while (tmp > 0);
                int t = 0;
                while (arr[t++]) {
                    if (t == 10) {
                        cnt--;
                        check = true;
                    }
                }
            }
            System.out.println("#" + test + " " + n*cnt);
        }
    }
}

