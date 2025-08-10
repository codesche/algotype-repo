package javaio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 핵심: BufferedReader로 입력을 받고 StringTokenizer나 String.split()으로 파싱합니다.
 * 출력이 많을 때는 System.out.println()을 반복 호출하는 대신
 * StringBuilder에 결과를 모아 마지막에 한 번만 출력하는 것이 성능에 유리합니다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 위한 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 한 줄 읽기
        String line = br.readLine();
        int N = Integer.parseInt(line);

        // 공백으로 구분된 여러 값 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 결과를 한 번에 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("결과: ").append(a + b);

        System.out.println(sb.toString());

        br.close();
    }
}
