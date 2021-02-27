import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2477_참외밭_6주차 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int maxY = 0;
        int maxX = 0;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            if (one >= 3) {
                maxY = Math.max(maxY, two);
            } else {
                maxX = Math.max(maxX, two);
            }
            q.add(two);
        }
        int tmp = 0;
        while (true) {
            tmp = q.poll();
            if (tmp == maxY) {
                break;
            } else {
                q.add(tmp);
            }
        }
        int sum = maxY * maxX;
        if (q.poll() != maxX) {

        } else {
            q.poll();
        }

        sum -= q.poll() * q.poll();

        System.out.println(sum * n+"  ");
    }
}


