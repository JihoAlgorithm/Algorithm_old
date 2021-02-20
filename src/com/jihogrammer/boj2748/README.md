###### [*Home*](../../../../README.md) / [*BOJ*](../../../../BAEKJOON.md) / *2748*

# [백준 2748] 피보나치 수 2

<details>
    <summary>
        <i><strong>Problem - <a href="https://www.acmicpc.net/problem/10989">@BOJ</a></strong></i>
    </summary>
    <h2><i>Problem</i></h2>
    <p>
        피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
    <br/>
        이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
    <br/>
        n=17일때 까지 피보나치 수를 써보면 다음과 같다.
    <br/>
        0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
    <br/>
        n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
    </p>
    <h2><i>Input</i></h2>
    <p>
        첫째 줄에 n이 주어진다. n은 90보다 작거나 같은 자연수이다.
    </p>
    <h2><i>Output</i></h2>
    <p>
        첫째 줄에 n번째 피보나치 수를 출력한다.
    </p>
    <h2><i>Example</i></h2>
    <h3><i>in</i></h3>
    <pre><code>10</code></pre>
    <h3><i>out</i></h3>
    <pre><code>55</code></pre>
</details>

## *Solution*

|No |Concept|Memory   |Time   |Code Length|
|:-:|:------|---------|-------|-----------|
|1  |[DP][1]| 14540 KB| 128 ms|      392 B|

<a id="sol1"></a>

### *DP*

* [***Submit Code***](http://boj.kr/14d9ce33390049ea9d90ca842cf401a8)
* [***Java File***](Java01.java)

<p align="center">
    <img src="https://user-images.githubusercontent.com/75299843/108587633-26e99e80-7398-11eb-96aa-320779b5e28a.jpg">
</p>

#### pseudo code

```swift
N ← TC입력
F[N+1] 배열 생성 // 상향식 접근으로 Fibonacci 0~N을 모두 계산
F[0] ← 0
F[1] ← 1

for i ← 2 to N
    F[i] ← F[i-2] + F[i-1]

print F[N] // 결과 출력
```

<!-- ref -->
[1]: #sol1
