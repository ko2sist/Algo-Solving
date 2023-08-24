import java.util.*;
import java.io.*;

// BJ #21609 - 상어 중학교
// Strategy: BFS + a
public class Main {
	static final int BLANK = 10;
    static int res;
    static int[][] table;
    static int N, M;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    // Pair: BFS를 사용하는 method의 queue를 위한 class
    public static class Pair{
    	int row;
    	int column;
    	
		public Pair(int row, int column) {
			this.row = row;
			this.column = column;
		}
    }
    
    // GroupInfo: 블록 그룹의 정보를 저장, 삭제 우선순위를 결정할 때에도 사용
    public static class GroupInfo implements Comparable<GroupInfo>{
        int size;
        int rainbow;
        int row;
        int column;
        int color;
        
        public GroupInfo(int size, int rainbow, int row, int coloumn, int color) {
            this.size = size;
            this.rainbow = rainbow;
            this.row = row;
            this.column = coloumn;
            this.color = color;
        }

        @Override
        public int compareTo(GroupInfo o) {
            if(this.size != o.size) {
                return this.size - o.size;
            }else if(this.rainbow != o.rainbow) {
                return this.rainbow - o.rainbow;
            }else if(this.row != o.row) {
                return this.row - o.row;
            }else {
                return this.column - o.column;
            }
        }
    }
    
    // GetInfo(r,c): table[r][c]에서 시작하는 그룹의 정보를 반환 
    public static GroupInfo GetInfo(int r, int c) {		// BFS 사용
        int size = 0;    
        int rainbow = 0;
        int row = 0;
        int column = 0;
        int color = table[r][c];
        boolean[][] visited_rainbow = new boolean[N][N];
        
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(r,c));
        visited[r][c] = true;
        size = 1;
        row = r;
        column = c;
        
        
        while(!q.isEmpty()) {
        	Pair tmp = q.poll();
        	
        	for(int i=0; i<4; i++) {
        		int nr = tmp.row + dr[i];
        		int nc = tmp.column + dc[i];
        		
        		if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
        		if(visited[nr][nc] || visited_rainbow[nr][nc]) continue;
        		if(table[nr][nc] != 0 && table[nr][nc] != color) continue;
        		
        		q.add(new Pair(nr,nc));
        		size++;
        			
        		if(table[nr][nc] == 0) {   
        			rainbow++;
        			visited_rainbow[nr][nc] = true;
        		}else {
        			visited[nr][nc] = true;
        			if(nr < row || (nr == row && nc < column)) {
            			row = nr;
            			column = nc;
            		}
        		}
        		
        		
        		
        	}
        }
        return new GroupInfo(size, rainbow, row, column, color);
    }
    
    // findGroup(): 현재 table에서 가장 큰 group의 정보를 반환
    public static GroupInfo findGroup() {        // BFS 사용
        GroupInfo max = new GroupInfo(0,0,N,N,0);
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && table[i][j] >= 1 && table[i][j] <= M) {
                	GroupInfo gi = GetInfo(i,j);
                    if(gi.compareTo(max)>0) {
                        max = gi;
                    }
                }
            }
        }

        if(max.size < 2) {	// 크기가 2이상인 그룹 존재 x
        	return null;
        }
        return max;
    }
    
    // removeGroup(r,c): table[r][c] 에서 시작하는 group 삭제
    public static void removeGroup(GroupInfo gi) {
    	int r = gi.row;
    	int c = gi.column;
    	int size = gi.size;
    	int color = gi.color;
    	
    	Queue<Pair> q = new LinkedList<>();
    	
    	q.add(new Pair(r,c));
        
        while(!q.isEmpty()) {
        	Pair tmp = q.poll();
        	
        	for(int i=0; i<4; i++) {
        		int nr = tmp.row + dr[i];
        		int nc = tmp.column + dc[i];
        		
        		if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
        		if(table[nr][nc] != 0 && table[nr][nc] != color) continue;
        		
        		q.add(new Pair(nr,nc));
        		table[nr][nc] = BLANK;
        		
        		
        	}
        }
        res += size*size;
    }
    
    // gravity(): table에 중력 적용하는 method
    public static void gravity() {
    	
        for(int i=0; i<N; i++) {
        	int idx = 0;
        	Stack<Integer> s = new Stack<>();
        	for(int j=0; j<=N; j++) {
        		if(j == N || table[j][i] == -1) {	// 현재 블럭이 검은 블럭일 경우 + 현재 열에 검은 블럭이 없을 경우
        			for(int k=j-1; k>=idx; k--) {
        				if(!s.isEmpty()) {
        					table[k][i] = s.pop();
        				}else {
        					table[k][i] = BLANK;
        				}
        			}
        			idx = j+1;
        		}else if(table[j][i] != BLANK){		// 현재 블럭이 일반, 무지개 블럭일 경우
        			s.add(table[j][i]);
        		}
        	}
        }
    }
    
    // rotate(): table을 반시계 방향 90도 회전시키는 method
    public static void rotate() {
        int[][] tmp = new int[N][N];
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		tmp[i][j] = table[j][N-1-i];
        	}
        }
        
        table = tmp;
    }
    
    // Game(): 게임 오토 플레이
    public static void Game() {
        while(true) {
        	visited = new boolean[N][N];
            GroupInfo g = findGroup();
            if(g == null) break;
            removeGroup(g);
            gravity();
            rotate();
            gravity();    
        }    
    }
    
    // Code for Debug
    public static void debug() {
    	visited = new boolean[N][N];
        
        // Code for Debug
        GroupInfo tmp = findGroup();
        System.out.println(tmp.size);
        System.out.println(tmp.rainbow);
        System.out.println(tmp.row);
        System.out.println(tmp.column);
        System.out.println(tmp.color);
        System.out.println();
        System.out.println();
        
        removeGroup(tmp);
        
        for(int[] line: table) {
        	System.out.println(Arrays.toString(line));
        }
        
        gravity();
        System.out.println();
        System.out.println();
        
        for(int[] line: table) {
        	System.out.println(Arrays.toString(line));
        }
        
        rotate();
        System.out.println();
        System.out.println();
        
        for(int[] line: table) {
        	System.out.println(Arrays.toString(line));
        }
        
        gravity();
        System.out.println();
        System.out.println();
        
        for(int[] line: table) {
        	System.out.println(Arrays.toString(line));
        }
        System.out.println();
        System.out.println();
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        table = new int[N][N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        res = 0;   
        
        // 오토 플레이 실행
        Game();
        
        // 최종 결과 출력
        System.out.println(res);
    }
}