###### [*Home*](../../../../README.md) / [*BOJ*](../../../../BAEKJOON.md) / *2751*

# [백준 2751] 수 정렬하기 2

<details>
    <summary>
        <i><strong>Problem - <a href="https://www.acmicpc.net/problem/2751">@BOJ</a></strong></i>
    </summary>
    <h2><i>Problem</i></h2>
    <p>
        N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
    </p>
    <h2><i>Input</i></h2>
    <p>
        첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
    </p>
    <h2><i>Output</i></h2>
    <p>
        첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
    </p>
    <h2><i>Example</i></h2>
    <h3><i>in</i></h3>
    <pre><code>5
5
4
3
2
1</code></pre>
    <h3><i>out</i></h3>
    <pre><code>1
2
3
4
5</code></pre>
</details>

## *Solution*

|No |Concept              |Memory   |Time   |Code Length|
|:-:|:--------------------|---------|-------|-----------|
|1  |[PriorityQueue][1]   |126440 KB|1668 ms|1194 B     |
|2  |[boolean[2000001]][2]| 66224 KB| 784 ms|1200 B     |

<a id="PriorityQueue"></a>

### *PriorityQueue*

* [***code***](http://boj.kr/a5086d5fdd584e5083c352906fff1d3a)

* 자동으로 정렬해주는 자료구조 `PriorityQueue`를 활용하여 입력되는 대로 `Queue`에 `offer()` 하고, 입력이 끝나면 `poll()`하여 오름차순으로 출력합니다.

```java
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    private static BufferedWriter bw;
    private static PriorityQueue<Integer> pq;

    /**
     * 입력될 수(N)만큼 수를 입력받고, PriorityQueue에 offer
     * @throws IOException because of System.in.read()
     */
    private static void initBOJ2751() throws IOException {

        // 필요한 변수 선언
        int N, num, c;

        // 사용할 객체 생성
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        pq = new PriorityQueue<>();

        // N값 입력받기
        N = System.in.read() - '0';
        while ((c = System.in.read()) > 13) N = 10 * N + c - '0';
        // System.in.read();

        // N만큼 수(num) 입력받기
        while (N-->0) {
             // 입력할 수가 양수인지 음수인지 판별해야 하므로 우선 읽는다.
            num = System.in.read();

            if (num == '-') { // num이 음수일 경우 c를 계속해서 빼줌
                num = 0;
                while ((c = System.in.read()) > 13) num = 10 * num - (c - '0');
            } else {          // num이 양수일 경우 N을 입력받은 것과 동일하게 받음
                num -= '0';
                while ((c = System.in.read()) > 13) num = 10 * num + (c - '0');
            } // System.in.read();

            pq.offer(num); // 입력받은 수를 Queue에 offer
        }

    }

    /**
     * PriorityQueue에 저장된 값을 하나씩 poll하여 bw로 출력.
     * pq가 자동으로 오름차순 정렬해주기 때문에 그냥 poll한다.
     * @throws IOException because of BufferedWriter
     */
    private static void printASC() throws IOException {

        while (!pq.isEmpty()) bw.append(pq.poll() + "\n");
        bw.close();

    }

    public static void main(String[] args) throws IOException {

        initBOJ2751(); // 1. N개의 수를 입력받고 Queue에 offer
        printASC();    // 2. 결과를 하나씩 출력

    }

}
```

* 입력하는 부분에서 헷갈리신다면 [여기](Java02.java)를 보셔도 됩니다. 미비한 차이(300ms 정도 단축)이지만 성능개선을 위해 위와 같이 작성했습니다.

<a id="boolean[2000001]"></a>

### *boolean[2000001]*

* [***code***](http://boj.kr/80d248761b48418ea90a0f78644a5358)

1. 문제 상에서 숫자의 범위가 *-1,000,000 ≤ N ≤ 1,000,000* 이므로 전체 *2,000,001* 크기의 `boolean` 배열을 생성합니다.
2. 인덱스 번호가 음수를 가질 수는 없으므로 수를 입력받으면 **백만**(*1,000,000*)을 더하여 해당하는 인덱스의 값을 `true`로 변경해줍니다.
3. 입력이 끝나고 출력 시 `boolean` 배열을 전체탐색하여 값이 `true`인 인덱스에서 **백만**을 빼주고 출력합니다.

```java
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    /** 수의 범위 만큼의 배열 */
    private static boolean[] range;
    private static BufferedWriter bw;

    /**
     * range 배열 인덱스(입력 받을 수 + 백만)의 값을 true로 변경
     * @throws IOException because of System.in.read()
     */
    private static void initBOJ2751() throws IOException {

        int N, num, c; // 사용할 변수 선언

        // 사용할 객체 생성
        range = new boolean[2000001];
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N값 입력받기
        N = System.in.read() - '0';
        while ((c = System.in.read()) > 13) N = 10 * N + c - '0';
        // System.in.read();

        // N개 만큼 수를 입력받기
        while (N-->0) {

            num = System.in.read();

            if (num == '-') {
                num = 0;
                while ((c = System.in.read()) > 13) num = 10 * num - (c - '0');
            } else {
                num -= '0';
                while ((c = System.in.read()) > 13) num = 10 * num + (c - '0');
            }// System.in.read();

            // 읽은 수에 해당하는 인덱스의 값을 true로 변경
            range[num + 1000000] = true;

        }

    }

    /**
     * range를 전체탐색하여 값이 true인 인덱스에서 백만을 빼고 출력
     * @throws IOException because of {@link BufferedWriter}
     */
    private static void printASC() throws IOException {

        for (int i = 0; i < 2000001; i++) if (range[i]) bw.append((i - 1000000) + "\n");
        bw.close();

    }

    public static void main(String[] args) throws IOException {

        initBOJ2751();
        printASC();

    }

}
```

<!-- ref -->
[1]: #PriorityQueue
[2]: #boolean[2000001]
