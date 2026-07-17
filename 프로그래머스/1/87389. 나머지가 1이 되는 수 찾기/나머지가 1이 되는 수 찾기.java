class Solution {
    public int solution(int n) {
        int answer = Integer.MAX_VALUE;

        for (int x = n; x > 0; x--) {
            if (n % x == 1) {
                answer = Math.min(answer, x);
            }
        }

        return answer;
    }
}