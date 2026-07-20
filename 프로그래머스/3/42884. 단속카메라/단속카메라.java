import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        // 정렬
        Arrays.sort(routes, (a, b)-> a[1]- b[1]);
        int camera = routes[0][1];
        answer++;
        
        // 배열 끝까지 반복
        for(int i=1; i<routes.length; i++) {
           // 최적의 해 선택
           if((routes[i][0] <= camera) && (camera <= routes[i][1]))
              continue;
           else {
              camera = routes[i][1];
              answer++;
              }
        }

        return answer;
    }
}