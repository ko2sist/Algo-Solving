import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
//7번과 다른점은 얘는 주어지는 숫자에 중복이 있어서 그거 처리해주는게 필요한 것.
public class Main {
	static int N;
	static int M;
//	static boolean[] visited;	//중복순열이니까 안씀.
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

		dfs(0);		
		System.out.println(sb);

	}

	public static void dfs(int depth) {

		if (depth == M) {
			for (int val : brr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < hash.size(); i++) {		//주의
//			if (i>0 && arr[i-1]==arr[i] && !visited[i-1]) continue;	//
//			if (!visited[i]) {
//				visited[i] = true;
				brr[depth] = arr[i];
				dfs(depth + 1);
//				visited[i] = false;
//			}
		}
	}
}
