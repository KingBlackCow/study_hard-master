

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class 강의실배정11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end));
        }

        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(list.get(0).end);

        for (int i = 1; i < N; i++) {

            if (pq.peek() <= list.get(i).start) {
                pq.poll();
            }
            pq.offer(list.get(i).end);
        }


        bw.write(pq.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node implements Comparable<Node> {
        int start;
        int end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.start - o.start;
        }
    }


}