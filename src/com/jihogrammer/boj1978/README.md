[MAIN](../../README.md)|<img width=50/>#1978<img width=50/>|[Baekjoon](https://www.acmicpc.net/problem/1978)
-|-|-

# 소수 찾기

## Solution

- [Java - 01](Java01.java) : prime[]을 활용하여 해결
> 1001 크기(0~1000)의 `boolean`배열에서 소수를 전부 찾아내고, 입력값을 인덱스로 사용하여 해결
```java
private static final int MAX = 1001; // 1000번 인덱스도 사용해야 하므로 +1
private static boolean[] prime = new boolean[MAX];

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int X = 0;
    /* int N = */br.readLine(); // N값은 필요 없음
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    primeArray();
    // prime 배열의 값이 flase(소수)면 X++
    while (st.hasMoreTokens()) if(!prime[Integer.parseInt(st.nextToken())]) X++;
    System.out.print(X);
    printArray();
}

// prime 배열에서 0, 1, 합성수는 true, 소수는 false 대입
// [출처] https://marobiana.tistory.com/91
private static void primeArray() {
    for (int i=2; i*i<=MAX; i++) {
        if (prime[i]) continue;
        for (int j=i+i; j<MAX; j+=i) prime[j] = true;
    }
    prime[0] = true;
    prime[1] = true;
}

// OPTION - 1~1000까지 합성수는 X, 소수는 숫자 출력
private static void printArray() {
    StringBuilder sb = new StringBuilder();
    for(int i=1; i<MAX; i++) {
        if (i%10==1) sb.append('\n');
        if (!prime[i]) sb.append(i).append('\t');
        else sb.append('X').append('\t');
    }
    System.out.println(sb);
}
```

###### 참고: [1929-소수 구하기](../bj01929/README.md), [2581-소수 찾기](../bj02581/README.md), [4948-베르트랑 공준](../bj04948/README.md), [9020-골드바흐의 추측](../bj09020/README.md)

## Problem

주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

## Input

첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

## Output

주어진 수들 중 소수의 개수를 출력한다.

## Example

#### input

```
4
1 3 5 7
```

#### output

```
3
```