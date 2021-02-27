package SSAFYSTUDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Brainfuck인터프리터_BOJ3954_4주차 {
    static int sm;
    static int sc;
    static int si;
    static String programCode;
    static String inputCode;
    static int pointerPos;
    static int inputPos;
    static int[] ary;
    static int[] bracket;
    static int proceessId;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        while (test-- > 0) {
            st = new StringTokenizer(br.readLine());
            sm = Integer.parseInt(st.nextToken());
            sc = Integer.parseInt(st.nextToken());
            si = Integer.parseInt(st.nextToken());

            programCode = br.readLine();
            inputCode = br.readLine();

            ary = new int[sm];
            pointerPos = 0;
            inputPos = 0;

            Stack<Integer> stack = new Stack<>();
            bracket = new int[sc];

            for (int i = 0; i < sc; i++) {
                char c = programCode.charAt(i);

                if (c == '[') {
                    stack.push(i);
                } else if (c == ']') {
                    int tmp = stack.peek();
                    bracket[i] = tmp;
                    bracket[tmp] = i;
                    stack.pop();
                }
            }

            proceessId = 0;
            int cnt = 0;
            while (cnt <= 50000000 && proceessId < sc) {
                ++cnt;
                process();
            }

            if (proceessId == sc) {
                ans.append("Terminates\n");
            } else {

                int maxPid = proceessId;
                int minPid = proceessId;

                while (cnt-- > 0) {
                    process();
                    maxPid = Math.max(maxPid, proceessId);
                    minPid = Math.min(minPid, proceessId);
                }
                ans.append("Loops " + (minPid - 1) + " " + maxPid + "\n");
            }
        }

        bw.write(ans.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void process() {
        char c = programCode.charAt(proceessId);
        if(c=='-'){
            ary[pointerPos] = (ary[pointerPos] - 1) < 0 ? 255 : (ary[pointerPos] - 1);
        }else if(c=='+'){
            ary[pointerPos] = (ary[pointerPos] + 1) > 255 ? 0 : (ary[pointerPos] + 1);
        }else if(c=='<'){
            pointerPos = (pointerPos - 1) == -1 ? sm - 1 : (pointerPos - 1);
        }else if(c=='>'){
            pointerPos = (pointerPos + 1) == sm ? 0 : (pointerPos + 1);
        }else if(c=='['){
            if (ary[pointerPos] == 0) {
                proceessId = bracket[proceessId];
            }
        }else if(c==']'){
            if (ary[pointerPos] != 0) {
                proceessId = bracket[proceessId];
            }
        }else if(c=='.'){

        }else if(c==','){
            ary[pointerPos] = (inputPos == si) ? 255 : inputCode.charAt(inputPos++);
        }
        proceessId++;
    }
}