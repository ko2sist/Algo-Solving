import java.util.*;
import java.io.*;

// BJ #17143 - 낚시왕
// Strategy: 구현

public class Main {
    static int R,C,M, res;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static Shark[][] map;
    static Queue<Shark> sharkQueue;
    
    public static class Shark{
        int row;
        int col;
        int speed;
        int dir;
        int size;
        
        public Shark(int row, int col, int speed, int dir, int size) {
            this.row = row;
            this.col = col;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }

		@Override
		public String toString() {
			return "Shark [row=" + row + ", col=" + col + ", speed=" + speed + ", dir=" + dir + ", size=" + size + "]";
		}
        
        
    }
    public static void moveShark() {
        Shark[][] tmp_map = new Shark[R+1][C+1];
        for(int i=1; i<=R; i++) {
            for(int j=1; j<=C; j++) {
                if(map[i][j] != null) {
//                	System.out.println(i+" "+j);
                    Shark tmp = map[i][j];
                    int td = tmp.dir;
                    int r = tmp.row;
                    int c = tmp.col;
                    int speed = tmp.speed;
                    int size = tmp.size;
                    
                    if(td == 0 || td == 2) {
                        while(speed-- > 0) {
                        	if((r == 1 && td == 0 )|| (r == R && td == 2)) {
                        		td = (td+2)%4;
                        	}
                        	
                        	r += dr[td];
                        }
                        
                    }else {
                    	while(speed-- > 0) {
                    		if((c == 1 && td == 3) || (c == C && td == 1)) {
                    			td = (td+2)%4;
                    		}
                    		
                    		c += dc[td];
                    	}
                    }
                    
                    // 이동을 마친 후 그 칸에 이미 상어가 존재할 때
                    if(tmp_map[r][c] != null) {
                        Shark other = tmp_map[r][c];
                        // 원래 있던 상어보다 사이즈가 크면 갱신
                        if(size > other.size) {
                            tmp_map[r][c] = new Shark(r,c,tmp.speed,td,size);
                        }
                    }else {
                    	tmp_map[r][c] = new Shark(r,c,tmp.speed, td, size);
                    }
                    
                }
            }
        }
        
        map = tmp_map;
        
//        for(int i=1; i<=R; i++) {
//            map[i] = tmp_map[i].clone();
//        }
    }
    
    public static void getShark() {
        for(int i=1; i<=C; i++) {
            for(int j=1; j<=R; j++) {
                if(map[j][i] != null) {
                    res += map[j][i].size;
                    map[j][i] = null;
                    break;
                }
            }
            
            moveShark();
//            System.out.println("res: " + res);
//            
//            for(int j=1; j<=R; j++) {
//            	for(int k=1; k<=C; k++) {
//            		System.out.print(map[j][k]+" ");
//            	}
//            	System.out.println();
//            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 기본 정보 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 상어 정보 입력
        map = new Shark[R+1][C+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            switch (d) {
            case 1:
                d = 0;
                break;
            case 2:
                d = 2;
                break;
            case 3:
                d = 1;
                break;
            case 4:
                d = 3;
                break;
            default:
                break;
            }
            map[r][c] = new Shark(r,c,s,d,z);
        }
        
        // 상어 잡이
        res = 0;
        getShark();
        
        // 결과 출력
        System.out.println(res);
    }
    
}