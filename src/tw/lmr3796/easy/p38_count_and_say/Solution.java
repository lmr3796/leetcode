package tw.lmr3796.easy.p38_count_and_say;

public class Solution {
    public String countAndSay(int n) {
        String seq = "1";
        for (int i = 1; i < n ; i++) {
            StringBuilder sb = new StringBuilder();
            char curr = seq.charAt(0);
            int repeat = 0;
            for (int j = 0; j < seq.length(); j++) {
                if (seq.charAt(j) == curr) {
                    repeat++;
                } else {
                    sb.append(String.valueOf(repeat));
                    sb.append(String.valueOf(curr));
                    curr = seq.charAt(j);
                    repeat = 1;
                }
            }
            sb.append(String.valueOf(repeat));
            sb.append(String.valueOf(curr));
            seq = sb.toString();
        }
        return seq;
    }
}