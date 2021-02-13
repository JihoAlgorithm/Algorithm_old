package com.jihogrammer.boj1002;

import java.io.*;

public class Java02 {
    public static void main(String[] s) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] x = new int[6]; int R, r; double D;

        for (int T = Integer.parseInt(br.readLine()); T>0; T--) {
            s = br.readLine().split(" ");
            for (int i=0; i<6; i++) x[i] = Integer.parseInt(s[i]);
            D = Math.sqrt((x[0]-x[3])*(x[0]-x[3]) + (x[1]-x[4])*(x[1]-x[4]));
            R = Math.max(x[2], x[5]); r = Math.min(x[2], x[5]);

            if (D == 0) if (R == r) bw.write("-1"); else bw.write(48);
            else if (D == R + r || D == R - r) bw.write(49);
            else if (D > R + r) bw.write(48);
            else if (D > R - r) bw.write(50);
            else bw.write(48);
            bw.newLine();
        } bw.close();
    }
}
