import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

//같은 조합의 숫자인데 순서만 다른게 존재하면 순열, 없으면 조합이다.

public class Main {
	static int N;
	static int M;
//	static boolean[] visited;	
	static int[] arr;
	static HashSet<Integer> hash;
	static int[] brr;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

//		arr = new int[N];	//위치 주의
		hash= new HashSet<Integer>();
		
		brr = new int[M];
//		visited = new boolean[N];

		for (int i = 0; i < N; i++) {	
			hash.add(sc.nextInt());
		}
		
		arr = new int[hash.size()];	
		Iterator<Integer> iter= hash.iterator();
		
		int idx = 0;
		while(iter.hasNext()) {
			arr[idx++] = iter.next();
		}
		
//		for(int i=0; i<hash.size(); i++) {
//			arr[i] = iter.next();
//		}
		
		Arrays.sort(arr);

		dfs(0, 0);		
		System.out.println(sb);

	}

	public static void dfs(int depth, int st) {

		if (depth == M) {
			for (int val : brr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = st; i < hash.size(); i++) {		//주의
//			if (i>0 && arr[i-1]==arr[i] && !visited[i-1]) continue;	//
//			if (!visited[i]) {
//				visited[i] = true;
				brr[depth] = arr[i];
				dfs(depth + 1, i );
//				visited[i] = false;
//			}
		}
	}
}
