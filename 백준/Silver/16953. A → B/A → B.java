import java.util.*;
import java.io.*;

// BJ #16953 - A->B
// Strategy: BFS
public class Main {
	public static class Pair{
		int num;
		int op;
		
		public Pair(int num, int op) {
			this.num = num;
			this.op = op;
		}
	}
	
	public static int BFS(int A, int B) {
		Queue<Pair> q = new LinkedList<>();
		boolean[] visited = new boolean[1000000001];
		
		q.add(new Pair(A,1));
		visited[A] = true;
		
		while(!q.isEmpty()) {
			Pair tmp = q.poll();
			long tn = tmp.num;
			int to = tmp.op;
			
			if(tn * 2 == B || tn*10 + 1 == B) return to+1;
			
			if(tn * 2 < B && !visited[(int)tn*2]) {
				q.add(new Pair((int)tn*2, to+1));
				visited[(int)tn*2] = true;
			}
			
			if(tn*10 + 1 < B && !visited[(int)tn*10+1]) {
				q.add(new Pair((int)tn*10+1, to+1));
				visited[(int)tn*10+1] = true;
			}
					
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		
		System.out.println(BFS(A,B));
	}
}