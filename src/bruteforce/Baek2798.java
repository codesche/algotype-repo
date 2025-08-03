package bruteforce;

import java.io.*;
import java.util.StringTokenizer;

// 백준 - 블랙잭 (브론즈 2)
public class Baek2798 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] card = new int[m];
        for (int i = 0; i < m; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        // m에 최대한 가까운 카드 3장의 합 출력하는 로직 작성
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    if (card[i] + card[j] + card[k] > n) {
                        continue;
                    } else {
                        answer = Math.max(answer, card[i] + card[j] + card[k]);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
