[MAIN](../../README.md)|<img width=50/>#3053<img width=50/>|[Baekjoon](https://www.acmicpc.net/problem/3053)
-|-|-

# 택시 기하학

## Solution

- [Java - 01](Java01.java) : 그나마 이해할 수 있는 형태
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
StringBuilder sb = new StringBuilder();
int r = Integer.parseInt(br.readLine()); // 문제 푸는데 double형일 필요는 없음

sb.append(r*r*Math.PI).append('\n').append(2*r*r);
System.out.print(sb);
```
- [Java - 02](Java02.java) : 숏코딩 // 그치만 예쁘게 펼쳐두자
```java
/* class Main{public static void main(String[] x)throws Exception{int c,r=0;while((c=System.in.read())>13)r=r*10+(c-48);System.out.print(Math.PI*r*r+"\n"+2*r*r);}} */
class Main {
    public static void main(String[] x) throws Exception {
        int c, r = 0;
        // 한 문자씩 읽어 r값에 대입
        while((c = System.in.read()) > 13) r = r * 10 + (c-'0'); // ASCII '0' -> 48
        System.out.print(Math.PI*r*r + "\n" + 2*r*r); // 유클리드 기하학 결과(Math.PI*r*r) + 택시 기하학 결과(2*r*r)
        /** 아래처럼 출력하면 시간이 더 단축되기는 한다.
         * System.out.println(Math.PI*r*r);
         * System.out.print(2*r*r);
         * 아마 숫자와 문자열을 합치는 과정에서 시간이 더 소모되는 듯 */
    }
}
```

> ###### 참고 : [택시기하학 - 네이버 지식백과](https://terms.naver.com/entry.nhn?docId=3567439&cid=58944&categoryId=58970)

## Problem

19세기 독일 수학자 헤르만 민코프스키는 비유클리드 기하학 중 택시 기하학을 고안했다.

택시 기하학에서 두 점 T1(x1,y1), T2(x2,y2) 사이의 거리는 다음과 같이 구할 수 있다.

D(T1,T2) = |x1-x2| + |y1-y2|

두 점 사이의 거리를 제외한 나머지 정의는 유클리드 기하학에서의 정의와 같다.

따라서 택시 기하학에서 원의 정의는 유클리드 기하학에서 원의 정의와 같다.

원: 평면 상의 어떤 점에서 거리가 일정한 점들의 집합

반지름 R이 주어졌을 때, 유클리드 기하학에서 원의 넓이와, 택시 기하학에서 원의 넓이를 구하는 프로그램을 작성하시오.

## Input

첫째 줄에 반지름 R이 주어진다. R은 10,000보다 작거나 같은 자연수이다.

## Output

첫째 줄에는 유클리드 기하학에서 반지름이 R인 원의 넓이를, 둘째 줄에는 택시 기하학에서 반지름이 R인 원의 넓이를 출력한다. 정답과의 오차는 0.0001까지 허용한다.

## Example

#### input

```
1
```

#### output

```
3.141593
2.000000
```