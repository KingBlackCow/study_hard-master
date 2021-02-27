import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class swea9280 {
	public static void main(String[] args) throws IOException {
		int[] fee, car, chk;
		int res = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			Queue <Integer> q = new LinkedList<Integer>();
			Queue <Integer> wait = new LinkedList<Integer>();
			fee = new int[n];
			chk = new int[n];
			car = new int[m  + 1]; // 1번차부터 계산
			
			for (int i = 0; i < n; i++) {
				fee[i] = Integer.parseInt(br.readLine());
			}
			for (int i = 1; i <= m; i++) {
				car[i] = Integer.parseInt(br.readLine());
			}
			for (int i = 0; i < 2 * m; i++) { // 차가 모두 한번 들어왔다 한번 빠지기 때문에 2m
				q.add(Integer.parseInt(br.readLine())); // 차 넣어주기
			}
			
			int k = 0;
			int tmp = 0;
			while(!q.isEmpty()) {// 차 다 빠지면 종료
				k = q.poll();
				if(k > 0 ) {// 차 들어옴
					wait.add(k); 
					tmp = wait.peek(); //제일 앞에 있는거 꺼내주기
					for(int i = 0; i < n; i++) {
						// 적은 수의 자리부터 들어가야 하니까 for문 필요
						if(chk[i] == 0) {
							chk[i] = tmp;
							// 계산해주기 
							res += fee[i] * car[tmp];
							wait.poll();
							break; // 넣으면 break;
						}
					}
				}
				else  { // k < 0 -> 차 뺴기 
					k = -k;
					for (int i = 0; i < n; i++) {
						if(chk[i] == k) {
							chk[i] = 0; // 차 뺌
							if(!wait.isEmpty()) {
								k = wait.poll();
								chk[i] = k;
								res += fee[i] * car[tmp];
							}
						break;
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + res);
		}
		
	}
}
