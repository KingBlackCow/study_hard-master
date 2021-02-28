

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class 핑거스냅17394_3주차 {
    static int n;
    static int a,b;
    static int min = Integer.MAX_VALUE;
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            visit = new boolean[1000001];
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bfs(n, 0);
            if(min!=Integer.MAX_VALUE){
                System.out.println(min);
            }
            else{
                System.out.println(-1);
            }
        }
    }

    private static void bfs(int x, int cnt) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, cnt));
        min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            visit[tmp.x] = true;
            if (tmp.x >= a && tmp.x<=b) {
                if(isPrime(tmp.x)){
                    min=Math.min(tmp.cnt,min);
                    return ;
                }
            }
            if(tmp.x/2>=2){
                if(!visit[tmp.x/2]){
                    q.add(new Node(tmp.x / 2, tmp.cnt + 1));
                }

            }
            if(tmp.x/3>=2){
                if(!visit[tmp.x/3]) {
                    q.add(new Node(tmp.x / 3, tmp.cnt + 1));
                }
            }
            if(tmp.x+1<1000000){
                if(!visit[tmp.x+1]) {
                    q.add(new Node(tmp.x + 1, tmp.cnt + 1));
                }
            }
            if((tmp.x-1)>=2){
                if(!visit[tmp.x-1]) {
                    q.add(new Node(tmp.x - 1, tmp.cnt + 1));
                }
            }
        }
    }


    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    static class Node {
        int x;
        int cnt;

        Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}