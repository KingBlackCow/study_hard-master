
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _9280_진용이네_주차타워 {

	static int result;

	static void init(Scanner sc) throws NumberFormatException, IOException {
		int N = sc.nextInt();
		int M = sc.nextInt();

		boolean visit[] = new boolean[N + 1];
		int parking[] = new int[M + 1]; // index=차, value=주차공간 :: ex) parking[3]=1 3번차가 1번주차공간에 주차

		int pay[] = new int[N + 1]; // 단위당 주차공간가격
		int car[] = new int[M + 1]; // 차 무게

		for (int i = 1; i <= N; i++) { // 무게당요금
			pay[i] = sc.nextInt();
			System.out.print(pay[i]+" ");
		}
		System.out.println();
		for (int i = 1; i <= M; i++) { // 차량의무게
			car[i] = sc.nextInt();
			System.out.print(car[i]+" ");
		}
		System.out.println();
		
		Arrays.fill(parking, 0);
		Arrays.fill(visit, false);
		solve(N, M, visit, parking, pay, car, sc);
	}

	static void solve(int N, int M, boolean visit[], int parking[], int pay[], int car[], Scanner sc) {
		/*
		 * 총 주차공간 n 주차장에 도착하면, 비어있는공간이 있는지 확인 비어잇는곳이없다면, 입구에서 기다림 비어있는곳이있다면, 주차시키되,
		 * 가장작은번호에 주차 기다리는게 여러대라면 차례를 기다려야한다
		 */
		Queue<Integer> q = new LinkedList<Integer>();

		int park = 0;
		for(int d=0;d<2*M;d++) {	// ->이부분에대해 못봐서 while로 돌렸더니 런타임에러남
			int type = sc.nextInt();
			if (type > 0) {
				// 들어오면 비어있는지 확인~
				if (park != N) {
					for (int i = 1; i <= N; i++) {
						if (!visit[i]) {		// 주차할공간을찾고
							park++;				// 주차중인 차개수+1
							visit[i] = true;
							parking[type] = i;	// 차량이 어디주차됬는지 기재
							System.out.print(type+"차량이 "+i+"주차공간에 주차했습니다. ");
							result += car[type] * pay[i];	// 주차요금합산
							System.out.println("요금은: "+(car[type]*pay[i])+"원 입니다.");
							break;
						}
					}
				}
				else {	// 주차공간이 다 차있다면 q에서 대기
					q.add(type);
					System.out.println(type+"차량이 대기합니다");
				}
			} else {
				type = Math.abs(type);
				park--;
				visit[parking[type]]=false;
				System.out.println(type+"차량이 "+parking[type]+"주차공간에서 나갔습니다. ");
				parking[type] = 0;
			}
			// 기다리는차가 있다면 진행
			while (park != N && !q.isEmpty()) {
				int input = q.poll();
				for (int i = 1; i <= N; i++) {
					if (!visit[i]) {
						visit[i] = true;
						parking[input]=i;
						System.out.print("대기중이던"+input+"차량이 "+i+"주차공간에 주차했습니다. ");
						result += car[input] * pay[i];	// 주차요금합산
						System.out.println("요금은: "+(car[input]*pay[i])+"원 입니다.");
					}
				}
				park++;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			result = 0;
			init(sc);
			System.out.println("#" + t + " " + result);
		}
	}

}


//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class Solution {
//
//	static int result;
//
//	static void init(Scanner sc) throws NumberFormatException, IOException {
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//
//		boolean visit[] = new boolean[N + 1];
//		int parking[] = new int[M + 1]; 
//
//		int pay[] = new int[N + 1];
//		int car[] = new int[M + 1];
//
//		for (int i = 1; i <= N; i++)
//			pay[i] = sc.nextInt();
//		for (int i = 1; i <= M; i++)
//			car[i] = sc.nextInt();
//		
//		Arrays.fill(parking, 0);
//		Arrays.fill(visit, false);
//		solve(N, M, visit, parking, pay, car, sc);
//	}
//
//	static void solve(int N, int M, boolean visit[], int parking[], int pay[], int car[], Scanner sc) {
//		Queue<Integer> q = new LinkedList<Integer>();
//
//		int park = 0;
//		for(int d=0;d<2*M;d++){
//			int type = sc.nextInt();
//			if (type > 0) {
//				if (park != N) {
//					for (int i = 1; i <= N; i++) {
//						if (!visit[i]) {		
//							park++;			
//							visit[i] = true;
//							parking[type] = i;
//							result += car[type] * pay[i];
//							break;
//						}
//					}
//				}
//				else {
//					q.add(type);
//				}
//			} else {
//				type = Math.abs(type);
//				park--;
//				visit[parking[type]]=false;
//				parking[type] = 0;
//			}
//			while (park != N && !q.isEmpty()) {
//				int input = q.poll();
//				for (int i = 1; i <= N; i++) {
//					if (!visit[i]) {
//						visit[i] = true;
//						parking[input]=i;
//						result += car[input] * pay[i];
//					}
//				}
//				park++;
//			}
//		}
//	}
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		// TODO Auto-generated method stub
//
//		Scanner sc = new Scanner(System.in);
//		int tc = sc.nextInt();
//		for (int t = 1; t <= tc; t++) {
//			result = 0;
//			init(sc);
//			System.out.println("#" + t + " " + result);
//		}
//	}
//
//}
