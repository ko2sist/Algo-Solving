import java.util.*;
import java.io.*;

// BJ #1202 - 보석 도둑
// Strategy: 


public class Main {
	public static class Jewel implements Comparable<Jewel>{
		int M;
		int V;
		
		public Jewel(int m, int v) {
			M = m;
			V = v;
		}

		@Override
		public int compareTo(Jewel o) {
			if(this.V == o.V) {
				return o.M - this.M;
			}else {
				return this.V - o.V;
			}
		}

		@Override
		public String toString() {
			return "Jewel [M=" + M + ", V=" + V + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Jewel> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int Mi = Integer.parseInt(st.nextToken());
			int Vi = Integer.parseInt(st.nextToken());
			
			list.add(new Jewel(Mi,Vi));
		}
		Collections.sort(list, (a,b)->a.M-b.M);
		
		int[] C = new int[K];
		for(int i=0; i<K; i++) {
			int Ci = Integer.parseInt(br.readLine());
			C[i] = Ci;
		}
		Arrays.sort(C);
		
//		System.out.println(list);
//		System.out.println(Arrays.toString(C));
		

		long sum = 0;
		int idx = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for(int i=0; i<K; i++) {
			while(idx < N && list.get(idx).M <= C[i]) {
				pq.add(list.get(idx++).V);
			}
			if(!pq.isEmpty()) {
				sum += pq.poll();
			}
		}
		
		System.out.println(sum);
	}
}