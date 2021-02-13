package com.jihogrammer.boj3053;

import java.io.*;

public class Java01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int r = Integer.parseInt(br.readLine());

        sb.append(r*r*Math.PI).append('\n').append(2*r*r);
        System.out.print(sb);
    }
}
