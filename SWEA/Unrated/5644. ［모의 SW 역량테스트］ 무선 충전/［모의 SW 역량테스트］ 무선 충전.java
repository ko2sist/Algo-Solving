import java.io.*;
import java.util.*;

// SWEA #5644 - 무선 충전

public class Solution {
	static int T,M,A,res;
	static int[] moveA, moveB, resA, resB;
	static List<Integer>[][] map;
	static BC[] BCs;
	static int[] dr = {0,-1,0,1,0};
	static int[] dc = {0,0,1,0,-1};
	static int[] number;
	
	public static class BC{
		int row;
		int col;
		int coverage;
		int performance;
		
		public BC(int row, int col, int coverage, int performance) {
			this.row = row;
			this.col = col;
			this.coverage = coverage;
			this.performance = performance;
		}
	}
	
	public static void Area(int n) {
		BC bc = BCs[n];
		int r = bc.row;
		int c = bc.col;
		int coverage = bc.coverage;
		
		for(int i=r-coverage; i<=r+coverage; i++) {
			for(int j=c-coverage; j<= c+coverage; j++) {
				if(i<0 || j< 0 || i>=10 || j>=10) continue;
				
				if(Math.abs(r-i) + Math.abs(c-j) <= coverage) {
					map[i][j].add(n);
				}
			}
		}
	}
	
	public static void getRes() {
		int Ar = 0;
		int Ac = 0;
		int Br = 9;
		int Bc = 9;
		
		for(int t=0; t<=M; t++) {	// M분 동안 이동
			List<Integer> areaA = map[Ar][Ac];
			List<Integer> areaB = map[Br][Bc];
//			System.out.println(Ar+" "+Ac+" "+Br+" "+Bc);
			int max = Integer.MIN_VALUE;
			
			if(areaA.size() != 0 && areaB.size() != 0) {
				for(int i=0; i<areaA.size(); i++) {
					for(int j=0; j<areaB.size(); j++) {
						if(areaA.get(i) == areaB.get(j)) {
							max = Math.max(max, BCs[areaA.get(i)].performance);
						}else {
							max = Math.max(max, BCs[areaA.get(i)].performance + BCs[areaB.get(j)].performance);
						}
					}
				}
			}else if(areaA.size() == 0 && areaB.size() == 0) {
				max = 0;
			}else if(areaA.size() != 0 && areaB.size() == 0){
				for(int i=0; i<areaA.size(); i++) {
					max = Math.max(max, BCs[areaA.get(i)].performance);
				}
			}else if(areaA.size() == 0 && areaB.size() != 0){
				for(int i=0; i<areaB.size(); i++) {
					max = Math.max(max, BCs[areaB.get(i)].performance);
				}
			}
			
			
//			System.out.println(max);
			res += max;
			
			if(t != M) {
				Ar += dr[moveA[t]];
				Ac += dc[moveA[t]];
				Br += dr[moveB[t]];
				Bc += dc[moveB[t]];
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트 케이스 개수
		T = Integer.parseInt(br.readLine());
	
		// 테스트 케이스 실행
		for(int t=1; t<=T; t++) {
			
			// 기본 정보 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());	// 총 이동시간
			A = Integer.parseInt(st.nextToken());	// BC의 개수
			
			// A,B 이동 정보 입력
			StringTokenizer stA = new StringTokenizer(br.readLine());
			StringTokenizer stB = new StringTokenizer(br.readLine());
			moveA = new int[M];
			moveB = new int[M];
			for(int i=0; i<M; i++) {
				moveA[i] = Integer.parseInt(stA.nextToken());
				moveB[i] = Integer.parseInt(stB.nextToken());
			}
			
			// BC 정보 입력
			BCs = new BC[A];
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken())-1;
				int r = Integer.parseInt(st.nextToken())-1;
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				BCs[i] = new BC(r,c,C,P);
			}
			
			// 구역 저장하기
			map = new ArrayList[10][10];
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			for(int i=0; i<A; i++) {
				Area(i);
			}
			
			
			// 현재 테스트 케이스 결과 계산
			res = 0;
			
			getRes();
			
			// 현재 테스트 케이스 결과 저장
			sb.append("#"+t+" ").append(res).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
