import java.util.*;
import java.io.*;

// BJ #21608 - 상어 초등학교
// Strategy: 구현

public class Main {
	static int N;
	static int[][] map;
	static int[] order;
	static Map<Integer, List<Integer>> student;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void addStudent(int s) {
		List<Integer> tmp = student.get(s);
		int r = 0;
		int c = 0;
		
		int max_empty = -1;
		int max_prefer = -1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0) continue;
				
				int empty = 0;
				int prefer = 0;
				for(int k=0; k<4; k++) {
					int nr = i+dr[k];
					int nc = j+dc[k];
					if(nr < 0 || nc < 0 || nr >=N || nc >= N) continue;
					
					if(map[nr][nc] == 0) empty++;
					else if(tmp.contains(map[nr][nc])) prefer++;
				}
				
				
				if(prefer > max_prefer || (prefer == max_prefer && empty > max_empty)) {
					max_prefer = prefer;
					max_empty = empty;
					r = i;
					c = j;
				}
				
			}
		}
		
		map[r][c] = s;
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        order = new int[N*N];
        
        // 만족도 정보 입력
        student = new HashMap<>();
        for(int i=0; i<N*N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	List<Integer> tmp = new ArrayList<>();
        	
        	int s = Integer.parseInt(st.nextToken());
        	
        	order[i] = s;
        	for(int j=0; j<4; j++) {
        		tmp.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	student.put(s, tmp);
        }
        
        // 학생 채우기
        for(int i=0; i<N*N; i++) {
        	addStudent(order[i]);
        }
        
        // 만족도 구하기
        int sum = 0;
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		List<Integer> tmp = student.get(map[i][j]);
        		int prefer = 0;
        		for(int k=0; k<4; k++) {
        			int nr = i+dr[k];
        			int nc = j+dc[k];
        			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
        			if(tmp.contains(map[nr][nc])) prefer++;
        		}
        		
        		switch (prefer) {
				case 1:
					sum += 1; break;
				case 2:
					sum += 10; break;
				case 3:
					sum += 100; break;
				case 4:
					sum += 1000; break;
				default:
					break;
				}
        	}
        }
        
        // 최종 결과 출력
        System.out.println(sum);
	}
}