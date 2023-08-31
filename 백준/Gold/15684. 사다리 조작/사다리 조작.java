import java.util.*;
import java.io.*;

// BJ #15684 - 사다리 조작
// Strategy: 
public class Main {
//    static int[][] lines;
    static int N,M,H,min;
    
    public static boolean check(boolean[][] selected) {
        int[][] lines = new int[N+1][H+1];
        
    	for(int i=1; i<N; i++) {
        	for(int j=1; j<=H; j++) {
        		if(selected[i][j]) {
        			lines[i][j] = 1;
        			lines[i+1][j] = -1;
        		}
        	}
        }
    	
    	for(int i=1; i<=N; i++) {
    		int tmp_v = i;
    		for(int tmp_h = 1; tmp_h<=H; tmp_h++) {
    			tmp_v += lines[tmp_v][tmp_h];
    		}
    		
    		if(tmp_v != i ) {
    			return false;
    		}
    	}
        
        return true;
    }
    public static void back(int v, int h, int num, boolean[][] selected) {
        if(v == N && num < min) {
//            for(boolean[] line: selected) {
//                System.out.println(Arrays.toString(line));
//            }
//            System.out.println(num);
            if(check(selected)) {
                min = num;
            }
            return;
        }
        
        if(num >= min) return;
        
        if(!selected[v][h]) {
            selected[v][h] = true;
            if(h == H) {
                back(v+1, 1, num+1, selected);
            }else {
                back(v, h+1, num+1, selected);
            }
            selected[v][h] = false;
            if(h == H) {
                back(v+1, 1, num, selected);
            }else {
                back(v, h+1, num, selected);
            }
        }else {
            if(h == H) {
                back(v+1, 1, num, selected);
            }else {
                back(v, h+1, num, selected);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        
        boolean[][] selected = new boolean[N][H+1];
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            selected[b][a] = true;
        }
        
        min = 4;
        
        back(1,1,0,selected);
        
        if(min == 4) {
            System.out.println(-1);
        }else {
            System.out.println(min);
        }
        
    }
}