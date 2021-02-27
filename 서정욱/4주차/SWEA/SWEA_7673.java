import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t;
	static int n,input,tt,ff;
	static twofive[][] arr,brr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.valueOf(br.readLine());
		//t = 10;

		for(int test_case = 1;test_case<=t;test_case++) {
			n = Integer.valueOf(br.readLine());
			arr = new twofive[n][n];
			brr = new twofive[n][n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					tt = ff = 0;
					input = Integer.valueOf(st.nextToken());
					if(input==0) {arr[i][j] = new twofive(99999999,99999999);}
					else {
						while(input%2==0) {tt++;input/=2;}
						while(input%5==0) {ff++;input/=5;}
						
						arr[i][j] = new twofive(tt,ff);
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i+j==0 || arr[i][j].t == 99999999) continue;
					int left_two=99999999;
					int left_five=99999999;
					int up_two=99999999;
					int up_five=99999999;
					int left_min=0, up_min=0,left_max=0,up_max=0;
					if(i!=0) {
						up_two = arr[i][j].t + arr[i-1][j].t;
						up_five = arr[i][j].f + arr[i-1][j].f;
					}
					if(j!=0) {
						left_two = arr[i][j].t + arr[i][j-1].t;
						left_five = arr[i][j].f + arr[i][j-1].f;
					}
					
					left_min = Math.min(left_two, left_five);
					up_min = Math.min(up_two, up_five);
					
					left_max = Math.max(left_two, left_five);
					up_max = Math.max(up_two,up_five);
					
					if(left_min > up_min) {
						arr[i][j].t = up_two;
						arr[i][j].f = up_five;
					}
					else if(left_min < up_min) {
						arr[i][j].t = left_two;
						arr[i][j].f = left_five;
					}
					else {
						if(left_max < up_max) {
							arr[i][j].t = left_two;
							arr[i][j].f = left_five;
						}
						else {
							arr[i][j].t = up_two;
							arr[i][j].f = up_five;
						}
					}
				}
				
				//show();
			}
			
			bw.write("#" + String.valueOf(test_case) + " " + String.valueOf(Math.min(arr[n-1][n-1].t, arr[n-1][n-1].f)) + "\n");
		}

		bw.flush();
		bw.close();
	}
	
	public static void show() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print("{" + arr[i][j].t + "," + arr[i][j].f + "}" + "\t" );
			}
			System.out.println();
		}
		System.out.println();
	}
}

class twofive {
	int t,f;
	
	public twofive() {
		this.t = 0;
		this.f = 0;
	}
	public twofive(int t,int f) {
		this.t = t;
		this.f = f;
	}
}