package com.jihogrammer.boj10757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Java02 {

    public static void main(String[] nums) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nums = br.readLine().split(" ");
        
        System.out.print(new BigInteger(nums[0]).add(new BigInteger(nums[1])));

    }

}
