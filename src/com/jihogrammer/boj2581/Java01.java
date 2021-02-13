package com.jihogrammer.boj2581;

import java.io.*;
import java.util.ArrayList;

public class Java01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> prime = new ArrayList<>();
        int M = Integer.parseInt(br.readLine()),
            N = Integer.parseInt(br.readLine()),
            S = 0, min = 0;
        
        if (M+N == 2) {
            System.out.print(-1);
        } else {
            if (M == 1) M++;

            prime.add(2);
            for (int i=2; i<=N; i++) {
                for (int j=0; j<prime.size(); j++) {
                    if (i % prime.get(j) == 0) break;
                    if (j+1 == prime.size()) prime.add(i);
                }
            }

            for (int i=prime.size()-1; prime.get(i)>=M; i--) {
                min = prime.get(i);
                S += min;
                if (i == 0) break;
            }

            if (S == 0) System.out.print(-1);
            else System.out.print(S + "\n" + min);
        }
    }
}
