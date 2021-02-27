import java.util.Scanner;

public class _7272_안경이없어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int alpha[] = { 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 };
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			String temp1 = sc.next();
			String temp2 = sc.next();
			System.out.print("#" + t + " ");
			if (temp1.length() != temp2.length()) {
				System.out.println("DIFF");
				continue;
			}
			boolean flag = true;
			for (int s = 0; s < temp1.length(); s++) {
				if (temp1.charAt(s) == 'B' || temp2.charAt(s) == 'B') {
					if(temp1.charAt(s) != temp2.charAt(s)) {
						flag=false;
						System.out.println("DIFF");
						break;
					}
					continue;
				}
				if (alpha[temp1.charAt(s) - 'A'] != alpha[temp2.charAt(s) - 'A']) {
					System.out.println("DIFF");
					flag = false;
					break;
				}
			}
			if (flag)
				System.out.println("SAME");
		}
	}
}
