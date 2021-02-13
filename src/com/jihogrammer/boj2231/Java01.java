package com.jihogrammer.boj2231;

public class Java01 {
    public static void main(String[] args) throws Exception {
        int[] place = new int[6];
        int C, N = 0;
        while ((C = System.in.read()) > 13) N = 10 * N + C - 48;
        int T, M = N;

        for (C = N-54; C < N+54; C++) {
            if (C < 1) C = 1;
            place[0] = C/100000;
            place[1] = C%100000/10000;
            place[2] = C%10000/1000;
            place[3] = C%1000/100;
            place[4] = C%100/10;
            place[5] = C%10;
            T = C;
            for (int i=0; i<6; i++) T += place[i];
            if (T == N && C < M) M = C;
        }

        /* for (place[0]=0; place[0]<10; place[0]++) {
        for (place[1]=0; place[1]<10; place[1]++) {
        for (place[2]=0; place[2]<10; place[2]++) {
        for (place[3]=0; place[3]<10; place[3]++) {
        for (place[4]=0; place[4]<10; place[4]++) {
        for (place[5]=0; place[5]<10; place[5]++) {
            T = place[0]*100000 + place[1]*10000 + place[2]*1000 + place[3]*100 + place[4]*10 + place[5];
            if (T > N+54) break;
            C = place[0]*100001 + place[1]*10001 + place[2]*1001 + place[3]*101 + place[4]*11 + place[5]*2;
                        
            for (int i=0; i<6; i++) System.out.print(place[i]);
            System.out.println("\t" + C);
            if (C == N && T < M) {
                M = T;
                System.out.println("*** M = " + M + " ***");
            }
        }}}}}} */

        if (M == N) M = 0;
        System.out.print(M);
    }
}
