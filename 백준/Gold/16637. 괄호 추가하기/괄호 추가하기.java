import java.util.*;
import java.io.*;

// BJ #16637 - 괄호 추가하기
// Strategy: 백트래킹?
public class Main {
	static char[] arr;
	static int N, max;
	
	public static int cal(int n1, int n2, char op) {
		switch(op) {
			case '+': return n1+n2;	
			case '-': return n1-n2;
			default : return n1*n2;
		}
	}
	public static void DFS(int idx, int result) {
		if(idx >= N) {
			max = Math.max(max, result);
			return;
		}
		
		// 괄호 생성 x ( 왼쪽으로 괄호 생성하는 경우랑 같음 )
		DFS(idx+2, cal(result, arr[idx]-'0', arr[idx-1]));
		
		// 오른쪽으로 괄호 생성
		if(idx+2 < N) {
			int right = cal(arr[idx]-'0', arr[idx+2]-'0', arr[idx+1]);
			int res = cal(result, right, arr[idx-1]);
			DFS(idx+4, res);
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		arr = s.toCharArray();
		
		max = Integer.MIN_VALUE;
		
		DFS(2,arr[0]-'0');

		System.out.println(max);
	}
}