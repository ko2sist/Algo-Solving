import java.util.*;
import java.io.*;

// BJ #17779 - 게리맨더링2
// Strategy: 구현

public class Main {
	static int N, total, diff, min = Integer.MAX_VALUE;
	static int[][] map, nums;
	
	public static void check(int r, int c, int d1, int d2) {
		map = new int[N+1][N+1];
		int[] people = new int[5];
		
		// 5번 구역 경계선 체크
		for(int i=0; i<=d1; i++) {
			map[r+i][c-i] = 5;
			map[r+d2+i][c+d2-i] = 5;
		}
		for(int i=0; i<=d2; i++) {
			map[r+i][c+i] = 5;
			map[r+d1+i][c-d1+i] = 5;
		}
		
		// 1번 구역 계산
		for(int i=1; i<r+d1; i++) {
			for(int j=1; j<=c; j++) {
				if(map[i][j] == 5) break;
				people[0] += nums[i][j];
			}
		}
		
		// 2번 구역 인구 계산
		for(int i=1; i<=r+d2; i++) {
			for(int j=N; j>c; j--) {
				if(map[i][j] == 5) break;
				people[1] += nums[i][j];
			}
		}
		
		// 3번 구역 인구 게산
		for(int i=r+d1; i<=N; i++) {
			for(int j=1; j<c-d1+d2; j++) {
				if(map[i][j] == 5) break;
				people[2] += nums[i][j];
			}
		}
		
		// 4번 구역 인구 계산
		for(int i=r+d2+1; i<=N; i++) {
			for(int j=N; j>= c-d1+d2; j--) {
				if(map[i][j] == 5) break;
				people[3] += nums[i][j];
			}
		}
		
		// 5번 구역 인구 계산
		people[4] = total;
		for(int i=0; i<4; i++) {
			people[4] -= people[i];
		}
		
		// diff 계산
		int tmp_min = Integer.MAX_VALUE;
		int tmp_max = Integer.MIN_VALUE;
		for(int i=0; i<5; i++) {
			tmp_min = Math.min(tmp_min, people[i]);
			tmp_max = Math.max(tmp_max, people[i]);
		}
		diff = tmp_max - tmp_min;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        nums = new int[N+1][N+1];
        total = 0;
        
        for(int i=1; i<=N; i++) {
        	StringTokenizer st= new StringTokenizer(br.readLine());
        	for(int j=1; j<=N; j++) {
        		nums[i][j] = Integer.parseInt(st.nextToken());
        		total += nums[i][j];
        	}
        }
        
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=N; j++) {
        		for(int d1=1; d1<=N; d1++) {
        			for(int d2=1; d2<=N; d2++) {
        				if(d1+d2+i > N) continue;
        				if(j-d1 < 1 || j+d2 > N) continue;
        				
        				check(i,j,d1,d2);
        				min = Math.min(diff, min);
        			}
        		}
        	}
        }
        
        System.out.println(min);
        
    }
}