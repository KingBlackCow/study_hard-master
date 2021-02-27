import java.io.IOException;
import java.util.Scanner;
 
class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        for (int test_case = 1; test_case <= t; test_case++) {
        	int n = sc.nextInt();
        	
        	int ans =0;
        	for(int i=1;i<=n;i++) {
        		ans += i * (i%2==1 ? 1 : -1);
        	}
        	System.out.printf("#%d %d\n",test_case,ans);
        }
        sc.close();
    }
}