package com.jihogrammer.boj3009;

import java.io.*;
import java.util.StringTokenizer;

public class Java01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append(br.readLine()).append(' ').append(br.readLine()).append(' ').append(br.readLine());
        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()),
            x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken()),
            x3 = Integer.parseInt(st.nextToken()), y3 = Integer.parseInt(st.nextToken());

        /* sb.delete(0, sb.length())
          .append(x1 == x2 ? x3 : x2 == x3 ? x1 : x2).append(' ')
          .append(y1 == y2 ? y3 : y2 == y3 ? y1 : y2); */
        
        sb = new StringBuilder();
        if (x1 == x2) sb.append(x3);
        else if (x1 == x3) sb.append(x2);
        else sb.append(x1);
        sb.append(' ');
        if (y1 == y2) sb.append(y3);
        else if (y1 == y3) sb.append(y2);
        else sb.append(y1);

        System.out.print(sb);
    }
}
