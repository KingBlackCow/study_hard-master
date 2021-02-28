
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
import java.util.StringTokenizer;

public class 수이어쓰기2 {
    static long calc(int n) {
        long ans = 0;
        for (int start = 1, len = 1; start <= n; start *= 10, len++) {
            int end = start * 10 - 1;
            if (end >= n) {
                ans += (long) ((n - start + 1) * len);
            } else ans += (long) ((end - start + 1) * len);

        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (calc(n) < k) {
            System.out.println(-1);
        }
        int left = 1;
        int right = n;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long len = calc(mid);
            if (k > len) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        String res = String.valueOf(ans);
        long len2 = calc(ans);
        System.out.println(res.charAt((int) (res.length() - (len2 - k) - 1)));
    }
}