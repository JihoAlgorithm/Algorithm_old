###### [*Home*](../../../../README.md) / [*SWEA*](../../../../SWEA.md) / *6808*

# [SWEA 6808] 규영이와 인영이의 카드게임

<details>
    <summary>
        <i><strong>Problem</strong></i>
    </summary>
    <h2><i>Problem</i></h2>
    <p>
        규영이와 인영이는 1에서 18까지의 수가 적힌 18장의 카드로 게임을 하고 있다.
    <br>
        한 번의 게임에 둘은 카드를 잘 섞어 9장씩 카드를 나눈다. 그리고 아홉 라운드에 걸쳐 게임을 진행한다.
    <br>
        한 라운드에는 한 장씩 카드를 낸 다음 두 사람이 낸 카드에 적힌 수를 비교해서 점수를 계산한다.
    <br>
        높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고,
    <br>
        낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.
    <br>
        이렇게 아홉 라운드를 끝내고 총점을 따졌을 때, 총점이 더 높은 사람이 이 게임의 승자가 된다.
    <br>
        두 사람의 총점이 같으면 무승부이다.
    <br>
        이번 게임에 규영이가 받은 9장의 카드에 적힌 수가 주어진다.
    <br>
        규영이가 내는 카드의 순서를 고정하면, 인영이가 어떻게 카드를 내는지에 따른 9!가지 순서에 따라
    <br>
        규영이의 승패가 정해질 것이다.
    <br>
        이 때, 규영이가 이기는 경우와 지는 경우가 총 몇 가지 인지 구하는 프로그램을 작성하라.
    </p>
    <h2><i>Input</i></h2>
    <p>
        첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
    <br>
        각 테스트 케이스의 첫 번째 줄에는 아홉 개의 정수가 공백으로 구분되어 주어진다.
    <br>
        각 정수는 1이상 18이하이며, 같은 정수는 없다.
    <br>
        규영이는 정수가 주어지는 순서대로 카드를 낸다고 생각하면 된다.
    </p>
    <h2><i>Output</i></h2>
    <p>
        각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,
    <br>
        인영이가 카드를 내는 9! 가지의 경우에 대해 규영이가 게임을 이기는 경우의 수와 게임을 지는 경우의 수를
    <br>
        공백 하나로 구분하여 출력한다.
    </p>
    <h2><i>Example</i></h2>
    <h3><i>in</i></h3>
    <pre><code>4                         // 테스트 케이스 개수
1 3 5 7 9 11 13 15 17     // 1st TC, 9장의 카드에 대한 정보
18 16 14 12 10 8 6 4 2    // 2nd TC
13 17 9 5 18 7 11 1 15
1 6 7 9 12 13 15 17 18</code></pre>
    <h3><i>out</i></h3>
    <pre><code>#1 112097 250783  //첫 번째 테스트케이스 결과
#2 250783 112097  //두 번째 테스트케이스 결과
#3 336560 26320
#4 346656 16224</code></pre>
</details>

## *Solution*

|No | Concept            | Memory   | Time    |Code Length|
|:-:|:-------------------|----------|---------|-----------|
| 1 |[boolean[]][1]      | 20092 KB | 2020 ms |    2259 B |
| 2 |[bitmask][2]        | 19648 KB | 1833 ms |    1992 B |
| 3 |[NextPermutation][3]| 20904 KB | 1010 ms |    2372 B |

이 문제의 경우 **모든 경우의 수를 파악하는 순열 문제**입니다. 따라서 재귀를 통한 방법(1, 2)과 함수로 모든 경우의 수를 구하는 방법(3)으로 구현했습니다. 표에서 볼 수 있듯이 재귀가 항상 좋은 선택지는 아니라는 것을 알 수 있습니다. 여하튼 NP가 워낙 이 문제를 푸는 데 있어 가장 좋은 접근 방식이라고 생각할 수 있습니다.

<a id="sol1"></a>

### *boolean[]*

* [***code***](Java01.java) - 코드가 길어 이 문서에 포함시키지는 않겠습니다.

#### *draw()*

```java
private static void draw() throws IOException {

    int n = 0, i = 0;

    KY = new int[9];            // 규영이의 카드 배열
    IY = new int[9];            // 인영이의 카드 배열
    CARD = new boolean[19];     // 전체 카드 목록: 규영이가 가지면 true
    selected = new boolean[9];  // 재귀에서 사용할 기준 boolean 배열

    // 코드를 가독성이 좋게 짠 것이 아니라 죄송합니다.
    // 이 부분은 규영이가 카드를 뽑는 장면입니다.
    while ((WIN = System.in.read()) > 13) {

        if (WIN == ' ') {
            KY[i++] = n;    // 뽑은 카드를 규영이의 패에 넣는다.
            CARD[n] = true; // 뽑힌 카드(인덱스)를 true로 변환
            n = 0;
        } else n = 10 * n + WIN - '0';

    } System.in.read();
    KY[i] = n;
    CARD[n] = true;

    // CARD[]를 보고 인영이가 뽑게 될 카드 패를 추린다.
    for (i = 1, n = 0; i < 19; i++) {
        if (CARD[i]) continue;
        IY[n++] = i;
    }

    WIN = 0;

}
```

#### *permutation()*

```java
// 재귀로 구현하다 보니 어쩔 수 없이 score 값을 매개변수로 취합니다.
private static void permutation(int round, int kyScore, int iyScore) {

    // 재귀를 빠져 나갈 조건: 9라운드를 전부 수행했을 경우
    if (round == 9) {
        if (kyScore > iyScore) WIN++; // score 비교하여 승리 횟수 증가
        return;
    }

    // 9회 카드를 개시합니다.
    for (int i = 0; i < 9; i++) {

        if (!selected[i]) {

            // 비교할 값은 true로 변환하여 하위 재귀에서 다시 호출되지 않게 합니다.
            selected[i] = true;

            // 인영이의 카드와 비교하여 알맞게 재귀 호출합니다.
            if (KY[round] > IY[i])
                permutation(round+1, kyScore+KY[round]+IY[i], iyScore);
            else
                permutation(round+1, kyScore, iyScore+KY[round]+IY[i]);
            
            // i가 계속해서 늘어날 것이기 때문에 다음 i로 넘어가기 전에 다시 flase로 바꿔준다.
            selected[i] = false;

        }

    }

}
```

---

<a id="sol2"></a>

### *bitmask*

* [***code***](Java02.java) - 코드가 길어 이 문서에 포함시키지는 않겠습니다.

순열 문제를 해결하는 데 어느 정도 익숙해지긴 했지만, 아직까지는 완벽하다고 말할 수 있는 수준이 아닙니다. 그래서 난잡한 변수 사용 등 복잡한 현상이 빈번하게 발생하고 있는데, 정말 나중에 기회가 된다면 클린하게 다시 작성해두도록 하겠습니다.

```java
private static void draw() throws IOException {

    int c, n = 0, i = 0, flag = 0;

    WIN = 0;

    KY = new int[9];
    IY = new int[9];

    while ((c = System.in.read()) > 13) {

        if (c == ' ') {
            KY[i++] = n;
            flag |= 1 << n; // bitmask를 활용한 인덱싱
            n = 0;
        } else n = 10 * n + c - '0';

    } System.in.read();

    KY[i] = n;
    flag |= 1 << n;

    // 아래 for문도 두 줄로 바꿀 수 있지만,
    // 작성 시에는 이게 최선이라고 생각한 듯 합니다.
    for (i = 1, n = 0; i < 19; i++) {
        // bit 연산을 통해 값이 들어있는지 확인
        if ((flag & 1<<i) > 0) continue;
        IY[n++] = i;
    }

}
```

#### *permutation()*

`boolean` 배열을 사용하여 접근하는 방식과 유사하나, 매개변수가 더 많아지는 단점이 있습니다. 물론 성능은 bitmask가 약간 더 좋은 것으로 보입니다.

```java
// boolean을 사용하는 것보다 매개변수가 많은 낭패
private static void permutation(int round, int flag, int kyScore, int iyScore) {

    if (round == 9) {
        if (kyScore > iyScore) WIN++;
        return;
    }

    for (int i = 0; i < 9; i++) {

        if ((flag & 1 << i) > 0) continue;

        if (KY[round] > IY[i])
            permutation(round+1, flag | 1 << i, kyScore+KY[round]+IY[i], iyScore);
        else permutation(round+1, flag | 1 << i, kyScore, iyScore+KY[round]+IY[i]);

    }

}
```

---

<a id="sol3"></a>

### *NextPermutation*

* [***code***](Java03.java) - 코드가 길어 이 문서에 포함시키지는 않겠습니다.

***nPn***만큼 수행하여 반복하고 모든 경우의 수를 비교합니다. 따라서 구현 정도만 가능하지, 자세한 설명을 할 자신은 없습니다.

그래도 해야지. **규영**이는 패를 뽑은 순서대로 개시하기 때문에 **인영**이의 카드 패를 ***nPn*** 정렬하여 모든 경우의 수를 파악하고 점수를 계산합니다.

1. 인영의 패를 오름차순으로 정렬한다.
2. 1회차 비교하고 양 패를 순서대로 개시했을 경우 점수를 계산한다.
3. 인영의 패를 **NP**를 통해 재정렬한다.
4. 재정렬된 인영의 패를 다시 규영의 패와 순서대로 개시하고 계산한다.
5. 이를 반복하여 인영의 패가 내림차순으로 정렬, 즉 모든 경우의 수를 계산하고 규영이가 이긴 횟수를 계산한다.

#### *play()*

```java
private static void play() {

    int kyScore, iyScore;

    do {

        kyScore = 0;
        iyScore = 0;

    // 카드 패만큼 전부 순서대로 비교.
        // 이는 어차피 인영의 패를 모든 경우의 수로
        // 정렬하기 때문에 그냥 순서대로 개시하여 비교한다.
        for (int i = 0; i < CARD_NUM; i++)
            if (KY[i] > IY[i]) kyScore += KY[i] + IY[i];
            else iyScore += KY[i] + IY[i];

        // 9장의 패를 다 본 후 점수 비교
        if (kyScore > iyScore) WIN++;

    } while (nextPermutation()); // 인영의 다음 순열

}
```

#### *nextPermutation()*

```java
// 호출 전 인영의 패가 오름차순으로 정렬되어 있어야 함
private static boolean nextPermutation() {

    // 뒤에서부터 접근하여 제일 큰 수의 인덱스를 찾는다.
    int i = CARD_NUM - 1;
    while (i > 0 && IY[i-1] >= IY[i]) i--;

    // 탈출 조건 : 모든 경우의 수를 비교했음
    if (i == 0) return false;

    // 탑 왼쪽의 수보다 바로 한 단계 큰 수의 인덱스를 찾는다.
    int j = CARD_NUM - 1;
    while (IY[i-1] >= IY[j]) j--;

    swap(i-1, j); // 둘의 자리를 바꾸고

    // 탑의 오른쪽은 오름차순으로 정렬한다.
    j = CARD_NUM - 1;
    while (i < j) swap(i++, j--);

    // 여기까지 왔으면 순열을 잘 설정했다는 의미로 true 반환
    return true;

}
```

<!-- ref -->
[1]: #sol1
[2]: #sol2
[3]: #sol3
