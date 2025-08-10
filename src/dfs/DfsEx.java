package dfs;

/**
 * 깊이 우선 탐색 (DFS - Depth First Search)
 * 그래프나 트리에서 한 방향으로 갈 수 있을 때까지 깊게 탐색하는 방식입니다. 재귀 함수나 스택을 이용하여 구현합니다.
 */
import java.util.*;

public class DfsEx {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public int countConnectedComponents(int n, int[][] edges) {
        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge :edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int componentCount = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                componentCount++;
            }
        }
        return componentCount;
    }

    private void dfs(int u) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

}
