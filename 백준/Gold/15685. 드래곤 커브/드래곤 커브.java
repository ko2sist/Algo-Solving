import java.util.*;
import java.io.*;

// BJ #15685 - 드래곤 커브
// Strategy: 구현

public class Main {
	static int[] dr = {0,-1,0,1};
	static int[] dc = {1,0,-1,0};
	static List<Integer> list;
	static boolean[][] map;
	
	public static List<Integer> getDirections(int d, int g) {
		List<Integer> res = new ArrayList<>();
		
		if(g == 0) {
			res.add(d);
			return res;
		}
		
		List<Integer> tmp = getDirections(d,g-1);
		for(int i=0; i<tmp.size(); i++) {
			res.add(tmp.get(i));
		}
		for(int i=0; i<tmp.size();i++) {
			res.add((tmp.get(tmp.size()-1-i) + 1) % 4);
		}
		return res;
		
	}
	
	public static void drawCurve(int r, int c, List<Integer> dirs) {
		map[r][c] = true;
		
		for(int i=0; i<dirs.size(); i++) {
			int td = dirs.get(i);
			r += dr[td];
			c += dc[td];
			
			if(r < 0 || c < 0 || r >= 101 || c >= 101) continue;
			
			map[r][c] = true;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        map = new boolean[101][101];
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int c = Integer.parseInt(st.nextToken());
        	int r = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	int g = Integer.parseInt(st.nextToken());
        	
        	drawCurve(r,c,getDirections(d,g));
        }
        
        
        
        int cnt = 0;
        for(int i=0; i<100; i++) {
        	for(int j=0; j<100; j++) {
        		if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
        			cnt++;
        		}
        	}
        }
        
        System.out.println(cnt);
    }
}