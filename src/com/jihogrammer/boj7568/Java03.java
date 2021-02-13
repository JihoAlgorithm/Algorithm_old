package com.jihogrammer.boj7568;

import java.io.*;

public class Java03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int WEIGHT = 0, HEIGHT = 1;
        int i, j, rank, N = Integer.parseInt(br.readLine());
        int[] weight = new int[N], height = new int[N];

        for (i=0; i<N; i++) {
            args = br.readLine().split(" ");
            weight[i] = Integer.parseInt(args[WEIGHT]);
            height[i] = Integer.parseInt(args[HEIGHT]);
        }

        for(i=0; i<N; i++) {
            rank = 1;
			for(j=0; j<N; j++)
                if(weight[i]<weight[j] && height[i]<height[j]) rank++;
            bw.write(rank + " ");
        }
        
        bw.close();
    }
}