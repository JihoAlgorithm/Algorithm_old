package com.jihogrammer.boj7568;

import java.io.*;

public class Java04 {
    public static void main(String[] in) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int i, j, N = Integer.parseInt(br.readLine());
        int weight[] = new int[N], height[] = new int[N], rank[] = new int[N];

        for (i=0; i<N; i++) {
            in = br.readLine().split(" ");
            weight[i] = Integer.parseInt(in[0]);
            height[i] = Integer.parseInt(in[1]);
        }

        for (i=0; i<N; i++) {
			for (j=0; j<N; j++) {
                if (i == j) continue;
				if (weight[i]<weight[j] && height[i]<height[j]) rank[i]++;
            }
            sb.append(++rank[i]).append(' ');
        }

        System.out.print(sb);
    }
}
