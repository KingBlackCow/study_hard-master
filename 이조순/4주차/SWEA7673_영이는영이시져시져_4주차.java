package SSAFYSTUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SWEA7673_영이는영이시져시져_4주차 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] ary = new int[n][n];
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    ary[i][j] = Integer.parseInt(str[j]);
                    arr[i][j] = Integer.MAX_VALUE;
                }
            }
            int five = 0, two = 0, number = ary[0][0];
            if (number == 0) five = two = 1;
            while (true) {
                if (number == 0) break;
                while (number % 2 == 0) {
                    two++;
                    number /= 2;
                }
                while (number % 5 == 0) {
                    five++;
                    number /= 5;
                }
                break;
            }
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, 0, two, five));
            arr[0][0] = Math.min(two, five);

            while (!pq.isEmpty()) {
                Node tmp = pq.poll();

                if (tmp.x == n - 1 && tmp.y == n - 1) break;
                if (tmp.x + 1 < n && ary[tmp.x + 1][tmp.y] != 0) {
                    int num = ary[tmp.x + 1][tmp.y];
                    int twoTmp = tmp.two;
                    int fiveTmp = tmp.five;

                    while (true) {
                        if (num == 0) break;
                        while (num % 2 == 0) {
                            twoTmp++;
                            num /= 2;
                        }
                        while (num % 5 == 0) {
                            fiveTmp++;
                            num /= 5;
                        }
                        break;
                    }

                    if (arr[tmp.x + 1][tmp.y] > Math.min(twoTmp, fiveTmp)) {
                        arr[tmp.x + 1][tmp.y] = Math.min(twoTmp, fiveTmp);
                        pq.add(new Node(tmp.x + 1, tmp.y, twoTmp, fiveTmp));
                    }
                }
                if (tmp.y + 1 < n && ary[tmp.x][tmp.y + 1] != 0) {
                    int num = ary[tmp.x][tmp.y + 1];
                    int twoTmp = tmp.two;
                    int fiveTmp = tmp.five;

                    while (true) {
                        if (num == 0) break;
                        while (num % 2 == 0) {
                            twoTmp++;
                            num /= 2;
                        }
                        while (num % 5 == 0) {
                            fiveTmp++;
                            num /= 5;
                        }
                        break;
                    }
                    if (arr[tmp.x][tmp.y + 1] > Math.min(twoTmp, fiveTmp)) {
                        arr[tmp.x][tmp.y + 1] = Math.min(twoTmp, fiveTmp);
                        pq.add(new Node(tmp.x, tmp.y + 1, twoTmp, fiveTmp));
                    }
                }
            }
            System.out.println("#" + test_case + " " + arr[n - 1][n - 1]);
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, two, five;

        Node(int x, int y, int two, int five) {
            this.x = x;
            this.y = y;
            this.two = two;
            this.five = five;
        }

        @Override
        public int compareTo(Node o) {
            return Math.min(o.two, o.five) > Math.min(this.five, this.two) ? -1 : 1;
        }
    }
}
