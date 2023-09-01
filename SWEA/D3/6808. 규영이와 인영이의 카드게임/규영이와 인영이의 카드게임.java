import java.util.*;
import java.io.*;

// SWEA #6808 - 규영이와 인영이의 카드게임
// Strategy: 백트래킹

public class Solution {
	static int[] Gyu, In;
	static int win, lose;
	
	public static void back(int len, int score_gyu, int score_in, boolean[] visited) {
		if(len == 9) {
			if(score_gyu > score_in) {
				win++;
			}else if(score_gyu < score_in) {
				lose++;
			}
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(Gyu[len] > In[i]) {
					back(len+1, score_gyu+Gyu[len]+In[i], score_in, visited);
				}else {
					back(len+1, score_gyu, score_in+Gyu[len]+In[i], visited);
				}
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 규영, 인영 카드 나누기
			Gyu = new int[9];
			In = new int[9];
			
			Set<Integer> s = new HashSet<>();
			Set<Integer> s1 = new HashSet<>();
			
			for(int i=1; i<=18; i++) {
				s.add(i);
			}
			for(int i=0; i<9; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				s1.add(tmp);
				Gyu[i] = tmp;
			}
			
			s.removeAll(s1);

			Iterator<Integer> iter = s.iterator();
			for(int i=0; i<9; i++) {
				In[i] = iter.next();
			}
			
			
			// 승,패 가지수 구하기
			win = 0;
			lose = 0;
			
			boolean[] visited= new boolean[9];
			
			back(0,0,0,visited);
			
			// 현재 테스트 케이스 결과 출력
			sb.append("#"+t+" ").append(win).append(" ").append(lose).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
