package com.jihogrammer.boj10757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java01 {
    
    private static final int A = 0, B = 1;

    public static void main(String[] nums) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int lenA, lenB, sum, tmp;
        boolean breakPoint;
        
        nums = br.readLine().split(" ");
        
        lenA = nums[A].length();
        lenB = nums[B].length();
        tmp  = 0;
        
        while (true) {
            
            if (--lenA < 0) { breakPoint = true;  break; }
            if (--lenB < 0) { breakPoint = false; break; }
            
            sum = (nums[A].charAt(lenA) - '0') + (nums[B].charAt(lenB) - '0') + tmp;
            
            if (sum > 9) tmp = sum / 10;
            else tmp = 0;
            
            sb.append(sum % 10);
            
        }

        if (breakPoint) {
            while (lenB-->0) {
                sum = (nums[B].charAt(lenB) - '0') + tmp;
                
                if (sum > 9) tmp = sum / 10;
                else tmp = 0; 
                
                sb.append(sum % 10);
            }
        } else {
            while (lenA > 0) {
                sum = (nums[A].charAt(lenA--) - '0') + tmp;
                
                if (sum > 9) tmp = sum / 10;
                else tmp = 0; 
                
                sb.append(sum % 10);
            }
        }
        
        if (tmp > 0) sb.append(tmp);

        System.out.println(sb.reverse());

    }

}
