import java.util.*;
import java.io.*;

// SWEA #1493 - 수의 새로운 연산
// Strategy:  
class Solution {
	// hash(x,y): #(x,y)를 구하는 함수
	public static int hash(int x, int y) {
		int cnt=0;
		
		while(x != 1) {
			x--;
			y++;
			cnt++;
		}
		
		int[] arr = new int[y+1];
		arr[0] = 1;
		for(int i=1; i<y+1; i++) {
			arr[i] = arr[i-1] + i-1;
		}
		
		return (arr[y]+cnt);
	}
	
	// ampersand(n): &(n)을 구하는 함수
	public static int[] ampersand(int n) {
		int num = 1;
		int y = 1;
		while(n < num || n >= num+y) {
			num += y;
			y += 1;
		}
		
		int x = 1;
		for(int i=0; i<n-num; i++) {
			x++;
			y--;
		}
		
		return new int[] {x,y};
	}
	
	// star(n1,n2): n1 star n2를 구하는 함수
	public static int star(int n1, int n2) {
		int[] a1 = ampersand(n1);
		int[] a2 = ampersand(n2);
		
		int[] add = {a1[0]+a2[0], a1[1]+a2[1]};
		
		return hash(add[0], add[1]);
	}
	
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		// T: 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// a,b: star 연산을 실행시킬 두 정수
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 결과 저장
			sb.append("#").append(t).append(" ").append(star(a,b)).append("\n");
		}
		
		// 최종 결과 출력
		System.out.println(sb);
    }
}
