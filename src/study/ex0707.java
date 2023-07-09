package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex0707 {

    /**
     * 백준 1940 주몽의 명령
     * 주몽은 철기군을 양성하기 위한 프로젝트에 나섰다. 그래서 야철대장을 통해 철기군이 입을 갑옷을 만들게 하였다.
     * 야철대장은 주몽의 명에 따르기 위하여 연구에 착수하던 중 아래와 같은 사실을 발견하게 되었다.
     * 갑옷을 만드는 재료들은 각각 고유한 번호를 가지고 있다. 갑옷은 두 개의 재료로 만드는데
     * 두 재료의 고유한 번호를 합쳐서 M(1 ≤ M ≤ 10,000,000)이 되면 갑옷이 만들어 지게 된다.
     * 야철대장은 자신이 만들고 있는 재료를 가지고 갑옷을 몇 개나 만들 수 있는지 궁금해졌다.
     * 이러한 궁금증을 풀어 주기 위하여 N(1 ≤ N ≤ 15,000) 개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램을 작성하시오.
     */

    /**
     * 입력
     * 첫째 줄에는 재료의 개수 N(1 ≤ N ≤ 15,000)이 주어진다.
     * 그리고 두 번째 줄에는 갑옷을 만드는데 필요한 수 M(1 ≤ M ≤ 10,000,000) 주어진다.
     * 그리고 마지막으로 셋째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다.
     * 고유한 번호는 100,000보다 작거나 같은 자연수이다.
     */

    /**
     * 출력
     * 첫째 줄에 갑옷을 만들 수 있는 개수를 출력한다.
     */

    /**
     * 두 재료의 번호의 합, 즉 크기를 비교하므로 값을 정렬하면 문제를 좀 더 쉽게 풀 수 있다.
     * N의 최대 범위가 15,000이므로 O(nlogn) 시간 복잡도 알고리즘을 사용해도 문제가 없다.
     * 일반적으로 정렬 알고리즘의 시간 복잡도는 O(nlogn)이므로 정렬을 사용해도 괜찮다.
     * 입력한 N개의 재료값을 정렬한 다음 양쪽 끝의 위치를 투 포인터로 지정해 문제에 접근해 보자
     */

    /**
     * 슈도코드
     * n(재료의 개수), m(갑옷이 되는 번호) 저장하기
     * for(n만큼 반복)
     * {
     *     재료 배열 저장하기
     * }
     * 재료 배열 정렬하기
     * while(i<j)
     * {
     *     if(재료 합 < m) 작은 번호 재료를 한 칸 위로 변경하기
     *     else if(재료 합 > m) 큰 번호 재료를 한 칸 아래로 변경하기
     *     else count 증가, 양쪽 index 각각 변경하기
     * }
     * count 출력하기
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;
        int i = 0; //A[0] -> Min
        int j = n - 1; // A[n-1] -> Max
        while (i < j) {
            if (A[i] + A[j] < m) {
                i++;
            } else if (A[i] + A[j] > m) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);

    }
}
