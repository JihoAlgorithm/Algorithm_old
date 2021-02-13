package com.jihogrammer.boj2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java01 {
    public static void main(String[] S) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine().split(" ");
        int N = Integer.parseInt(S[0]), M = Integer.parseInt(S[1]), T = 1, i, j, k, l=0;
        int[] A, C;

        S = br.readLine().split(" ");
        A = new int[N];
        for (i=0; i<N; i++) A[i] = Integer.parseInt(S[i]);

        for (i=N; i>N-3; i--) T *= i;
        T /= 6;
        C = new int[T];
        T = 0;

        for (i=0; i<N-2; i++) {
            for (j=i+1; j<N-1; j++) {
                for (k=j+1; k<N; k++) {
                    if ((C[l] = A[i] + A[j] + A[k]) == M) {
                        System.out.print(M);
                        return;
                    } else if (T < C[l] && C[l] < M) T = C[l];
                    else l++;
                }
            }
        }

        System.out.print(T);
    }
}
