import java.util.*;
import java.io.*;

// BJ #17825 - 주사위 윷놀이
// Strategy: 구현

public class Main {
	static int max;
	static int[] dice, score, selected, location;
	static boolean[] visited;
	
	public static boolean isMovable(int n) {
		return !(n==21 || n== 30 || n==38 || n==47);
	}
	
	public static int getNext(int now, int d) {
		int next = now+d;
		
		if(now < 21) {
			if(next >= 21) next = 21;
		}else if(now < 30) {
			if(next >= 30) next = 30;
		}else if(now < 38) {
			if(next >= 38) next = 38;
		}else if(now < 47){
			if(next >= 47) next = 47;
		}
		
		if(next == 5) next = 22;
		else if(next == 10) next = 31; 
		else if(next == 15) next = 39;
		
		return next;
	}
	
	public static void setVisited(int idx, boolean check) {
		if(idx==20 || idx==29 || idx==37 || idx==46) {
			visited[20] = check;
			visited[29] = check;
			visited[37] = check;
			visited[46] = check;
		}else if(idx==26 || idx==34 || idx==43) {
			visited[26] = check;
			visited[34] = check;
			visited[43] = check;
		}else if(idx==27 || idx==35 || idx==44) {
			visited[27] = check;
			visited[35] = check;
			visited[44] = check;
		}else if(idx==28 || idx==36 || idx==45) {
			visited[28] = check;
			visited[36] = check;
			visited[45] = check;
		}else {
			visited[idx] = check;
		}
	}
	
	// selected로 선택된 순열에 대해 체크
	public static int check() {
		visited = new boolean[score.length];
		location = new int[4];
		int total = 0;
		
		for(int i=0; i<10; i++) {
			int tmpDice = dice[i];
			int tmpPiece = selected[i];
			if(!isMovable(location[tmpPiece])) return -1;
			
			int next = getNext(location[tmpPiece], tmpDice);
			
			if(isMovable(next)) {
				if(visited[next]) return -1;
				setVisited(location[tmpPiece], false);
				setVisited(next, true);
				location[tmpPiece] = next;
				total += score[next];
			}else {
				setVisited(location[tmpPiece], false);
				location[tmpPiece] = next;
			}
		}

		return total;
	}
	
	// 순열 만들기
	public static void back(int num) {
		if(num == 10) {
			max = Math.max(check(), max);
			return;
		}
		
		for(int i=0; i<4; i++) {
			selected[num] = i;
			back(num+1);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        dice = new int[10];
        for(int i=0; i<10; i++) {
        	dice[i] = Integer.parseInt(st.nextToken());
        }
        
        
        score = new int[] {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,0,	// 0~21
        					10,13,16,19,25,30,35,40,0,	// 22~30
        					20,22,24,25,30,35,40,0,		// 31~38
        					30,28,27,26,25,30,35,40,0};	// 39~47
        						
        						
        selected = new int[10];
        back(0);
        System.out.println(max);
	}
}