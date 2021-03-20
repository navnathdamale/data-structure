package com.java.practice.random;

public class AddLikes {
    public static void main(String[] args) {
        System.out.print(new AddLikes().addLikes("9999", "1"));
    }

    private String addLikes(String likes1, String likes2) {
        if (likes1 == null || likes2 == null) {
            return likes1 == null ? likes2 : likes1;
        }

        int carry = 0;
        int p1 = likes1.length() - 1, p2 = likes2.length() - 1;
        if (p1 < 0 || p2 < 0) {
            return p1 > p2 ? likes1 : likes2;
        }

        StringBuilder res = new StringBuilder();
        while (p1 >= 0 || p2 >= 0) {
            int x1, x2;
            if (p1 >= 0) {
                x1 = likes1.charAt(p1) - '0';
            } else {
                x1 = 0;
            }

            if (p2 >= 0) {
                x2 = likes2.charAt(p2) - '0';
            } else {
                x2 = 0;
            }

            int value = (x1 + x2 + carry) % 10;
            res.append(value);

            carry = (x1 + x2 + carry) / 10;
            p1--;
            p2--;
        }

        if (carry != 0) {
            res.append(carry);
        }

        return res.reverse().toString();
    }
}
