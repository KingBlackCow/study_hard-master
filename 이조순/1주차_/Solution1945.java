import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1945 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            int ary[]=new int[26];
            String str=br.readLine();
            for (int i = 0; i < str.length(); i++) {
                int a=str.charAt(i)-'a';
                ary[a]++;
            }
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < ary.length; i++) {
                if(ary[i]%2!=0){
                    sb.append((char)(i+97));
                }
            }
            if(sb.toString().equals("")) System.out.println("#"+test+" "+"Good");
            else System.out.println("#"+test+" "+sb.toString());
        }
    }
}


