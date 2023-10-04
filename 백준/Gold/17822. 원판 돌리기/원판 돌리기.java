import java.util.*;
import java.io.*;

// BJ #17822 - 원판 돌리기
// Strategy: 구현

public class Main {
    static int N,M,T;
    static int[][] nums;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public static void remove() {
    	boolean check = true;
    	int sum = 0;
    	int cnt = 0;
    	
    	int[][] tmp = new int[N][M];
    	for(int[] line: tmp) {
    		Arrays.fill(line, -1);
    	}
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			
    			for(int k=0; k<4; k++) {
    				int nr = i + dr[k];
    				int nc = j + dc[k];
    				
    				if(nr < 0 || nr >= N) continue;
    				if(nc == -1) nc = M-1;
    				if(nc == M) nc = 0;

    				if(nums[i][j] == nums[nr][nc]) {
    					tmp[i][j] = 0;
    					tmp[nr][nc] = 0;
    					if(nums[i][j] != 0) check = false;
    					
    				}else if(tmp[i][j] != 0) {
    					tmp[i][j] = nums[i][j];
    				}
    				
    			}
    		}
    	}
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			if(tmp[i][j] != 0) {
    				cnt++;
    				sum += tmp[i][j];
    			}
    		}
    	}
    	
    	if(check) {
    		double avg = sum/(double)cnt;
    		for(int i=0; i<N; i++) {
        		for(int j=0; j<M; j++) {
        			if(tmp[i][j] == 0) continue;
        			
        			if(tmp[i][j] > avg) {
        				tmp[i][j]--;
        			}else if(tmp[i][j] < avg) {
        				tmp[i][j]++;
        			}
        		}
    		}
    	}
    	
    	nums = tmp;
    }
    
    public static void rotate(int x, int d, int k) {
    	for(int i=0; i<N; i++) {
    		if((i+1) % x == 0) {
    			int[] clone = nums[i].clone();
    			if(d == 0) {
    				for(int j=0; j<M; j++) {
    					nums[i][j] = clone[(M-k+j)%M];
    				}
    			}else {
    				for(int j=0; j<M; j++) {
    					nums[i][j] = clone[(M+k+j)%M];
    				}
    			}
    		}
    	}
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        nums = new int[N][M];
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		nums[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        
        for(int i=0; i<T; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	int k = Integer.parseInt(st.nextToken());
        	
        	rotate(x,d,k);
        	
        	remove();
        }
        
        int sum = 0;
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		sum += nums[i][j];
        	}
        }
        
        System.out.println(sum);
    }
    
}