[MAIN](../../README.md)|<img width=50/>#9020<img width=50/>|[Baekjoon](https://www.acmicpc.net/problem/9020)
-|-|-

# 골드바흐의 추측

## Solution

```java
 4 = 2 + 2  // 특수 Case -> 4 이외의 Case에서는 2가 포함될 수 없음
 6 = 3 + 3
 8 = 3 + 5
10 = 5 + 5
12 = 5 + 7
14 = 7 + 7  // (3 + 11)도 있으나 두 소수의 차가 가장 작아야 함
16 = 5 + 11 // (3 + 13)도 있으나 두 소수의 차가 가장 작아야 함
```
> ##### idea : 주어진 N 값을 절반으로 떼고 탐색하자

- [Java - 01](Java01.java)
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();

// inner for문에서 j=i+i -> j=i+i로 변경함. 아주 미세하게 효율적이겠지.
// prime 배열의 인덱스가 0, 1, 합성수면 true. 소수면 false.
final int MAX = 10000;
boolean[] prime = new boolean[MAX+1];
prime[0] = prime[1] = true;
for (int i=2; i*i<=MAX; i++) {
    if (prime[i]) continue;
    for(int j=i*i; j<=MAX; j+=i) prime[j] = true;
}

// Test Case
for(int T = Integer.parseInt(br.readLine()); T>0; T--) {
    int n = Integer.parseInt(br.readLine());
    // n의 절반부터 탐색 -> 두 소수의 차가 작아야 하므로
    for (int i=n/2; i>1; i--) {
        // i가 합성수면 볼 필요 없이 continue
        if (prime[i]) continue;
        // i와 (n-i)가 둘 다 소수면 sb 처리 후 break -> 다음 Test Case
        if (!prime[i] && !prime[n-i]) {
            sb.append(i + " " + (n-i) + "\n");
            break;
        }
    }
}

System.out.print(sb);
```

###### 참고: [1929-소수 구하기](../bj01929/README.md), [1978-소수 찾기](../bj01978/README.md), [2581-소수 찾기](../bj02581/README.md), [4948-베르트랑 공준](../bj04948/README.md)

## Problem

1보다 큰 자연수 중에서  1과 자기 자신을 제외한 약수가 없는 자연수를 소수라고 한다. 예를 들어, 5는 1과 5를 제외한 약수가 없기 때문에 소수이다. 하지만, 6은 6 = 2 × 3 이기 때문에 소수가 아니다.

골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다. 이러한 수를 골드바흐 수라고 한다. 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다. 예를 들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7이다. 10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.

2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오. 만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.

## Input

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고 짝수 n이 주어진다. (4 ≤ n ≤ 10,000)

## Output

각 테스트 케이스에 대해서 주어진 n의 골드바흐 파티션을 출력한다. 출력하는 소수는 작은 것부터 먼저 출력하며, 공백으로 구분한다.

## Example

#### input

```
3
8
10
16
```

#### output

```
3 5
5 5
5 11
```