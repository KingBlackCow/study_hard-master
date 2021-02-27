package SSAFYSTUDY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution4366 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            String str2 = br.readLine();
            List<Integer> list = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                String subStr = str.substring(0, i);
                String midStr = "";
                String subStr3 = str.substring(i + 1);
                if (str.charAt(i) == '1') {
                    midStr += '0';
                } else if (str.charAt(i) == '0') {
                    midStr += '1';
                }
                subStr += midStr;
                subStr += subStr3;
                list.add(two(subStr));
            }
            int m = 0;
            for (int j = 0; j < str2.length(); j++) {
                if (str2.charAt(j) == '1') {
                    for (int i = 0; i < 2; i++) {
                        String subStr2 = str2.substring(0, j);
                        String subStr32 = str2.substring(j + 1);
                        String midStr2 = "";
                        if (i == 0) midStr2 += '0';
                        else midStr2 += '2';
                        subStr2 += midStr2;
                        subStr2 += subStr32;
                        list2.add(third(subStr2));

                    }

                } else if (str2.charAt(j) == '0') {
                    for (int i = 0; i < 2; i++) {
                        String subStr2 = str2.substring(0, j);
                        String subStr32 = str2.substring(j + 1);
                        String midStr2 = "";
                        if (i == 0) midStr2 += '1';
                        else midStr2 += '2';
                        subStr2 += midStr2;
                        subStr2 += subStr32;
                        list2.add(third(subStr2));

                    }
                } else if (str2.charAt(j) == '2') {
                    for (int i = 0; i < 2; i++) {
                        String subStr2 = str2.substring(0, j);
                        String subStr32 = str2.substring(j + 1);
                        String midStr2 = "";
                        if (i == 0) midStr2 += '0';
                        else midStr2 += '1';
                        subStr2 += midStr2;
                        subStr2 += subStr32;
                        list2.add(third(subStr2));
                    }
                }
            }

            for (Integer i : list) {
                if (list2.contains(i)) {
                    System.out.println("#" + test_case + " " + i);
                }
            }
        }
    }

    static int two(String str) {
        int n = 0;
        int cnt = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            int tmp = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (tmp == 1) {
                n += tmp * cnt;
            }
            cnt *= 2;
        }
        return n;
    }

    static int third(String str) {
        int n = 0;
        int cnt = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            int tmp = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (tmp == 1) {
                n += tmp * cnt;
            } else if (tmp == 2) {
                n += tmp * cnt;
            }
            cnt *= 3;
        }
        return n;
    }
}