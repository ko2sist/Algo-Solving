import java.util.*;
import java.io.*;

// BJ #1520 - 내리막길
// Strategy : DFS + DP
public class Main {
    static int N,M,H;
    static int[][] map,dp;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};


    public static int findRoute(int row, int col) {
        if(row == M-1 && col == N-1) {      // 도착점에 도착 했을 경우 경로 개수 1개 증가
            return 1;
        }

        if(dp[row][col] != -1) return dp[row][col];     // 이미 처리된 칸일 경우 dp 배열에 저장된 값 반환

        dp[row][col] = 0;   // 현재 위치에서 도착점까지의 경로의 개수 0개로 초기화 (방문 처리 대신)

        for(int i=0; i<4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;    // nr,nc가 map 범위를 벗어날 경우
            if(map[row][col] <= map[nr][nc]) continue;  // 다음 진행할 칸의 높이가 현재 칸의 높이 이상일 경우

            dp[row][col] += findRoute(nr,nc);   // 다음 칸에 대해 DFS 실행해서 현재 칸의 경로 개수에 더해준다
        }

        return dp[row][col];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지도의 가로 세로 크기 입력(M: 세로, N: 가로)
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 지도의 각 칸의 높이를 저장할 2차원 배열 생성
        map = new int[M][N];

        // 각 칸의 높이 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 경로 찾기 과정에서 dp를 이용하기 위한 2차원 배열 생성
        dp = new int[M][N];
        for(int i=0; i<M; i++){     // dp 배열은 -1로 초기화 해놓는다
            Arrays.fill(dp[i],-1);
        }

        // 경로 개수 찾기 & 최종 결과 출력
        System.out.println(findRoute(0,0));
    }
}