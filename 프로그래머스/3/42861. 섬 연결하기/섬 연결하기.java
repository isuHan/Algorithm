import java.util.Arrays;

class Solution {

    int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        for (int i = 0; i < costs.length; i++) {

            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];

            if (find(start) != find(end)) {
                union(start, end);
                answer += cost;
            }
        }

        return answer;
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        parent[rootB] = rootA;
    }
}