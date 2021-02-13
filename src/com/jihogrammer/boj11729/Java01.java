package com.jihogrammer.boj11729;

public class Java01 {
    static StringBuilder s = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        int c, n = 0;
        while ((c=System.in.read()) > 13) n = 10 * n + c - 48;
        
        s.append(Integer.valueOf((int)Math.pow(2, n)-1)).append('\n');
        hanoi('1', '2', '3', n);
        System.out.print(s);
    }

    static void hanoi(char start, char temp, char end, int number) {
        if(number == 1) s.append(start).append(' ').append(end).append('\n');
        else {
            hanoi(start, end, temp, number -1);
            s.append(start).append(' ').append(end).append('\n');
            hanoi(temp, start, end, number -1);
        }
    }
}
