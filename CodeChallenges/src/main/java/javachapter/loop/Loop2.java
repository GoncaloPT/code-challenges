package javachapter.loop;

import java.util.*;
import java.io.*;

public class Loop2 {

    public static void printSum(int a, int b, int n) {

    }

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            printSum(a, b, n);
        }
        in.close();
    }

}