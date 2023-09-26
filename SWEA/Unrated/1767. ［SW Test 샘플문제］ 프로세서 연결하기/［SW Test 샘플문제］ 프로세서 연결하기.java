import java.util.*;
import java.io.*;

// SWEA #1767 - 프로세서 연결하기
// Strategy: DFS, 백트래킹

public class Solution {
    static int N, L, size, minLen;
    static int[][] map;
    static List<Point> cores;
    static boolean[] used;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public static class Point{
        int row;
        int col;
        
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    // 전선 최소 길이 구하는 method
    public static void getLen(int idx, int len) {
        // 모든 코어를 확인 했으면 종료
    	if(idx == size) {
        	if(len < minLen) minLen = len;	// 최소 길이 갱신
        	return;
        }
        
    	// 사용하지 않는 코어면 다음 코어로 넘기기
        if(!used[idx]) getLen(idx+1, len);
        
        // 4방향에 대해 가장자리에 도달할 수 있는지 체크
        for(int i=0; i<4; i++) {
        	Point tmp = cores.get(idx);
        	int r = tmp.row;
        	int c = tmp.col;
        	int cnt = 0;
        	boolean check = false;
        	
        	while(true) {
        		r += dr[i];
        		c += dc[i];
        		
        		// 가장자리에 도달 했을 때
        		if(r < 0 || c < 0 || r >= N || c >= N) {
        			check = true;
        			break;
        		}
        		
        		// 가장자리에 도달하기전 전선이나 코어를 만났을 경우
        		if(map[r][c] != 0) break;
        		
        		// 전선을 설치할 수 있을 경우
        		map[r][c] = -1;		// 전선 체크
        		cnt++;				// 전선 길이 증가
        	}
        	
        	// 가장자리까지 전선을 연결했으면 다음 코어에서 같은 과정 진행
        	if(check) getLen(idx+1, len+cnt);
        	
        	// 전선 체크 해제
        	while(true) {
        		r -= dr[i];
        		c -= dc[i];
        		if(r == tmp.row && c == tmp.col) break;
        		map[r][c] = 0;
        	}
        }
    	
    	
    }
    
    public static void back(int num, int idx) {
        // 목표한 코어 사용 개수에 도달 했을 경우
    	if(num == L) {
        	getLen(0,0);	// 최소 길이 구하기
        	return;
        }
        
        for(int i=idx; i<size; i++) {
        	used[i] = true;
        	back(num+1, i+1);
        	used[i] = false;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        
        // T: 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());
        
        // 테스트 케이스 실행
        for(int t=1; t<=T; t++) {
            
            // N: 프로세서 크기
            N = Integer.parseInt(br.readLine());
            
            // cores: 코어의 위치를 저장할 Arraylist(단, 가장가리에 위치한 core는 저장 x)
            cores = new ArrayList<>();
            
            // 멕시노스 초기 상태 입력
            map = new int[N][N];
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1 && i != 0 && j != 0) {
                    	cores.add(new Point(i,j));
                    }
                }
            }
            
            // 사용하는 코어 개수를 1씩 줄여가며 전선을 설치할 수 있는지 확인
            size = cores.size();			// 가장자리에 있지 않은 코어의 개수
            used = new boolean[size];		// 코어를 연결할 것인지 저장하는 배열
            minLen = Integer.MAX_VALUE;		// 전선 최소 길이 저장
            for(L = size; L>=0; L--) {
            	back(0,0);
            	if(minLen != Integer.MAX_VALUE) break;	// minLen이 갱신되었으면 종료
            }
            
            // 현재 테스트 케이스 결과 저장
            sb.append("#"+t+" ").append(minLen).append("\n");
            
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}