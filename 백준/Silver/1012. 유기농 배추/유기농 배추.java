import java.util.*;
import java.io.*;

// BJ #1012 - 유기농 배추
public class Main {
	// visit: DFS 응용
	public static int visit(int[][] fields, boolean[][] visited, int i, int j, int N, int M) {
		visited[i][j] = true;
		int num_visited = 1;
		
		//visit right
		if(j+1 < M) {
			if(fields[i][j+1] == 1 && !visited[i][j+1]) {
				num_visited += visit(fields, visited, i, j+1, N, M);
			}
		}
		//visit left
		if(j-1 >= 0) {
			if(fields[i][j-1] == 1 && !visited[i][j-1]) {
				num_visited += visit(fields, visited, i, j-1, N, M);
			}
		}
		//visit top
		if(i+1 < N) {
			if(fields[i+1][j] == 1 && !visited[i+1][j]) {
				num_visited += visit(fields, visited, i+1, j, N, M);
			}
		}
		//visit bottom
		if(i-1 >= 0) {
			if(fields[i-1][j] == 1 && !visited[i-1][j]) {
				num_visited += visit(fields, visited, i-1, j, N, M);
			}
		}
		return num_visited;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 테스트 케이스 개수 T
		int T = Integer.parseInt(br.readLine());
		
		// 배추 위치 저장
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] field = new int[N][M];
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				field[Y][X] = 1;
			}
			
			// 2차원 배열 field를 순회하며 각 위치가 배추가 존재하면서
			// 방문하지 않은 위치이면 DFS를 응용, 이어진 배추를 순회
			// 이어진 배추를 모두 방문하면 res++, 방문한 배추의 수가
			// K와 같으면 반복문 종료
			boolean[][] visited = new boolean[N][M];
			int res = 0;
			int num_visited = 0;
			loop: for(int k=0; k<N; k++) {
				for(int l=0; l<M; l++) {
					if(num_visited == K) {
						break loop;
					}
					if(field[k][l] == 1 && !visited[k][l]) {
						num_visited += visit(field, visited, k, l, N, M);
						res++;
					}
				}
			}
			
			sb.append(res).append("\n");
		}
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}
