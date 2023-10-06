import java.util.*;
import java.io.*;

// BJ #17837 - 새로운게임 2
// Strategy: 구현

public class Main {
    static int N,K;
    static int[][] color;
    static int[] dr = {-1,0,1,0};  
    static int[] dc = {0,1,0,-1};
    static Piece[] pieces;
    static LinkedList<Integer>[][] map;
    static boolean check;
    
    public static class Piece{
        int row;
        int col;
        int dir;
        
        public Piece(int row, int col, int dir) { 
            this.row = row;
            this.col = col;
            this.dir = dir;
        }

    }
    
    public static int findIdx(int idx) {
    	Piece p = pieces[idx];
    	LinkedList<Integer> tmp = map[p.row][p.col];
        for(int i=0; i<tmp.size(); i++) {
        	if(tmp.get(i) == idx){
        		return i;
        	}
        }
    	return -1;
    }
    
    public static boolean move(int tr, int tc, int nr, int nc, int idx) {
        if(color[nr][nc] == 0) {	// white
        	while(map[tr][tc].size() > idx) {
        		int tmp = map[tr][tc].remove(idx);
        		
        		pieces[tmp].row = nr;
        		pieces[tmp].col = nc;
        		
        		map[nr][nc].add(tmp);
        	}
        }else {		// red
        	while(map[tr][tc].size() > idx) {
        		int tmp = map[tr][tc].removeLast();
        		
        		pieces[tmp].row = nr;
        		pieces[tmp].col = nc;
        		
        		map[nr][nc].add(tmp);
        	}
        }
        
        if(map[nr][nc].size() >= 4) {
        	return true;
        }
    	
    	return false;
    }
    
    public static int getTurn() {
        int turn = 1;
        while(turn <= 1000) {
            for(int i=0; i<K; i++) {
                int idx = findIdx(i);
                Piece tmp = pieces[i];
                int tr = tmp.row;
                int tc = tmp.col;
                int td = tmp.dir;
                
                int nr = tr + dr[td];
                int nc = tc + dc[td];
                
                if(nr <= 0 || nc <= 0 || nr > N || nc > N || color[nr][nc] == 2) {	// blue
                	tmp.dir = (td + 2) % 4;
                	td = tmp.dir;
                	nr = tr + dr[td];
                	nc = tc + dc[td];
                	if(nr <= 0 || nc <= 0 || nr > N || nc > N || color[nr][nc] == 2) 
                		continue;	
                }
                
                if(move(tr,tc,nr,nc,idx)) {
                	return turn;
                }
                
            }
            turn++;
        }
        return -1;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 기본 정보 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 체스판 정보 입력
        color = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 체스말 정보 입력
        pieces = new Piece[K];
        map = new LinkedList[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                map[i][j] = new LinkedList<>();
            }
        }
        
        
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            switch(d){
            	case 1:
            		d = 1;
            		break;
            	case 2:
            		d = 3;
            		break;
            	case 3:
            		d = 0;
            		break;
            	case 4:
            		d = 2;
            		break;
            	default:
            		break;
            }
            
            pieces[i] = new Piece(r,c,d);
            map[r][c].add(i);
        } 

        
        System.out.println(getTurn());
    }
}