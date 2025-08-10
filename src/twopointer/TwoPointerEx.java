package twopointer;

// N개의 수로 된 수열에서 합이 M인 부분 연속 수열의 개수 구하기
// 핵심: start와 end 포인터를 한 방향으로만 이동시키며 탐색 범위를 효율적으로 조절합니다.
public class TwoPointerEx {
    public int findSubsequenceCount(int[] arr, int M) {
        int count = 0;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum > M && start <= end) {
                sum -= arr[start++];
            }

            if (sum == M) {
                count++;
            }
        }

        return count;
    }
}
