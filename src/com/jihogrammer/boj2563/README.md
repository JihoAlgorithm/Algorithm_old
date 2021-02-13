###### [Home](../../../README.md) / [BJ](../../README.md) / 2563 - 색종이

# [백준 2563] 색종이

## *Summary*

* 문제는 [여기](https://www.acmicpc.net/problem/2563)에서 확인하세요.

|No       |Lang|Memory  |Time  |Length|Concept      |
|:-------:|:--:|-------:|-----:|-----:|:------------|
|[1](###1)|Java|14416 KB|132 ms|1180 B|`boolean[][]`|

## *Solution*

### *1*

* [***Full Code***](Java01.java)
* **도화지**를 `boolean[][]`로 생성하여 `true`로 색칠하면서 그 수를 카운트

#### ■ *Class Member Variables*

```java
private static int N;                      // 색종이의 수
private static int area;                   // 결과: 색칠된 넓이
private static final int X = 0, Y = 1;     // 색종이 X, Y 좌표 상수
private static int[][] coloredPaper;       // 색종이 좌표들을 저장
private static boolean[][] drawingPaper;   // 도화지
```

* 굳이 이렇게 변수들을 `main()` 밖으로 뺄 필요는 없지만, ***Java***를 공부하면서 최대한 ***Method***를 활용하기 위해 빼두었습니다. 각 여러 메소드들이 이들을 매개변수로 주고 받는 것은 비효율적이라 생각하여 필드로 정의하였습니다.

#### ■ *main()*

```java
public static void main(String[] args) throws Exception {

    init();                     // 1. 색종이 및 도화지 초기화
    paint();                    // 2. 도화지 색칠 및 넓이 계산
    System.out.print(area);     // 3. 넓이 출력

}
```

* 위와 같은 이유로 `main()`은 최대한 간결하게 구현했습니다.

#### ■ *init()*

```java
private static void init() throws Exception {
		
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    N = Integer.parseInt(br.readLine());
    
    coloredPaper = new int[N][2];
    drawingPaper = new boolean[101][101];
    res = 0;
    
    for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        
        coloredPaper[i][X] = Integer.parseInt(st.nextToken());
        coloredPaper[i][Y] = Integer.parseInt(st.nextToken());
    }
    
}
```

#### ■ *paint()*

```java
private static void paint() {
        
    for (int i = 0; i < N; i++)
        paint(coloredPaper[i][X], coloredPaper[i][Y]);
    
}
```

#### ■ *paint(int x, int y)*

```java
private static void paint(int x, int y) {
        
    int w = x + 10;
    int h = y + 10;
    
    for (int i = x; i < w; i++)
    for (int j = y; j < h; j++) {
        if (!drawingPaper[i][j]) {
            drawingPaper[i][j] = true;
            res++;
        }
    }
    
}
```

---
