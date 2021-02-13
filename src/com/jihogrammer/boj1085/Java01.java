package com.jihogrammer.boj1085;

import java.io.*;
import java.util.StringTokenizer;

public class Java01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken()),
            y = Integer.parseInt(st.nextToken()),
            w = Integer.parseInt(st.nextToken()),
            h = Integer.parseInt(st.nextToken());
        System.out.print(Math.min(Math.min(w-x, x), Math.min(h-y, y)));
    //  System.out.print((w-x<x?w-x:x) < (h-y<y?h-y:y) ? (w-x<x?w-x:x) : (h-y<y?h-y:y));
    }
}