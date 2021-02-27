import java.io.IOException;
import java.util.Scanner;
 
class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
        for (int test_case = 1; test_case <= t; test_case++) {
        	String ch = sc.nextLine();
        	System.out.println(ch.length());
        	int chk = 1;
        	
        	for(int i=0;i<ch.length()/2;i++) {
        		if(ch.charAt(i) != ch.charAt(ch.length()-i-1)) {
        			chk = 0;
        			break;
        		}
        	}
        	
        	System.out.printf("#%d %d\n",test_case,chk);
        }
        sc.close();
    }
}