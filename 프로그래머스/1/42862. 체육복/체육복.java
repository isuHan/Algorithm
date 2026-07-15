import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 겹치는 학생 제거
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        // 체육복 빌려주기
        for (int r : reserve) {

            if (r == -1) continue;

            boolean found = false;

            // 앞 학생 먼저
            for (int i = 0; i < lost.length; i++) {
                if (lost[i] == r - 1) {
                    lost[i] = -1;
                    found = true;
                    break;
                }
            }

            // 앞 학생이 없으면 뒤 학생
            if (!found) {
                for (int i = 0; i < lost.length; i++) {
                    if (lost[i] == r + 1) {
                        lost[i] = -1;
                        break;
                    }
                }
            }
        }

        int answer = n;

        for (int x : lost) {
            if (x != -1) {
                answer--;
            }
        }

        return answer;
    }
}