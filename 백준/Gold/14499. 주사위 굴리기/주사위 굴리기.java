import java.util.*;
import java.io.*;

// BJ #14499 - 주사위 굴리기
// Strategy: 
public class Main {
	static int[] dr = {0,0,0,-1,1};
	static int[] dc = {0,1,-1,0,0};
	
	public static class Dice{
		int up;
		int down;
		int front;
		int back;
		int left;
		int right;
		
		public Dice() {
			this.up = 0;
			this.down = 0;
			this.front = 0;
			this.back = 0;
			this.left = 0;
			this.right = 0;
		}
		
		public void east() {
			int tmp = this.down;
			down = right;
			right = up;
			up = left;
			left = tmp;
		}
		
		public void west() {
			int tmp = this.down;
			down = left;
			left = up;
			up = right;
			right = tmp;
		}
		
		public void north() {
			int tmp = down;
			down = back;
			back = up;
			up = front;
			front = tmp;
		}
		
		public void south() {
			int tmp = down;
			down = front;
			front = up;
			up = back;
			back = tmp;
		}
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        Dice dice = new Dice();
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
        	int cmd = Integer.parseInt(st.nextToken());
        	
        	int nr = x + dr[cmd];
        	int nc = y + dc[cmd];
        	
        	if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
        	
        	if(cmd == 1) {
        		dice.east();
        	}else if(cmd == 2) {
        		dice.west();
        	}else if(cmd == 3) {
        		dice.north();
        	}else {
        		dice.south();
        	}
        	
        	if(map[nr][nc] == 0) {
        		map[nr][nc] = dice.down;
        	}else {
        		dice.down = map[nr][nc];
        		map[nr][nc] = 0;
        	}
        	
        	sb.append(dice.up).append("\n");
        	
        	x = nr;
        	y = nc;
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}