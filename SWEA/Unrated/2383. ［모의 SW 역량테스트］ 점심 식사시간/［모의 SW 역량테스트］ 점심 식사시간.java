import java.util.*;
import java.io.*;

// SWEA #2383 - 점심 식사시간
// Strategy: 

public class Solution {
	static int N, min;
	static int[][] map;
	static List<int[]> student, stair;
	
	// cal(selected): 선택된 경우에서 모든 이동이 완료될 때까지의 시간을 구하는 함수
	public static int cal(int[] selected) {
		// pq에 학생과 계단 사이의 거리들을 저장
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		
		// 거리 저장하기
		for(int i=0; i<student.size(); i++) {
			int[] tmp_student = student.get(i);
			
			if(selected[i] == 1) {
				int[] tmp_stair = stair.get(0);
				pq1.add(Math.abs(tmp_student[0]-tmp_stair[0]) + Math.abs(tmp_student[1]-tmp_stair[1]));
			}else {
				int[] tmp_stair = stair.get(1);
				pq2.add(Math.abs(tmp_student[0]-tmp_stair[0]) + Math.abs(tmp_student[1]-tmp_stair[1]));
			}
		}
		
		// 계단을 내려가는데 걸리는 시간
		int t1 = stair.get(0)[2];
		int t2 = stair.get(1)[2];
		
		
		// 저장된 거리를 이용, 계단을 내려가는 시간 계산
		Queue<Integer> stair1 = new ArrayDeque<>();
		Queue<Integer> stair2 = new ArrayDeque<>();
		for(int time=1; time<=500; time++) {
			// 계단을 다 내려간 학생 제거
			while(!stair1.isEmpty() && stair1.peek() <= time) {
				stair1.poll();
			}
			while(!stair2.isEmpty() && stair2.peek() <= time) {
				stair2.poll();
			}
			
			if(pq1.isEmpty() && pq2.isEmpty() && stair1.isEmpty() && stair2.isEmpty()) {
				return time;
			}
			
			// 현재 계단을 내려가는 사람의 수가 3명 미만이고, 대기중인 학생이 있는 경우 계단에 학생 추가
			while(!pq1.isEmpty() && stair1.size() < 3 && pq1.peek() < time) {
				pq1.poll();
				stair1.add(time+t1);
			}
			while(!pq2.isEmpty() && stair2.size() < 3 && pq2.peek() < time) {
				pq2.poll();
				stair2.add(time+t2);
			}
			
		}
		return 0;
	}
	
	// back(num, selected): 경우의 수를 나누는 함수
	public static void back(int num, int[] selected) {
		if(num == student.size()) {
			int time = cal(selected);
			if(time < min) min = time;
			return;
		}
		
		// num번째 학생이 1번 계단을 골랐을 경우
		selected[num] = 1;
		back(num+1, selected);
		
		// num번째 학생이 2번 계단을 골랐을 경우
		selected[num] = 2;
		back(num+1, selected);
		
		
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // T: 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
        	
        	// N: 지도 크기
        	N = Integer.parseInt(br.readLine());
        	
        	// 지도 입력, 학생/계단 위치 정보 저장
        	map = new int[N][N];
        	student = new ArrayList<>();
        	stair = new ArrayList<>();
        	for(int i=0; i<N; i++){
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int j=0; j<N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        			if(map[i][j] == 1) {
        				student.add(new int[] {i,j});
        			}else if(map[i][j] != 0) {
        				stair.add(new int[] {i,j, map[i][j]});
        			}
        		}
        	}
        	
        	min = Integer.MAX_VALUE;
        	
        	back(0, new int[student.size()]);
        	
        	// 현재 테스트 케이스 결과 저장
        	sb.append("#"+t).append(" ").append(min).append("\n");
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}