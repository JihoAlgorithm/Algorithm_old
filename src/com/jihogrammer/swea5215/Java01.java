package com.jihogrammer.swea5215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Java01 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static PriorityQueue<Integer> pq;
    private static Ingredient[] ingredients;
    private static StringTokenizer st;
    private static int N, L;

    public static void main(String[] args) throws NumberFormatException, IOException {

        final int T = Integer.parseInt(br.readLine()) + 1;
        for (int tc = 1; tc < T; tc++) bw.append("#" + tc + " " + combination() + "\n");
        bw.close();

    }

    private static int combination() throws IOException {

        pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        boolean[] visited = new boolean[N];
        ingredients = new Ingredient[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ingredients[i] = new Ingredient(st.nextToken(), st.nextToken());
        }
        
        powerSet(ingredients, visited, 0);
        
        return pq.poll();
    }

    static void powerSet(Ingredient[] arr, boolean[] visited, int idx) {
        if(idx == N) {
            setPointSum(arr, visited);
            return;
        }
        
        visited[idx] = false;
        powerSet(arr, visited, idx + 1);
        
        visited[idx] = true;
        powerSet(arr, visited, idx + 1);
    }

    static void setPointSum(Ingredient[] arr, boolean[] visited) {
        
        int kcal = 0;
        int point = 0;
        
        for (int i = 0; i < N; i++)
            if (visited[i]) {
                point += arr[i].point;
                kcal += arr[i].kcal;
            }
        
        if (kcal <= L) pq.add(point);
        
    }

}

class Ingredient {

    int point;
    int kcal;

    public Ingredient (String point, String kcal) {
        this.point = Integer.parseInt(point);
        this.kcal = Integer.parseInt(kcal);
    }

}
