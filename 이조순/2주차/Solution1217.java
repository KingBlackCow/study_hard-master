

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution1217 {
    public static void main(String args[]) throws Exception {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //int T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int t=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            long res= (long) Math.pow(n,m);
            System.out.println("#"+t+" "+res);
        }
    }
}