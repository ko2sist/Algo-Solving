import java.io.*;
import java.util.*;

// BJ #16928 - 뱀과 사다리 게임
// Strategy: BFS 응용
public class Main {
	static List<Route> route;
	static int N,M;
	
	public static class Route{
		int start;
		int end;
		
		public Route(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static int find() {
		int dice = 1;
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[101];
		
		q.add(1);
		visited[1] = true;
		
		loop: while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-- > 0) {
				int tmp = q.poll();
				
				for(int i=1; i<=6; i++) {
					int n = tmp+i;
					
					if(n == 100) {
						break loop;
					}
					
					if(n > 100) continue;
					if(visited[n]) continue;
					
					for(int j=0; j<N+M; j++) {	// 현재 지점에 연결된 사다리 or 뱀이 존재하는 지 체크
						Route tr = route.get(j);
						
						if(tr.start == n) {		// 존재 한다면 queue에 넣을 숫자를 도착점으로 변경
							n = tr.end;
							break;
						}
					}
					
					q.add(n);
					visited[n] = true;
				}
			}
			dice++;
		}
		
		return dice;
	}
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 변수 설정
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        route = new ArrayList<>();
        
        // 사다리 정보 입력
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            route.add(new Route(x,y));
        }
        
        // 뱀 정보 입력
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            route.add(new Route(u,v));
        }
        
        // 최소 횟수 계산
        int res = find();
        
        // 최종 결과 출력
        System.out.print(res);
    }
}