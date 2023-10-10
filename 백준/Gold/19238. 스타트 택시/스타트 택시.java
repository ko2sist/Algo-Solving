import java.util.*;
import java.io.*;

// BJ #19238 - 스타트택시
// Strategy: BFS + 구현

public class Main {
    static int N,M,F, fuel;		// 기본 정보 + 잔여 연료 정보
    static int R,C;				// 차량의 현재 위치 관련 정보
    static int cr, cc, cd, cn;	// 태운 승객 관련 정보
    static int add_fuel;		// 승객 이동 후 충전할 연료의 양
    static int[][] map, p;		// 지도, 승객 위치 맵에 표시
    static Person[] people;		// 승객 정보 목록
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public static class Person{
        int sr;
        int sc;
        int er;
        int ec;
        
        public Person(int sr, int sc, int er, int ec) {
            this.sr = sr;
            this.sc = sc;
            this.er = er;
            this.ec = ec;
        }
    }
    
    public static class Point{
        int row;
        int col;
        int dist;
        public Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    
    public static boolean getPerson(int r, int c) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited= new boolean[N][N];
        
        q.add(new Point(r,c,0));
        visited[r][c] = true;
        
        cr = N;
        cc = N;
        cd = (int)1e9;
        cn = 0;
        
        while(!q.isEmpty()) {
            Point tmp = q.poll();
            int tr = tmp.row;
            int tc = tmp.col;
            int td = tmp.dist;
            
            if(p[tr][tc] != 0) {    // 현재 위치에 손님이 존재
            	if(td > cd) break;
            	
            	if(tr < cr) {
            		cr = tr;
            		cc = tc;
            	}
            	else if(tr == cr) {
            		if(tc < cc) cc = tc;
            	}
            	cd = td;
            	cn = p[cr][cc];
            }
            
            for(int i=0; i<4; i++) {
            	int nr = tr + dr[i];
            	int nc = tc + dc[i];
            	if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            	if(visited[nr][nc]) continue;
            	if(map[nr][nc] == 1) continue;
            	
            	q.add(new Point(nr,nc,td+1));
            	visited[nr][nc] = true;	
            }
        }
        
        if(fuel < cd) return false;	// 승객을 태우러 가는데 필요한 연료가 남은 연료보다 많으면 false 반환
        return true;	// 승객을 태우러 갈 수 있으면 true 반환
    }
    
    public static boolean Move(int n) {
    	Person tmp_customer = people[n];
    	int sr = tmp_customer.sr;
    	int sc = tmp_customer.sc;
    	int er = tmp_customer.er;
    	int ec = tmp_customer.ec;
    	add_fuel = (int)1e9;
    	
    	Queue<Point> q = new ArrayDeque<>();
    	boolean[][] visited = new boolean[N][N];
    	
    	q.add(new Point(sr,sc,0));
    	visited[sr][sc] = true;
    	
    	while(!q.isEmpty()) {
    		Point tmp = q.poll();
    		int tr = tmp.row;
    		int tc = tmp.col;
    		int td = tmp.dist;
    		
    		if(tr == er && tc == ec) {
    			add_fuel = td;
    			R = er;		// 승객 구하는 과정의 출발 지점 변경
    			C = ec;
    		}
    		
    		for(int i=0; i<4; i++) {
    			int nr = tr + dr[i];
            	int nc = tc + dc[i];
            	if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            	if(visited[nr][nc]) continue;
            	if(map[nr][nc] == 1) continue;
            	
            	q.add(new Point(nr,nc,td+1));
            	visited[nr][nc] = true;	
    		}
    	}
    	
    	if(add_fuel > fuel) return false;
    	return true;
    }
    
    public static void getFuel() {
        for(int i=0; i<M; i++) {	// M명의 승객 이동
        	// 현재 태울 승객 구하기
        	if(getPerson(R,C)) {
        		fuel -= cd;		// 연료 소모
        		p[cr][cc] = 0;	// 승객 맵에서 삭제
//        		System.out.println(cr + " " + cc + " " + cd);
        	}else {
        		fuel = -1; return;	// -1 출력 할 수 있게 fuel 변경, 종료
        	}
        	
        	// 태운 승객 이동
        	if(Move(cn)) {
        		fuel += add_fuel;	// 연료 소모, 충전 동시에
        	}else {
        		fuel = -1; return;	// -1 출력 할 수 있게 fuel 변경, 종료
        	}
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 기본 정보 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        
        // 지도 정보 입력
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 운전을 시작하는 칸의 행,열 번호 입력
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken())-1;
        C = Integer.parseInt(st.nextToken())-1;
        
        // 각 승객의 출발지 행,열 번호 + 목적지 행,열 번호 입력
        people = new Person[M+1];    // 승객 정보 저장
        p = new int[N][N];            // 지도에서 해당 위치에 몇 번 승객이 있는지 저장
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());
            
            people[i] = new Person(sr-1,sc-1,er-1,ec-1);
            p[sr-1][sc-1] = i;
        }

        // 최종 결과 계산 및 출력
        fuel = F;
        getFuel();
        System.out.println(fuel);
    }
}