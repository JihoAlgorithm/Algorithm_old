package com.jihogrammer.boj1011;

import java.io.*;

public class Java01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int T=Integer.parseInt(br.readLine()); T>0; T--) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]),
                y = Integer.parseInt(input[1]),
                k = 0;

            while (true) {
                if ((x += ++k) >= y) {
                    sb.append(k * 2 - 1).append('\n');
                    break;
                }
                if ((y -= k) <= x) {
                    sb.append(k * 2).append('\n');
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}
