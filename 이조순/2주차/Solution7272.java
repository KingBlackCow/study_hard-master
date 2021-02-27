package SSAFYSTUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution7272 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Character> list1 = new ArrayList<>();
        list1.add('C');
        list1.add('E');
        list1.add('F');
        list1.add('G');
        list1.add('H');
        list1.add('I');
        list1.add('J');
        list1.add('K');
        list1.add('L');
        list1.add('M');
        list1.add('N');
        list1.add('S');
        list1.add('T');
        list1.add('U');
        list1.add('V');
        list1.add('W');
        list1.add('X');
        list1.add('Y');
        list1.add('Z');

        List<Character> list2 = new ArrayList<>();
        list2.add('A');
        list2.add('D');
        list2.add('O');
        list2.add('P');
        list2.add('Q');
        list2.add('R');
        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            boolean res = true;
            if (str1.length() == str2.length()) {
                for (int i = 0; i < str1.length(); i++) {
                    if (str1.charAt(i) != 'B') {
                        if (list1.contains(str1.charAt(i)) && !list1.contains(str2.charAt(i))) {
                            res=false;
                            break;
                        } else if(list2.contains(str1.charAt(i)) && !list2.contains(str2.charAt(i))){
                            res=false;
                            break;
                        }
                    }else{
                        if(str2.charAt(i)!='B'){
                            res=false;
                            break;
                        }
                    }
                }
            }else{
                res=false;
            }
            if (!res) System.out.println("#" + test_case + " " + "DIFF");
            else System.out.println("#" + test_case + " " + "SAME");
        }
    }
}