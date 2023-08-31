import java.util.*;
import java.io.*;

// BJ #16235 - 나무 재테크
// Strategy: PQ를 이용해서 나무의 나이 순으로 정렬, 양분 흡수 관리
public class Main {
	static int N, M, K;
	static int[][] A, nutrient;
	static Trees[][] land;
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	
	public static class Trees{
		PriorityQueue<Integer> ages;
		PriorityQueue<Integer> dead;
		
		public Trees() {
			ages = new PriorityQueue<>();
			dead = new PriorityQueue<>();
		}
	}
	
	public static void Spring() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				PriorityQueue<Integer> pq = new PriorityQueue<>();
				PriorityQueue<Integer> ages = land[i][j].ages;
				PriorityQueue<Integer> dead = land[i][j].dead;
				while(!ages.isEmpty()) {
					int tmp_age = ages.poll();
					if(tmp_age <= nutrient[i][j]) {
						pq.add(tmp_age+1);
						nutrient[i][j] -= tmp_age;
					}else {
						dead.add(tmp_age);
					}
				}
				land[i][j].ages = pq;
			}
		}
	}
	
	public static void Summer() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(land[i][j].ages.size() != 0) {
					PriorityQueue<Integer> pq = new PriorityQueue<>();
					PriorityQueue<Integer> ages = land[i][j].ages;
					
					while(!ages.isEmpty()) {
						int tmp = ages.poll();
						pq.add(tmp);
						if(tmp % 5 == 0) {
							for(int k=0; k<8; k++) {
								int nr = i+dr[k];
								int nc = j+dc[k];
								if(nr <= 0 || nc <= 0 || nr > N || nc > N) continue;
								
								land[nr][nc].ages.add(1);
							}
						}
					}
					land[i][j].ages = pq;
				}
			}
		}
	}
	
	public static void Fall() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				PriorityQueue<Integer> dead = land[i][j].dead;
				while(!dead.isEmpty()) {
					int tmp = dead.poll();
					nutrient[i][j] += tmp/2;
				}
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
	
	public static int getNumTrees() {
		int res = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				res += land[i][j].ages.size();
			}
		}
		return res;
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
        
        // land: 땅의 각 칸에 심어진 나무의 나이를 저장하는 Trees class를 저장하는 배열
        land = new Trees[N+1][N+1];
        
        // A, nutrient 초기 정보 입력 및 land 초기화
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                nutrient[i][j] = 5;
                land[i][j] = new Trees();
            }
        }
        
        // 초기에 심어진 나무의 정보 입력
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());    // r: 나무 위치
            int c = Integer.parseInt(st.nextToken());    // c: 나무 위치
            int age = Integer.parseInt(st.nextToken());    // age: 나무의 나이
            
            land[r][c].ages.add(age);
        }
        
        Invest();
        
        System.out.println(getNumTrees());
    }
}