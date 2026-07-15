class Solution {
    public int solution(String name) {
        int answer = 0;
        
        // 1. 위아래 이동 계산
        // 모든 문자에 대해 
        // 위 거리, 아래 거리 중 작은 값을 answer에 더한다
        for(int i=0; i<name.length(); i++) {
            char c = name.charAt(i);
            answer += Math.min(c-'A', 'Z'-c+1);
        }
        
        
        // 2. 좌우 이동 계산
        int move = name.length() - 1;
        
        for(int i=0; i<name.length(); i++) {
            int next = i+1;
            
            // next부터 연속된 a를 모두 건너 뛴다
            while(next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
        
            // 오른쪽으로 갔다가 되돌아오는 경우
            move = Math.min(move, i * 2 + (name.length() - next));
            // 왼쪽으로 갔다가 되돌아오는 경우                
            move = Math.min(move, (name.length() - next) * 2 + i);
        }
        
        // 3. 정답
        // 지금까지의 쵯 이동 횟수와 비교하여 갱신
        return answer + move;
    }
    
    
}
