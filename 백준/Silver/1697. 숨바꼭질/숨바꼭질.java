import java.io.*;
import java.util.*;

// BJ #1697 - 숨바꼭질
// Strategy: BFS 응용
public class Main {
	// getTime: BFS를 응용, K에서 N까지 거꾸로 경로 탐색, 시간 계산	
	public static int getTime(int N, int K) {
		boolean[] visited = new boolean[100001];    // BFS 실행을 위한 배열
		Queue<Integer> q = new LinkedList<>();		// BFS 실행을 위한 queue
		int time = 1;
		
		// BFS 실행
		visited[K] = true;
		q.add(K);
		
		loop: while(!q.isEmpty()) {
			int size = q.size();	// BFS를 실행하며 depth에 대한 정보를 알기 위해
									// 같은 depth에 있는 정점들을 모두 방문하면 depth, 즉 time이 1증가하게 함
			while(size-- != 0) {
				int tmp = q.poll();
				visited[tmp] = true;
				
				// BFS 실행 도중 N을 발견하면 함수 종료, return time
				if(tmp+1 == N || tmp-1 == N || (tmp%2 == 0 && tmp/2 == N)) {
					break loop;
				}
				
				// 수빈이가 움직일 수 있는 3가지 경우에 대해 정점들을 queue에 저장
				if(tmp+1 <= 100000 && !visited[tmp+1]) {
					q.add(tmp+1);
				}
				if(tmp-1 >= 0 && !visited[tmp-1]) {
					q.add(tmp-1);
				}
				if(tmp%2 == 0 && !visited[tmp/2]) {
					q.add(tmp/2);
				}
			}
			
			time++;	
		}
		
		
		return time;
	}
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        
        // N,K 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // K가 N보다 같거나 작을 경우 뒤로 걸어서 이동하는 방법 밖에 없다.
        // K가 N보다 클 경우 getTime함수 실행
        int res = 0;
        if(K <= N) {
        	res = N - K;
        }else {
        	res = getTime(N, K);
        }

        // 최종 결과 출력
        System.out.println(res);

    }
}