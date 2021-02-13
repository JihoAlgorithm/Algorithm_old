package com.jihogrammer.boj1011;

import java.io.*;

public class Java02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for (int T=Integer.parseInt(br.readLine()); T>0; T--) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]),
                y = Integer.parseInt(input[1]),
                k = 0;

            while (true) {
                if ((x += ++k) >= y) {
                    bw.write(Integer.toString(k * 2 - 1));
                    bw.newLine();
                    break;
                }
                if ((y -= k) <= x) {
                    bw.write(Integer.toString(k * 2));
                    bw.newLine();
                    break;
                }
            }
        }

        bw.close();
    }
}
