package SSAFYSTUDY;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution2930 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            PriorityQueue<Integer> arr = new PriorityQueue<>(Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());

            while (n-- > 0) {
                String[] str = br.readLine().split(" ");
                int t = Integer.parseInt(str[0]);
                if (t == 2) {
                    if (arr.peek() != null) {
                        sb.append(arr.poll() + " ");
                    } else {
                        sb.append(-1 + " ");
                    }
                } else if (t == 1) {
                    arr.add(Integer.parseInt(str[1]));
                }
            }
            System.out.println("#" + test_case + " " + sb.toString());
        }
    }

}