
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1989 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            String str = br.readLine();
            int sum=0;
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) == str.charAt(str.length() - i - 1)) sum = 1;
                else sum = 0;
            }
            System.out.println("#" + test + " " + sum);
        }
    }
}

