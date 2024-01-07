import java.io.*;
import java.util.*;

// BJ #2668 - 숫자고르기
// Strategy: DFS
public class Main {
	static int N, result;
	static int[] arr;
	static boolean[] visited;
	static List<Integer> list;
	
	public static void DFS(int start, int next) {
		if(!visited[arr[start]]) {
			visited[arr[start]] = true;
			DFS(arr[start], next);
			visited[arr[start]] = false;
		}
		
		if(arr[start] == next) list.add(next);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// N : 숫자 개수
		N = Integer.parseInt(br.readLine());
		
		// 둘째 줄 정보 입력
		arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 방문 배열
		visited = new boolean[N+1];
		
		// 사이클이 완성된 번호를 담을 list
		list = new ArrayList<>();
		
		// DFS로 사이클 찾기
		for(int i=1; i<=N; i++) {
			visited[i] = true;
			DFS(i,i);
			visited[i] = false;
		}
		
		// 결과 출력
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(list.size());
		System.out.println(sb);
		
	}

}