package com.jihogrammer.boj1002;

import java.io.*;

public class Java01 {
    public static void main(String[] s) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        double[] x = new double[6];
        double D, R, r;

        for (int T = Integer.parseInt(br.readLine()); T>0; T--) {
            s = br.readLine().split(" ");
            for (int i=0; i<6; i++) x[i] = Double.parseDouble(s[i]);
            D = Math.sqrt((x[0]-x[3])*(x[0]-x[3]) + (x[1]-x[4])*(x[1]-x[4]));
            R = Math.max(x[2], x[5]); r = Math.min(x[2], x[5]);
            
            if (D == 0)                 // 동심원일 경우
                if (R == r) sb.append(-1);  // 반지름이 동일하면 -1
                else sb.append(0);          // 아니면 0
            else if (D == R + r || D == R - r) sb.append(1); // 외접, 내접
            else if (D > R + r) sb.append(0);   // 원이 만나지 않을 경우
            else if (D > R - r) sb.append(2);   // 원이 두 점에서 만나는 경우
            else sb.append(0);                  // 원이 만나지 않을 경우

            sb.append('\n');
        }

        System.out.print(sb);
    }
}
