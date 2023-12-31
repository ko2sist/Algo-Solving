import java.util.*;
import java.io.*;

// SWEA #1229 - 암호문2
// Strategy : 
public class Solution {
	static StringBuilder sb;
	
	// MyList: 암호문을 저장, 처리하는 사용자 정의 class
	public static class MyList{
		public LinkedList<Integer> list;
		
		public MyList() {
			list = new LinkedList<>();
		}
		
		// insert(x,y,s): 암호문의 x의 위치에 s에 들어있는 y개의 정수 저장
		public void insert(int x, int y, int[] s) {
			for(int i=0; i<y; i++) {
				list.add(i+x, s[i]);
			}
		}
		
		// delete(x,y): 암호문의 x의 위치부터 y개의 숫자 삭제
		public void delete(int x, int y) {
			for(int i=0; i<y; i++) {
				list.remove(x);
			}
		}
		
		// appendSb(t): t번째 테스트케이스의 결과를 sb에 저장
		public void appendSb(int t) {
			sb.append("#"+t).append(" ");
			for(int i=0; i<10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		

		for(int t=1; t<=10; t++) {
			
			// ml: 암호문을 처리하는 사용자 정의 class
			MyList ml = new MyList();
			
			// N: 원본 암호문의 길이
			int N = Integer.parseInt(br.readLine());
			
			// 원본 암호문 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				ml.list.add(Integer.parseInt(st.nextToken()));
			}
			
			// K: 명령어의 개수
			int K = Integer.parseInt(br.readLine());
			
			// 명령어 입력
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<K; i++) {
				char cmd = st.nextToken().charAt(0);		// cmd: 명령어
				int x = Integer.parseInt(st.nextToken());	// 명령어 실행을 위한 인자
				int y = Integer.parseInt(st.nextToken());	// 명령어 실행을 위한 인자
				
				if(cmd == 'I') {	// 명령어 = I
					int[] s = new int[y];
					for(int j=0; j<y; j++) {
						s[j] = Integer.parseInt(st.nextToken());
					}
					
					// Insert 실행
					ml.insert(x, y, s);
				}else if(cmd == 'D') {	// 명령어 = D
					// Delete 실행
					ml.delete(x, y);
				}
				
			}
			
			// 현재 테스트케이스 결과 저장
			ml.appendSb(t);
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
