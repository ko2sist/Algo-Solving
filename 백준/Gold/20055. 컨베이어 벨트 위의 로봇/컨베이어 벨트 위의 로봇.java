import java.util.*;
import java.io.*;

// BJ #20055 - 컨베이어 벨트 위의 로봇
// Strategy: 구현

public class Main {
	static int N, K, zeros;
	static int start, end;
	static int[] durability;
	static boolean[] robot;
	

	public static void lotate() {
		// N-1번 위치에 있는 로봇은 회전 후 내려야함 
		start--;
		end--;
		
		if(start == -1) start = 2*N-1;
		if(end == -1) end = 2*N-1;
		
		for(int i=N-2; i>=0; i--) {
			if(robot[i]) {
				robot[i] = false;
				robot[i+1] = true;
			}
		}
		
		if(robot[N-1]) robot[N-1] = false;
	}
	
	public static void move() {
		// N-1번 ~ 1번 칸 순서대로 로봇 이동
		for(int i=N-2; i>=0; i--) {
			if(robot[i]) {
				int next = (start+i+1) % (2*N);
				
				if(robot[i+1] || durability[next] == 0) continue;
				robot[i] = false;
				robot[i+1] = true;
				durability[next]--;
				if(durability[next] == 0) zeros++;
			}
		}
		
		if(robot[N-1]) robot[N-1] = false;
	}
	
	public static void addRobot() {
		if(robot[0] || durability[start] == 0) return;
		
		robot[0] = true;
		durability[start]--;
		
		if(durability[start] == 0) zeros++;
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 기본 정보 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 내구도 정보 입력
        durability = new int[2*N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	durability[i] = tmp;
        }
        
        robot = new boolean[N];
        
        start = 0;
        end = N-1;
        
        zeros = 0;
        int turn = 0;
        while(zeros < K) {
        	lotate();
        	move();
        	addRobot();
        	turn++;
        }
        
        System.out.println(turn);
	}
}