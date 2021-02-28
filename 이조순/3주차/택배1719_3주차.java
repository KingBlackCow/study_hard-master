

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 택배1719_3주차 {
    public static int n;
    public static int[][] distance;
    public static int INF = 10000000;
    static int[][] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        distance = new int[n + 1][n + 1];
        road = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                distance[i][j] = INF;
            }
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            distance[start][end] = weight;
            distance[end][start] = weight;
            road[start][end] = start;
            road[end][start] = end;

        }

        floydWarshall();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) sb.append("- ");
                else sb.append(road[j][i] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        road[i][j] = road[k][j];
                    }
                }
            }
        }
    }
}