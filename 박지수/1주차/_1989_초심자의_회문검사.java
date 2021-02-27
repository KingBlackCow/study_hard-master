import java.util.Scanner;

public class _1989_초심자의_회문검사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			String palindrome = sc.next();
			int Size = palindrome.length()-1;
			String plaintext = "";
			for (int i = 0; i < Size / 2; i++)
				plaintext += palindrome.charAt(i);
			String reverse = "";
			if (Size % 2 == 0)
				Size--;
			for (int i = palindrome.length() - 1; i > Size / 2+1; i--)
				reverse += palindrome.charAt(i);
			System.out.print("#" + t + " ");
			if (plaintext.equals(reverse))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}
