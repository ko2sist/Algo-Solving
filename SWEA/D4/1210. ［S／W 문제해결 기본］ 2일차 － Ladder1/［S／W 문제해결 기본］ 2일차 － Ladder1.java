import java.util.*;
import java.io.*;


// SWEA #1210 - Ladder 1
// Strategy : 도착지점부터 거꾸로 올라가면서 출발지점 찾기
class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<11; t++) {
			// T: 테스트 케이스 번호
			int T = Integer.parseInt(br.readLine());
			
			// ladder: 사다리 정보를 저장할 배열
			int[][] ladder = new int[100][100];
			
			// 사다리 정보 입력
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 도착지점의 x좌표 찾기
			int x = 0;
			for(int i=0; i<100; i++) {
				if(ladder[99][i] == 2) {
					x = i;
					break;
				}
			}
			
			// 도착지점부터 거꾸로 거슬러 올라가면서 출발지점을 찾는다
			int y = 99;
			while(y > 0) {
				// 거슬러 올라가면서 왼쪽 방향의 가로선을 만나는 경우
				if(x-1 >= 0 && ladder[y][x-1]==1) {
					while(x-1 >= 0 && ladder[y][x-1]==1) {
						x -= 1;
					}
					y--;
					continue;
				}
				
				// 거슬러 올라가면서 오른쪽 방향의 가로선을 만나는 경우
				if(x+1 < 100 && ladder[y][x+1] == 1) {
					while(x+1 < 100 && ladder[y][x+1] == 1) {
						x += 1;
					}
					y--;
					continue;
				}
				
				// 현재 좌표에서 왼쪽, 오른쪽 두 방향 모두 가로선이 없는 경우
				y--;
			}
			
			// 결과 저장
			sb.append("#").append(t).append(" ").append(x).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
