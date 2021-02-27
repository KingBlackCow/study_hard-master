import java.util.Scanner;

public class _1926_간단한_369게임 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			int N = sc.nextInt();
			for(int i=1;i<=N;i++) {
				String temp = ""+i;
				int cnt=0;
				for(int k=0;k<temp.length();k++)
					if (temp.charAt(k) == '3' ||
					temp.charAt(k) == '6' ||
					temp.charAt(k) == '9')
						cnt++;
				if (cnt==0) System.out.print(temp+" ");
				else {
					for(int k=0;k<cnt;k++) System.out.print("-");
					System.out.print(" ");
				}
			}
		}
		sc.close();
	}
} 
