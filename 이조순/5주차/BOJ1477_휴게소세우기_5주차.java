

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1477_휴게소세우기_5주차 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int L = Integer.parseInt(input[2]);
        int left = 0;
        int right = 0;

        int[] ary = new int[N+2];
        ary[0] = 0;
        ary[N+1] = L;

        input = br.readLine().split(" ");
        for(int i=1; i<=N; i++) {
            ary[i] = Integer.parseInt(input[i-1]);
        }
        Arrays.sort(ary);

        for(int i=1; i<=N+1; i++) {
            right = Math.max(right, ary[i]-ary[i-1]);
        }

        while(left<=right) {
            int mid = (left+right)/2;
            int sum = 0;

            for(int i=1; i<N+2; i++) {
                if(ary[i]>ary[i-1])
                    sum += (ary[i]-ary[i-1]-1)/mid;
            }

            if(sum>M)
                left = mid+1;
            else
                right = mid-1;
        }

        System.out.println(left);
    }
}