package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class ex0711 {

    /**
     * 백준 11286 절댓값 힙 구현하기
     * 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
     * 배열에 정수 x (x ≠ 0)를 넣는다.
     * 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
     * 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
     * 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
     */

    /**
     * 입력
     * 첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다.
     * 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
     * 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고,
     * x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
     * 입력되는 정수는 -231보다 크고, 231보다 작다.
     */

    /**
     * 출력
     * 입력에서 0이 주어진 회수만큼 답을 출력한다.
     * 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
     */

    /**
     * N의 최대범위가 100,000으로 O(nlogn) 시간 복잡도를 가진 알고리즘으로 풀 수 있다.
     * 데이터가 새로 삽입될 때마다 절댓값과 관련된 정렬이 필요하므로 우선순위 큐로
     * 문제를 쉽게 해결할 수 있다.
     * 단, 이 문제는 절댓값 정렬이 필요하므로 우선순위 큐의 정렬 기준을 직접 정의해야 한다.
     * 절댓값이 같을 때는 음수를 우선하여 출력해야 하는 사실을 기억하며 문제에 접근해야 한다.
     */

    /**
     * x = 0일 때
     * 큐가 비어 있을때는 0을 출력하고 비어 있지 않을 때는 절댓값이 최소인 값을 출력한다.
     * 단, 절댓값이 같다면 음수를 우선하여 출력한다.
     * x = 1일 때
     * add로 큐에 새로운 값을 추가하고 우선순위 큐 정렬 기준으로 자동 정렬한다.
     */

    /**
     * n(질의 요청 개수)
     * 우선순위 큐 선언
     *  - 절댓값 기준으로 정렬되도록 설정하기
     *  - 단, 절댓값이 같으면 음수 우선 정렬하기
     *  for(n만큼 반복)
     *  {
     *      요청이 0일 때: 큐가 비어 있으면 0, 비어 있지 않으면 큐의 front값 출력하기(poll())
     *      요청이 1일 때: 새로운 데이터를 우선순위 큐에 더하기(add())
     *  }
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
            //절댓값이 같은 경우 음수 우선
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs) { //절댓값이 같은 경우 음수 우선
                return o1 > o2 ? 1 : -1;
            }
            return first_abs - second_abs; //절댓값 작은 데이터 우선
        });
        for (int i = 0; i < n; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if (myQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(myQueue.poll());
                }
            } else {
                myQueue.add(request);
            }
        }
    }
}
