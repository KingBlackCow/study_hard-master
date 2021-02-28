

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107_리모컨_5주차 {
    static boolean[] broken;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int brokenNum = Integer.parseInt(br.readLine());
        broken = new boolean[10];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<brokenNum; i++){
            broken[Integer.parseInt(st.nextToken())] = true;
        }

        int ans = Math.abs(N - 100);
        for(int i=0; i<1000000; i++){
            int len = Solution(i);
            if(len != 0){
                int cnt = Math.abs(i - N);
                if(ans > len + cnt){
                    ans = len+cnt;
                }
            }
        }
        System.out.println(ans);
    }

    private static int Solution(int n){
        int len=0;
        if(n == 0){
            if(broken[0])
                len = 0;
            else{
                len = 1;
            }
            return len;
        }

        while(n > 0){
            if(broken[n%10]){
                len = 0;
                return len;
            }
            len++;
            n /= 10;
        }
        return len;
    }
}