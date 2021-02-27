package SSAFYSTUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution9280 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] visit = new int[n + 1];
            int[] park = new int[n + 1];
            int[] car = new int[m + 1];
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                park[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 1; i <= m; i++) {
                car[i] = Integer.parseInt(br.readLine());
            }
            int cnt = m * 2;
            Queue<Integer> waitQ = new LinkedList<>();
            while (cnt-- > 0) {
                int order = Integer.parseInt(br.readLine());
                if (order > 0) {
                    waitQ.add(order);
                    for (int i = 1; i <= n; i++) {
                        if (visit[i] == 0) {
                            int carNum = waitQ.poll();
                            int carTmp = car[carNum];
                            sum += park[i] * carTmp;
                            visit[i] = carNum;
                            break;
                        }
                    }
                } else {
                    for (int i = 1; i <= n; i++) {
                        if (visit[i] == Math.abs(order)) {
                            visit[i] = 0;
                            if (!waitQ.isEmpty()) {
                                int carNum = waitQ.poll();
                                int carTmp = car[carNum];
                                sum += park[i] * carTmp;
                                visit[i] = carNum;
                            }
                            break;
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }

}