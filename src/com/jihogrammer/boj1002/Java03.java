package com.jihogrammer.boj1002;

import java.io.*;
import java.util.StringTokenizer;

public class Java03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] x = new int[6];
        double D, R, r;

        for (int T = Integer.parseInt(br.readLine()); T>0; T--) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int i=0; i<6; i++) x[i] = Integer.parseInt(st.nextToken());
            D = Math.sqrt((x[0]-x[3])*(x[0]-x[3]) + (x[1]-x[4])*(x[1]-x[4]));
            R = Math.max(x[2], x[5]); r = Math.min(x[2], x[5]);
            
            if (D == 0) if (R == r) sb.append(-1); else sb.append(0);
            else if (D == R + r || D == R - r) sb.append(1);
            else if (D > R + r) sb.append(0);
            else if (D > R - r) sb.append(2);
            else sb.append(0);
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
