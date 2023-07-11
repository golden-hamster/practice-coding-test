package study;

import java.util.Arrays;
import java.util.Scanner;

public class ex0712 {

    /**
     * 백준 2750 수정렬하기1
     *
     * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
     *
     * <----------------입력------------------->
     *     첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
     *     둘째 줄부터 N개의 줄에는 수가 주어진다.
     *     이 수는 절댓값이 1,000보다 작거나 같은 정수이다.
     *     수는 중복되지 않는다.
     * </----------------입력------------------->
     *
     * <-----------------출력------------------->
     *     첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
     * </-----------------출력------------------->
     */

    /**
     * 자바에서는 sort() 함수를 이용해 쉽게 정렬할 수 있지만, 정렬을 직접 구현할 줄 알아야 한다 .
     * n의 최대 범위가 1,000으로 매우 작기 때문에 o(n^2)시간 복잡도 알고리즘으로 풀 수 있다.
     * 버블 정렬의 시간 복잡도가 o(n^2)이므로 버블 정렬 알고리즘을 이용해 정렬해도 된다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        //버블 정렬을 구현하는 영역
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);

        }
    }
}
