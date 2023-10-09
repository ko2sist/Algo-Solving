import java.util.*;
import java.io.*;

// BJ #20056 - 마법사 상어와 파이어볼
// Strategy: 구현

public class Main {
	static int N,M,K;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	static List<Fireball> balls;
	
	public static class Fireball{
		int row;
		int col;
		int m;
		int s;
		int d;
		
		public Fireball(int row, int col, int m, int s, int d) {
			this.row = row;
			this.col = col;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Fireball [row=" + row + ", col=" + col + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}
	}
	
	public static void move() {
		// map 초기화
		List<Fireball>[][] map = new ArrayList[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		// 파이어볼 이동
		for(int i=0; i<balls.size(); i++) {
			Fireball tmpBall = balls.get(i);
			
			int td = tmpBall.d;
			int ts = tmpBall.s;
			
			int nr = (tmpBall.row + dr[td]*ts) % N;
			int nc = (tmpBall.col + dc[td]*ts) % N;
			
			if(nr < 0) nr += N;
			if(nc < 0) nc += N;
			
			map[nr][nc].add(new Fireball(nr,nc,tmpBall.m,ts,td));
		}
		
		// 파이어볼 합치기 + 나누기
		balls = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				List<Fireball> tmpList = map[i][j];
				
				if(tmpList.size() == 1) {		// 파이어볼이 합쳐지지 않는 경우
					balls.add(tmpList.get(0));
				}
				
				
				else if(tmpList.size() >= 2) {		// 파이어볼이 합쳐지는 경우
					// 합치기
					int sumM = 0;
					int sumS = 0;
					boolean checkOdd = false;
					boolean checkEven = false;
					for(int k=0; k<tmpList.size(); k++) {
						Fireball tmpBall = tmpList.get(k);
						// 합쳐지는 파이어볼 방향 모두 홀수 or 짝수인지 체크
						if(k==0) {
							if(tmpBall.d % 2 == 0) {
								checkEven = true;
							}else {
								checkOdd = true;
							}
						}else {
							if(checkEven) {
								if(tmpBall.d % 2 != 0) {
									checkEven = false;
								}
							}
							if(checkOdd) {
								if(tmpBall.d % 2 == 0) {
									checkOdd = false;
								}
							}
						}
						
						// 질량, 속력 합 구하기
						sumM += tmpBall.m;
						sumS += tmpBall.s;
					}
					
					// 나누기
					int nm = sumM/5;	// 나누어진 파이어볼들의 질량
					int ns = sumS/tmpList.size();	// 나누어진 파이어볼들의 속력
					if(nm == 0) continue;	// 질량이 0인 파이어볼들은 소멸
					
					if(checkEven || checkOdd) {	// 합쳐진 파이어볼의 방향이 모두 짝수 or 홀수
						for(int nd = 0; nd<8; nd+=2) {
							balls.add(new Fireball(i,j,nm,ns,nd));
						}
					}else {	 // 합쳐진 파이어볼의 방향이 모두 짝수 or 홀수가 아님
						for(int nd = 1; nd<8; nd+=2) {
							balls.add(new Fireball(i,j,nm,ns,nd));							
						}
					}
				}
			}
		}
//		System.out.println("balls size: " + balls.size());
//		for(int i=0; i<balls.size(); i++) {
//			System.out.println(balls.get(i));
//		}
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 기본 정보 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 파이어볼 초기 정보 입력
        balls = new ArrayList<>();
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int r = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	int s = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	
        	balls.add(new Fireball(r-1,c-1,m,s,d));
        }
        
        // 파이어볼 K번 이동
        for(int i=0; i<K; i++) {
        	move();
        }
        
        // 남아있는 파이어볼 질량의 합 구하기
        int sum = 0;
        for(int i=0; i<balls.size(); i++) {
        	sum += balls.get(i).m;
        }
        
        // 최종 결과 출력
        System.out.println(sum);
    }
    
}