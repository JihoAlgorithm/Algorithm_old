package com.jihogrammer.boj10250;

import java.io.*;

public class Java02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int T = Integer.parseInt(br.readLine()); T>0; T--) {
            String[] s = br.readLine().split(" ");
            int H = Integer.parseInt(s[0]),
                N = Integer.parseInt(s[2]);

            if ((N % H) == 0) sb.append((H * 100) + (N / H));
            else sb.append((N % H * 100) + (N / H + 1));
            
            sb.append('\n');
        }
        
        System.out.print(sb);
    }
}
