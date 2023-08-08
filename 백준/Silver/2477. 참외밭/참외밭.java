import java.util.*;
import java.io.*;

// BJ #2477 - 참외밭
// Strategy: 방향 별로 6각형의 각 변 길이 저장, 
//      저장하면서 반시계 방향과 맞지 않는 방향일 경우 내부 직사각형의 가로, 세로 정보를 알 수 있음
//      전부 입력 받을 때까지 방향이 어긋나지 않으면 처음, 끝에 입력 받은 길이가 내부의 가로,세로
// 		1번씩만 등장한 방향의 길이는 외부 직사각형의 가로, 세로가 된다.
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ratio: 단위 면적 당 자라는 참외 개수
		int ratio = Integer.parseInt(br.readLine());
		
		// 육각형 정보를 저장할 ArrayList
		List<List<Integer>> list = new ArrayList<>();
		for(int i=0; i<5; i++) {
			list.add(new ArrayList<>());
		}
		
		// d: 
		int prev_d = 0;
		int prev_len = 0;
		
		// big: 외부 직사각형의 넓이
		// small: 내부 직사각형의 넓이
		int big = 1;
		int small = 0;
		
		int first_len = 0;
				
		// 육각형 정보 입력, 저장
		for(int i=0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			
			if(prev_d == 1) {
				if(dir != 4) {
					small = prev_len * len;
				}
			}else if(prev_d == 2) {
				if(dir != 3) {
					small = prev_len * len;
				}
			}else if(prev_d == 3) {
				if(dir != 1) {
					small = prev_len * len;
				}
			}else if(prev_d == 4) {
				if(dir != 2) {
					small = prev_len * len;
				}
			}
			
			
			if(i==0) {
				first_len = len;
			}else if(i==5 && small==0){
				small = len*first_len;
			}
			
			list.get(dir).add(len);
			prev_d = dir;
			prev_len = len;
		}
		
		

		for(int i=1; i<5; i++) {
			List<Integer> tmp = list.get(i);
			// 1번 등장한 방향, 외부 직사각형의 가로,세로를 구한다.
			if(tmp.size() == 1) {
				big *= tmp.get(0);
			}
		}
		
		// 최종 결과 출력
		System.out.println((big-small)*ratio);

	}
}
