[MAIN](../../README.md)|<img width=50/>#1085<img width=50/>|[Baekjoon](https://www.acmicpc.net/problem/1085)
-|-|-

# 직사각형에서 탈출

## Solution
- [Java - 01](Java01.java)
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine(), " ");
int x = Integer.parseInt(st.nextToken()),
    y = Integer.parseInt(st.nextToken()),
    w = Integer.parseInt(st.nextToken()),
    h = Integer.parseInt(st.nextToken());
System.out.print(Math.min(Math.min(w-x, x), Math.min(h-y, y)));
// System.out.print((x=w-x<x?w-x:x) < (y=h-y<y?h-y:y) ? x : y);
```

## Problem

한수는 지금 (x, y)에 있다. 직사각형의 왼쪽 아래 꼭짓점은 (0, 0)에 있고, 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.

## Input

첫째 줄에 x, y, w, h가 주어진다.

## Output

첫째 줄에 문제의 정답을 출력한다.

## Constraint

- 1 ≤ w, h ≤ 1,000
- 1 ≤ x ≤ w-1
- 1 ≤ y ≤ h-1
- x, y, w, h는 정수

## Example

#### input

```
6 2 10 3
```

#### output

```
1
```