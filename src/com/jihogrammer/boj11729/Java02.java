package com.jihogrammer.boj11729;

import java.io.*;

public class Java02 {
    private static BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
    
    private static void h (char x, char y, char z, int n) throws IOException {
        if(n == 0) return;
        else {
            h(x, z, y, n - 1);
            w.write(x + " " + z + "\n");
            h(y, x, z, n - 1);
        }
    }
    
    public static void main(String[] a) throws IOException {
        int c, n = 0;
        while((c = System.in.read()) > 13) n = 10 * n + c - 48;
        w.write(String.valueOf((int)Math.pow(2, n) - 1) + "\n");
        h('1', '2', '3', n);
        w.close();
    }
}
