import java.util.Scanner;

public class _1217_거듭제곱 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<10;i++) {
			int TC = sc.nextInt();
			System.out.println("#"+TC+" "+(int)(Math.pow(sc.nextInt(), sc.nextInt())));
		}
	}

}
