package com.jihogrammer.boj2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Java02 {

    private static int N;
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static PriorityQueue<Integer> pq;

    private static void initBOJ2751() throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        pq = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());
        while (N-->0) pq.offer(Integer.parseInt(br.readLine()));

    }

    private static void printASC() throws IOException {

        while (!pq.isEmpty()) bw.write(pq.poll() + "\n");
        bw.close();

    }

    public static void main(String[] args) throws IOException {

        initBOJ2751();
        printASC();

    }

}
