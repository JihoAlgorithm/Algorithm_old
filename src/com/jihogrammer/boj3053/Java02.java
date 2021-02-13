package com.jihogrammer.boj3053;

class Java02{public static void main(String[] x)throws Exception{int c,r=0;while((c=System.in.read())>13)r=r*10+(c-'0');System.out.print(Math.PI*r*r+"\n"+2*r*r);}}