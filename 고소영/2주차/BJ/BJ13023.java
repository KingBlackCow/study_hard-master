import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ13023 {
	public static int n, m;
	public static boolean[] visit;
	public static ArrayList<Integer>[] arr;
	public static int ans = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n];
		visit = new boolean [n]; 
		
		for (int i = 0; i < n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int tmp = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			
			arr[tmp].add(tmp2);
			arr[tmp2].add(tmp);
		}
		for(int i = 0; i < n; i++) {
			if (ans == 1) break;
			friend(1, i);
			
		}
	    
	    System.out.println(ans);
	}
	
	public static void friend(int cnt, int idx) {
		if(cnt == 5) {
			ans = 1;
			return;
		}
		
		visit[idx] = true;
		for(int i: arr[idx]) {
			if(!visit[i]) {
				int k = i;
				friend(cnt + 1, k);
			}	
		}
		visit[idx] = false;
	}
}
