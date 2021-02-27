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
			car = new int[m  + 1]; // 1�������� ���
			
			for (int i = 0; i < n; i++) {
				fee[i] = Integer.parseInt(br.readLine());
			}
			for (int i = 1; i <= m; i++) {
				car[i] = Integer.parseInt(br.readLine());
			}
			for (int i = 0; i < 2 * m; i++) { // ���� ��� �ѹ� ���Դ� �ѹ� ������ ������ 2m
				q.add(Integer.parseInt(br.readLine())); // �� �־��ֱ�
			}
			
			int k = 0;
			int tmp = 0;
			while(!q.isEmpty()) {// �� �� ������ ����
				k = q.poll();
				if(k > 0 ) {// �� ����
					wait.add(k); 
					tmp = wait.peek(); //���� �տ� �ִ°� �����ֱ�
					for(int i = 0; i < n; i++) {
						// ���� ���� �ڸ����� ���� �ϴϱ� for�� �ʿ�
						if(chk[i] == 0) {
							chk[i] = tmp;
							// ������ֱ� 
							res += fee[i] * car[tmp];
							wait.poll();
							break; // ������ break;
						}
					}
				}
				else  { // k < 0 -> �� ���� 
					k = -k;
					for (int i = 0; i < n; i++) {
						if(chk[i] == k) {
							chk[i] = 0; // �� ��
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
