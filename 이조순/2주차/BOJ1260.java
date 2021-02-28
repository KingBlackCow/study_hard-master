

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260 {
    static boolean[] visit;

    static void dfs(List<Integer> list[], int v) {
        visit[v] = true;
        System.out.print(v + " ");
        for (Integer i:list[v]) {
            if (!visit[i]) {
                dfs(list, i);
            }
        }
    }

    static void bfs(List<Integer> list[], int v) {
        visit[v] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        while(!q.isEmpty()){
            int tmp = q.poll();
            System.out.print(tmp+" ");
            for (Integer i:list[tmp]) {
                if(!visit[i]) {
                    visit[i]=true;
                    q.add(i);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        visit = new boolean[n+1];
        List<Integer> list[] = new ArrayList[n+1];

        for (int i = 0; i < n + 1; i++) {
            list[i]=new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first =Integer.parseInt(st.nextToken());
            int second =Integer.parseInt(st.nextToken());
            list[first].add(second);
            list[second].add(first);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(list[i]);
        }

        dfs(list, v);
        System.out.println();
        visit = new boolean[n+1];
        bfs(list,v);
    }
}