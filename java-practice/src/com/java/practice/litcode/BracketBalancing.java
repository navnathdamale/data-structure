package com.java.practice.litcode;

public class BracketBalancing {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        buildBracket(4, sb);
        System.out.println(sb);

    }

    public static void buildBracket(int N, StringBuilder sb) {
        if (N == 0) {
            return;
        }

        if (N == 1) {
            sb.append("{}");
            return;
        }

        for (int i = 1; i <= N * 2; i++) {
            if (i <= N)
                sb.append("{");

            if (i > N) {
                sb.append("}");
            }
        }

        for (int i = N - 1; i >= 1; i--) {
            buildBracket(i, sb);
        }
    }
}
