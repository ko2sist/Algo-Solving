import java.util.*;
import java.io.*;

// BJ #17140 - 이차원 배열과 연산
// Strategy: 구현

public class Main {
    static int R,C,K, time;
    static int numR, numC;
    static int[][] matrix;
    
    public static class Pair implements Comparable<Pair>{
    	int num;
    	int cnt;
    	
		public Pair(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		public int compareTo(Pair o) {
			if(this.cnt != o.cnt) {
				return this.cnt - o.cnt;
			}else {
				return this.num - o.num;
			}
		}
    }
    public static void arrangeMatrix() {
        if(numR >= numC) {    // R연산 실행
            List<Map<Integer, Integer>> mapList = new ArrayList<>();
            int maxC = 0;
            for(int i=0; i<numR; i++) {
            	Map<Integer, Integer> map = new HashMap<>();
            	for(int j=0; j<numC; j++) {
            		if(matrix[i][j] == 0) continue;
            		
            		int tmp = matrix[i][j];
            		if(map.get(tmp) == null) {
            			map.put(tmp, 1);
            		}else {
            			map.put(tmp, map.get(tmp)+1);
            		}
            	}
            	mapList.add(map);
            	if(map.size()*2 > maxC) maxC = map.size()*2;
            }
            
            if(maxC > 100) maxC = 100;
            matrix = new int[numR][maxC];
            numC = maxC;
            
            for(int i=0; i<numR; i++) {
            	PriorityQueue<Pair> pq = new PriorityQueue<>();
            	
            	for(Map.Entry<Integer, Integer> entry : mapList.get(i).entrySet()) {
            		pq.add(new Pair(entry.getKey(), entry.getValue()));
            	}
            	
            	for(int j=0; j<maxC/2; j++) {
            		if(!pq.isEmpty()) {
            			Pair tmp = pq.poll();
            			matrix[i][j*2] = tmp.num;
            			matrix[i][j*2+1] = tmp.cnt;
            		}else {
            			matrix[i][j*2] = 0;
            			matrix[i][j*2+1] = 0;
            		}
            	}
            }
            
            
        }else {                // C연산 실행
            List<Map<Integer, Integer>> mapList = new ArrayList<>();
            int maxR = 0;
            
            for(int i=0; i<numC; i++) {
            	Map<Integer, Integer> map = new HashMap<>();
            	for(int j=0; j<numR; j++) {
            		if(matrix[j][i] == 0) continue;
            		
            		int tmp = matrix[j][i];
            		if(map.get(tmp) == null) {
            			map.put(tmp, 1);
            		}else {
            			map.put(tmp, map.get(tmp)+1);
            		}
            	}
            	mapList.add(map);
            	if(map.size()*2 > maxR) maxR = map.size()*2;
            }
            
            if(maxR > 100) maxR = 100;
            matrix = new int[maxR][numC];
            numR = maxR;
            
            for(int i=0; i<numC; i++) {
            	PriorityQueue<Pair> pq = new PriorityQueue<>();
            	
            	for(Map.Entry<Integer, Integer> entry : mapList.get(i).entrySet()) {
            		pq.add(new Pair(entry.getKey(), entry.getValue()));
            	}
            	
            	for(int j=0; j<maxR/2; j++) {
            		if(!pq.isEmpty()) {
            			Pair tmp = pq.poll();
            			matrix[j*2][i] = tmp.num;
            			matrix[j*2+1][i] = tmp.cnt;
            		}else {
            			matrix[j*2][i] = 0;
            			matrix[j*2+1][i] = 0;
            		}
            	}
            }
        }
    }
    
    public static void getTime() {
        time = 0;
        
        while(true) {
        	if(time == 101) {
            	time = -1;
            	return;
            }
        	
        	if(R > numR || C > numC) {
        		arrangeMatrix();
                time++;
        	}else {
        		if(matrix[R-1][C-1] == K) return;
        		arrangeMatrix();
                time++;
        		
        	}
        	
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        matrix = new int[3][3];
        numR = 3; numC = 3;
        
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        getTime();
        System.out.println(time);
    }
}