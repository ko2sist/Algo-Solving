import java.io.*;
import java.util.*;

// BJ #11724 - 연결 요소의 개수
// Strategy:  DFS
public class Main {
    static int N;
    static int M;
    static List<List<Integer>> graph;
    static boolean[] visited;
    
    public static void dfs(int n) {
        visited[n] = true;
        
        Iterator<Integer> iter = graph.get(n).iterator();
        while(iter.hasNext()) {
        	int n2 = iter.next();
        	if(!visited[n2]) {
        		dfs(n2);
        	}
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // graph: ArrayList를 통해 구현한 그래프
        graph = new ArrayList<>();
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        // 그래프 연결 정보 입력
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // visited: n번 node를 방문하면 visited[n] = true;
        visited = new boolean[N+1];
        
        // visited를 순회하며 현재 정점이 방문하지 않은 점이라면 dfs 실행,
        // res에는 dfs 실행 횟수, 즉 연결 요소의 개수가 저장된다.
        int res = 0;
        for(int i=1; i<N+1; i++) {
        	if(!visited[i]) {
        		dfs(i);
        		res++;
        	}
        }
        
        // 최종 결과 출력
        System.out.println(res);

    }
}