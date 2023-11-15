package com.example.prac_algorithm.code;

import java.io.*;
import java.util.StringTokenizer;

/** 완전탐색 , 브루트 포스 */
public class Code_1 {



    /**
     *  자연수 N 과 M 이 주어졌을 때 , 아래 조건을 만족하는 길이가 M 인 수열을 모두 구하는 프로그램
     *  1부터 N 까지 자연수 중에 M 개를 고른 수열
     *  같은 수를 여러 번 골라도됨,
     *  첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
     */

    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    static int N,M;
    static int[] selected;

    // 재귀 함수
    // M 개를 전부 고름 -> 조건에 맞는 탐색 한 가지 성공
    // 아직 M 개를 고르지 않음 -> k 번째 부터 M 번째 원소를 조건에 맞게 고르는 모든 방법 시도
    static void rec_func(int k) {
        if (k == M + 1) {
            // selected[1...M] 배열이 새롭게 탐색된 결과
            for (int i=1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                // k+1 qjs ~ M 번을 모두 탐색하는 일을 해야함.
                rec_func(k+1);
                selected[k] = 0;

            }
        }

    }

    public static void main(String[] args) {
        input();
        // 1번 째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법 탐색
        rec_func(1);
        System.out.println(sb.toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


}
