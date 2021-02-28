

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 대칭차집합1269_3주차 {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set1.add(Integer.parseInt(st.nextToken()));
        }
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            set2.add(Integer.parseInt(st.nextToken()));
        }
        int a=0;
        for (Integer i:set1) {
            if(!set2.contains(i)){
                a++;
            }
        }
        int b=0;
        for (Integer i:set2) {
            if(!set1.contains(i)){
                b++;
            }
        }
        System.out.println(a+b);
    }


}