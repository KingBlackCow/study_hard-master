import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _4366_정식이의_은행업무 {
	
	static String temp2;
	static String temp3;
	
	static void init() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			temp2=sc.next();
			temp3=sc.next();
			System.out.print("#"+t+" ");
			solve();
		}
	}
	static void solve() {
		List<Long> l3 = new ArrayList<Long>();
		ch3(temp3, l3);
		ch2(temp2, l3);
	}
	
	static void ch2(String value, List<Long> l3) {
		for(int i=0;i<temp2.length();i++) {
			StringBuilder sb = new StringBuilder(temp2);
			if (temp2.charAt(i) == '1')
				sb.setCharAt(i, '0');
			else
				sb.setCharAt(i, '1');
			Long ret = Long.parseLong(""+sb, 2);
			if (l3.contains(ret)) {
				System.out.println(ret);
				return;
			}
		}
	}
	static void ch3(String value, List<Long> l3) {
		for(int i=0;i<temp3.length();i++) {
			StringBuilder sb = new StringBuilder(temp3);
			if (temp3.charAt(i) == '0') {
				sb.setCharAt(i, '1');
				l3.add(Long.parseLong(""+sb, 3));
				sb.setCharAt(i, '2');
				l3.add(Long.parseLong(""+sb, 3));
			}
			else if (temp3.charAt(i) == '1') {
				sb.setCharAt(i, '0');
				l3.add(Long.parseLong(""+sb, 3));
				sb.setCharAt(i, '2');
				l3.add(Long.parseLong(""+sb, 3));
			}
			else {
				sb.setCharAt(i, '0');
				l3.add(Long.parseLong(""+sb, 3));
				sb.setCharAt(i, '1');
				l3.add(Long.parseLong(""+sb, 3));
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
	}
}
