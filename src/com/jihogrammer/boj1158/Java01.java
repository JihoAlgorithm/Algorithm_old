package com.jihogrammer.boj1158;

import java.util.LinkedList;
import java.util.Queue;

public class Java01 {

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int N, K, c;

        N = System.in.read() - '0';
        while ((c = System.in.read()) > 32) N = 10 * N + c - '0';

        K = System.in.read() - '0';
        while ((c = System.in.read()) > 13) K = 10 * K + c - '0';

        for (int i = 1; i <= N; i++) queue.add(i);

        sb.append('<');
        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) queue.add(queue.poll());
            sb.append(queue.poll() + ", ");
        }

        sb.setLength(sb.length() - 2);
        sb.append('>');

        System.out.print(sb);

    }

}