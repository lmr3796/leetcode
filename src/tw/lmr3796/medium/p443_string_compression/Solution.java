package tw.lmr3796.medium.p443_string_compression;

class Solution {
    int writeCount(char[] buffer, char curr, int head, int repeat) {
        buffer[head++] = curr;
        if (repeat > 1) {
            for (char c: String.valueOf(repeat).toCharArray()) {
                buffer[head++] = c;
            }
        }
        return head;
    }

    public int compress(char[] chars) {
        char curr = chars[0];
        int repeat = 0;
        int head = 0;
        for (int i = 0; i < chars.length; i++) {
            repeat++;
            if (i + 1 >= chars.length) {
                head = writeCount(chars, curr, head, repeat);
            } else if (chars[i + 1] != curr) {
                head = writeCount(chars, curr, head, repeat);
                curr = chars[i + 1];
                repeat = 0;
            }
        }
        return head;
    }
}
