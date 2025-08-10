package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

// 배열에서 크기가 K인 모든 연속 부분 배열의 최댓값 찾기
// 투 포인터와 유사하지만, 창문의 크기가 고정되거나 특정 조건에 따라 조절됩니다.
// 핵심: Deque을 사용하면 윈도우의 양쪽 끝에서 데이터를 효율적으로 추가/제거할 수 있어
// $O(N)$의 시간 복잡도를 달성할 수 있습니다.
public class SwExample {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> window = new ArrayDeque<>();         // 인덱스를 저장할 때

        for (int i = 0; i < nums.length; i++) {
            // 윈도우 범위를 벗어난 인덱스 제거
            if (!window.isEmpty() && window.peekFirst() <= i - k) {
                window.pollFirst();
            }

            // 새로 들어올 값보다 작은 값들은 덱에서 제거 (최댓값 후보가 아니므로)
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }

            window.offerLast(i);

            // 윈도우가 꽉 찼을 때부터 결과를 저장
            if (i >= k - 1) {
                result[i - k + 1] = nums[window.peekFirst()];
            }
        }
        return result;
    }
}
