import java.io.*;
import java.util.*;

// BJ #18111
public class Main {
	public static class MySet {
		int time;
		int blocks;
		
		public MySet(int time, int blocks) {
			this.time = time;
			this.blocks = blocks;
		}
	}
	public static MySet cal(int[][] heights, int N, int M, int height) {
		int time = 0;
		int blocks = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(heights[i][j]>=height) {
					time += 2*(heights[i][j]-height);
					blocks += heights[i][j]-height;
				}else {
					time += height-heights[i][j];
					blocks -= height-heights[i][j];
				}
			}
		}
		
		return new MySet(time, blocks);
	}
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // N x M 땅의 높이 입력
        int[][] heights = new int[N][M];
        int max_height = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
            	heights[i][j] = tmp;
                if(tmp>=max_height) {
                	max_height =  tmp;
                }
            }
        }
        
        int min_time = Integer.MAX_VALUE;
        int height = 0;
        for(int i=0; i<max_height+1; i++) {
        	MySet s = cal(heights,N,M,i);
        	if(B + s.blocks<0) {
        		continue;
        	}else {
        		if(s.time <= min_time) {
        			min_time = s.time;
        			height = i;
        		}
        	}  
        }
        
        // 최종 결과 출력
        System.out.println(min_time + " " + height);
    }
}