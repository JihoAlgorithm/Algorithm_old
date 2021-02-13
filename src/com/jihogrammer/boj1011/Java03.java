package com.jihogrammer.boj1011;

import java.io.*;
import java.util.StringTokenizer;

public class Java03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int T=Integer.parseInt(br.readLine()); T>0; T--) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken()),
                Y = Integer.parseInt(st.nextToken()),
                D = Y - X,
                K = (int)Math.sqrt(D);
            
            if (K == Math.sqrt(D)) {
                bw.write(Integer.toString(K * 2 - 1));
                bw.newLine();
            } else if (D <= K * K + K) {
                bw.write(Integer.toString(K * 2));
                bw.newLine();
            } else {
                bw.write(Integer.toString(K * 2 + 1));
                bw.newLine();
            }
        }

        bw.close();
    }
}
