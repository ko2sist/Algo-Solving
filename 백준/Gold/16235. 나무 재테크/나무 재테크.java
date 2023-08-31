import java.util.*;
import java.io.*;

// BJ #16235 - 나무 재테크
// Strategy: deque
public class Main {
	static int N, M, K;
	static int[][] A, nutrient;
	static ArrayDeque<Tree> trees;
	static ArrayDeque<Tree> dead;
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	
	public static class Tree{
		int row;
		int col;
		int age;
		
		public Tree(int row, int col, int age) {
			this.row = row;
			this.col = col;
			this.age = age;
		}
	}
	
	public static void Spring() {
		int size = trees.size();
		
		while(size-- > 0) {
			Tree tmp = trees.pollFirst();
			
			if(tmp.age <= nutrient[tmp.row][tmp.col]) {
				nutrient[tmp.row][tmp.col] -= tmp.age;
				tmp.age++;
				trees.add(tmp);
			}else {
				dead.add(tmp);
			}
		}
	}
	
	public static void Summer() {
		while(!dead.isEmpty()) {
			Tree tmp = dead.poll();
			nutrient[tmp.row][tmp.col] += tmp.age/2;
		}
	}
	
	public static void Fall() {
		ArrayDeque<Tree> dq = new ArrayDeque<>();
		int size = trees.size();
		
		while(size-- > 0) {
			Tree tmp = trees.pollFirst();
			
			if(tmp.age % 5 == 0) {
				dq.add(tmp);
			}
			trees.add(tmp);
		}
		
		while(!dq.isEmpty()) {
			Tree tmp = dq.poll();
			
			for(int i=0; i<8; i++) {
				int nr = tmp.row + dr[i];
				int nc = tmp.col + dc[i];
				if(nr <= 0 || nc <= 0 || nr > N || nc > N) continue;
				trees.addFirst(new Tree(nr,nc,1));
			}
		}
	}
	
	public static void Winter() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				nutrient[i][j] += A[i][j];
			}
		}
	}
	
	public static void Invest() {
		for(int i=0; i<K; i++) {
			Spring();
			Summer();
			Fall();
			Winter();
			
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N,M,K 입력
        N = Integer.parseInt(st.nextToken());    // N: 땅의 크기
        M = Integer.parseInt(st.nextToken());    // M: 묘목의 수
        K = Integer.parseInt(st.nextToken());    // K: 나무를 키우는 년수
        
        // A: 겨울에 추가되는 양분을 저장하는 배열
        A = new int[N+1][N+1];
        
        // nutrient: 땅의 각 칸이 현재 가지고 있는 양분의 정보를 저장하는 배열
        nutrient = new int[N+1][N+1];
        
        // 
        trees = new ArrayDeque<>();
        dead = new ArrayDeque<>();
        
        // A, nutrient 초기 정보 입력 및 land 초기화
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                nutrient[i][j] = 5;
            }
        }
        
        // 초기에 심어진 나무의 정보 입력
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());    // r: 나무 위치
            int y = Integer.parseInt(st.nextToken());    // c: 나무 위치
            int z = Integer.parseInt(st.nextToken());    // age: 나무의 나이
            
            trees.add(new Tree(x,y,z));
        }
        
        Invest();
        
        System.out.println(trees.size());
    }
}