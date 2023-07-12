package com.Learn.DP;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p>KMP算法的正常实现</p>
 *
 * @author : 张锐
 * @date : 2023-05-07 06:52
 **/
public class KMPByNext {
    private int[] next;
    private String pat;

    public KMPByNext(String pat) {
        this.next = new int[pat.length()];
        this.pat = pat;
        BuildNext();
    }

    private void BuildNext() {
        next[0] = 0;
        int i = 1;
        int now = 0;
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(now)) {
                now++;
                next[i] = now;
                i++;
            } else if (now == 0) {
                next[i] = 0;
                i++;
            } else {
                now = next[now - 1];
            }
        }
    }

    public int Search(String text) {
        int i = 0;
        int pos = 0;
        while (i < text.length()) {
            if (pat.charAt(pos) == text.charAt(i)) {
                i++;
                pos++;
            } else if (pos == 0) {
                i++;
            } else {
                pos = next[pos - 1];
            }

            if (pos == pat.length()) {
                return i - pos;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "duvsbfaaabvigd";
        String pat = "aaab";

        KMPByNext kmp = new KMPByNext(pat);
        System.out.println(kmp.Search(text));
    }
}
