[MAIN](../../README.md)|<img width=50/>#1002<img width=50/>|[Baekjoon](https://www.acmicpc.net/problem/1002)
-|-|-


# 터렛

## Solution

- [Java - 01](Java01.java) : _Baekjoon_ 에서는 최고 성능
- [Java - 02](Java02.java) : 성능 향상이 안 된 코드
- [Java - 03](Java03.java) : `StringTokenizer` 사용

> ~~괜히 r로 준 게 아니다. [여기](https://mathbang.net/101) 참고함.~~

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();
double[] x = new double[6];
double D, R, r;

for (int T = Integer.parseInt(br.readLine()); T>0; T--) {
    s = br.readLine().split(" "); // main함수의 매개변수
    for (int i=0; i<6; i++) x[i] = Double.parseDouble(s[i]);
    D = Math.sqrt((x[0]-x[3])*(x[0]-x[3]) + (x[1]-x[4])*(x[1]-x[4]));
    R = Math.max(x[2], x[5]); r = Math.min(x[2], x[5]);
    
    if (D == 0)                 // 동심원일 경우
        if (R == r) sb.append(-1);  // 반지름이 동일하면 -1
        else sb.append(0);          // 아니면 0
    else if (D == R + r || D == R - r) sb.append(1); // 외접, 내접
    else if (D > R + r) sb.append(0);   // 원이 만나지 않을 경우
    else if (D > R - r) sb.append(2);   // 원이 두 점에서 만나는 경우
    else sb.append(0);                  // 원이 만나지 않을 경우

    sb.append('\n');
}

System.out.print(sb);
```

## Problem

조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.

![스타크래프트 테란 터렛](https://www.acmicpc.net/upload/201003/dfcmhrjj_142c3w76qg8_b.jpg)

이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.

조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

## Input

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.

한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고, r1, r2는 10,000보다 작거나 같은 자연수이다.

## Output

각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.

## Example

#### input

```
3
0 0 13 40 0 37
0 0 3 0 7 4
1 1 1 1 1 5
```

#### output

```
2
1
0
```