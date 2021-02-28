import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ11724 {
    static int n;
    static int m;
    static List<List<Integer>> list;
    static boolean visit[];
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        visit=new boolean[n+1];
        list=new ArrayList<>(n+1);
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int first=Integer.parseInt(st.nextToken());
            int last=Integer.parseInt(st.nextToken());
            list.get(first).add(last);
            list.get(last).add(first);
        }
        int cnt=0;
        for (int i = 1; i <= n; i++) {
            if(!visit[i]){
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    private static void dfs(int n) {

        if(!visit[n]){
            visit[n]=true;
            for (Integer i: list.get(n)) {
                dfs(i);
            }
        }
    }
}