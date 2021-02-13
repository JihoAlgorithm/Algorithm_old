###### [*Home*](../../../../README.md) / [*BOJ*](../../../../BAEKJOON.md) / *10989*

# [백준 10989] 수 정렬하기 3

<details>
    <summary>
        <i><strong>Problem - <a href="https://www.acmicpc.net/problem/10989">@BOJ</a></strong></i>
    </summary>
    <h2><i>Problem</i></h2>
    <p>
        N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
    </p>
    <h2><i>Input</i></h2>
    <p>
        첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
    </p>
    <h2><i>Output</i></h2>
    <p>
        첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
    </p>
    <h2><i>Example</i></h2>
    <h3><i>in</i></h3>
    <pre><code>10
5
2
3
1
4
2
3
5
1
7</code></pre>
    <h3><i>out</i></h3>
    <pre><code>1
1
2
2
3
3
4
5
5
7</code></pre>
</details>

## *Solution*

|No |Concept                   |Memory   |Time   |Code Length|
|:-:|:-------------------------|---------|-------|-----------|
|1  |[int[10001] & repeat()][1]| 70220 KB|1092 ms|      955 B|

<a id="sol1"></a>

### *int[10001] & repeat()*

* [***code***](http://boj.kr/d6ea0764b1cb4395a039fa6b3cf43011)

1. `int[10001]`을 활용하여 입력된 수(`num`)를 인덱스로 잡고 **해당 인덱스의 값을 1을 더합니다**.
2. 출력 시 `String` class의 `repeat()` 메소드를 활용하여 `nums` 배열(0으로 초기화 되어 있음)에서 **해당 인덱스의 값만큼 반복하여 출력**합니다.

```java
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    /** 1부터 10000까지의 수가 몇 번 입력되었는지 저장 */
    private static int[] nums;
    private static BufferedWriter bw;

    /**
     * N개의 수를 입력받고, nums 배열 해당 인덱스의 값을 1씩 증가
     * @throws IOException because of System.in.read()
     */
    private static void initBOJ10989() throws IOException {

        int N, num, c; // 필요한 변수 선언

        // 필요한 객체 생성
        nums = new int[10001];
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N값 입력받기
        N = System.in.read() - '0';
        while ((c = System.in.read()) > 13) N = 10 * N + c - '0';
        // System.in.read();

        while (N-->0) { // N개의 수를 입력받기

            // 숫자 읽기
            num = System.in.read() - '0';
            while ((c = System.in.read()) > 13) num = 10 * num + c - '0';
            // System.in.read();

            nums[num]++; // 읽은 숫자를 인덱스로 하는 값을 1 증가

        }

    }

    /**
     * repeat() 메소드를 활용하여 bw로 간단하게 출력
     * @throws IOException because of {@link BufferedWriter}
     */
    private static void printASC() throws IOException {

        // nums는 0으로 초기화 되어 있으므로 repeat()을 만나 0이면 출력 안 함
        for (int i = 1; i < 10001; i++) // 0은 자연수가 아니라 생략
            bw.write( (i + "\n").repeat(nums[i]) );

        bw.close(); // 최종 출력

    }

    public static void main(String[] args) throws IOException {

        initBOJ10989();
        printASC();

    }

}
```

* `System.in.read()`에 관한 글은 추후 작성하겠습니다.

<!-- ref -->
[1]: #sol1
