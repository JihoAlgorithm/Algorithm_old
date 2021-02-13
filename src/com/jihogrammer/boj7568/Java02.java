package com.jihogrammer.boj7568;

import java.io.*;

public class Java02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] BULK;

        final int WEIGHT = 0, HEIGHT = 1, RANK = 2;
        int i, j, N = Integer.parseInt(br.readLine());
        BULK = new int[N][3];

        for (i=0; i<N; i++) {
            args = br.readLine().split(" ");
            BULK[i][WEIGHT] = Integer.parseInt(args[WEIGHT]);
            BULK[i][HEIGHT] = Integer.parseInt(args[HEIGHT]);
            BULK[i][RANK] = 1;
        }

        for(i=0; i<N; i++) {
			for(j=0; j<N; j++) {
				if(BULK[i][WEIGHT]>BULK[j][WEIGHT] && BULK[i][HEIGHT]>BULK[j][HEIGHT]) {
					BULK[j][RANK]++;
				}
			}
        }
        
        bw.write(String.valueOf(BULK[0][RANK]));
        for (i=1; i<N; i++) bw.write(" " + BULK[i][RANK]);
        bw.close();
    }
}
