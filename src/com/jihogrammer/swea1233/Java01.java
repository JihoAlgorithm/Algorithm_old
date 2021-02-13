package com.jihogrammer.swea1233;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Java01 {

	public static void main(String[] test) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N, res;

		for (int tc = 1; tc < 11; tc++) {
			
			N = Integer.parseInt(br.readLine());
			res = 1;
			
			while (N-->0) {
				test = br.readLine().split(" ");
				if (test.length == 2 && test[1].charAt(0) < '0') res = 0;
			}
			
			bw.append("#" + tc + " " + res + "\n");
			
		}
		
		bw.close();

	}

}